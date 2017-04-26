package com.xy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
public class RequestMappingHandlerConfiguration {

	@Bean
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		return new RequestMappingHandlerMapping();
	}
}
