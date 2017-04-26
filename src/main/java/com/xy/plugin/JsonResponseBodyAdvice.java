package com.xy.plugin;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.jaxrs.cfg.AnnotationBundleKey;
import com.fasterxml.jackson.jaxrs.util.ClassKey;
import com.xy.annotation.JsonFilter;

/**
 * 返回结果json字段过滤
 * 
 * @author xiongyan
 * @date 2017年3月22日 下午4:29:00
 */
@ControllerAdvice
public class JsonResponseBodyAdvice<T> implements ResponseBodyAdvice<T> {
	
	private static final Map<Integer, ObjectMapper> objectMapperMap = new ConcurrentHashMap<Integer, ObjectMapper>();
	
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return AbstractJackson2HttpMessageConverter.class.isAssignableFrom(converterType);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T beforeBodyWrite(T body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
		HttpServletRequest servletRequest = ((ServletServerHttpRequest) request).getServletRequest();
		String jsonpFunction = servletRequest.getParameter("callback");
		
		JsonFilter jsonFilter = returnType.getMethodAnnotation(JsonFilter.class);
		if (null != jsonFilter) {
			ClassAnnotationKey key = new ClassAnnotationKey(selectedConverterType, returnType.getMethodAnnotations());
			ObjectMapper objectMapper = objectMapperMap.get(key.hashCode());
			if (null == objectMapper) {
				objectMapper = new ObjectMapper();
				objectMapperMap.put(key.hashCode(), objectMapper);
				
				Class<?>[] mixins = jsonFilter.mixins();
				Class<?>[] targets = jsonFilter.targets();
				
				if (null != mixins && null != targets && mixins.length == targets.length) {
					for (int i=0; i<targets.length; i++) {
						objectMapper.addMixIn(targets[i], mixins[i]);
					}
				}
			}
			
			try {
				ObjectWriter writer = objectMapper.writer();
				JsonGenerator generator = writer.getFactory().createGenerator(response.getBody(), JsonEncoding.UTF8);
				if (!StringUtils.isEmpty(jsonpFunction)) {
					generator.writeRaw("/**/");
					generator.writeRaw(jsonpFunction + "(" );
				}
				writer.writeValue(generator, body);
				if (!StringUtils.isEmpty(jsonpFunction)) {
					generator.writeRaw(");");
				}
				generator.flush();
				return null;
			} catch (IOException e) {
			}
		}
		
		if (!StringUtils.isEmpty(jsonpFunction)) {
			MappingJacksonValue bodyContainer = new MappingJacksonValue(body);
			MediaType mediaType = new MediaType("application", "javascript");
			response.getHeaders().setContentType(mediaType);
			bodyContainer.setJsonpFunction(jsonpFunction);
			return (T) bodyContainer;
		}
		return body;
	}
	
	private static class ClassAnnotationKey {
		private AnnotationBundleKey annotations;
		private ClassKey classKey;
		private int hash;

		private ClassAnnotationKey(Class<?> clazz, Annotation[] annotations) {
			this.annotations = new AnnotationBundleKey(annotations, AnnotationBundleKey.class);
			this.classKey = new ClassKey(clazz);
			hash = this.annotations.hashCode();
			hash = 31 * hash + classKey.hashCode();
		}

		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			ClassAnnotationKey that = (ClassAnnotationKey) o;
			if (!annotations.equals(that.annotations))
				return false;
			if (!classKey.equals(that.classKey))
				return false;
			return true;
		}

		public int hashCode() {
			return hash;
		}
	}
	
}
