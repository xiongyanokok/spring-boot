package com.xy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.xy.interceptor.AnnotationInterceptor;
import com.xy.interceptor.SignInterceptor;

/**
 * 配置拦截器链
 * 
 * @author xiongyan
 * @date 2017年3月9日 上午9:53:18
 */
@Configuration
public class InterceptorConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AnnotationInterceptor()).addPathPatterns("/api/*");
		registry.addInterceptor(new SignInterceptor()).addPathPatterns("/api/*");

		super.addInterceptors(registry);
	}
}
