package com.xy.interceptor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.xy.annotation.Signature;

/**
 * 签名验签拦截器
 * 
 * @author xiongyan
 * @date 2017年3月9日 上午9:53:40
 */
public class SignInterceptor implements HandlerInterceptor {
	
	private static final Logger logger = LoggerFactory.getLogger(SignInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 获取方法
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		// 获取方法上面签名注解
		Signature sign = handlerMethod.getMethodAnnotation(Signature.class);
		if (null == sign) {
			return true;
		}
		// 获取参数
		Map<String, String[]> paramMap = request.getParameterMap();
		if (null == paramMap || paramMap.isEmpty()) {
			return false;
		}
		String signValue = null;
		List<String> paramList = new ArrayList<>(paramMap.size());
        for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
        	if (entry.getKey().equals(sign.signField())) {
        		signValue = entry.getValue()[0];
        	} else {
        		paramList.add(entry.getKey() + "=" + entry.getValue()[0]);
        	}
        }
        if (null == signValue) {
        	return false;
        }
        // 按照英文字母排序
        Collections.sort(paramList);
        // 参数之间&连接
        String params =  StringUtils.join(paramList, "&");
        // md5签名
        String md5Sign = DigestUtils.md5Hex(params.getBytes());
        // 验签
        return signValue.equals(md5Sign); 
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		//
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		//
	}

}
