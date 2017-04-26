package com.xy.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.xy.config.RequestMappingHandlerConfiguration;

@RestController
@RequestMapping("/")
public class MonitorController {

	@Autowired
	private RequestMappingHandlerConfiguration requestMappingHandlerConfiguration;

	@RequestMapping(value = "monitor", method = RequestMethod.GET)
	public List<RequestInfo> monitor() {
		RequestMappingHandlerMapping requestMappingHandlerMapping = requestMappingHandlerConfiguration.requestMappingHandlerMapping();  
        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();
        List<RequestInfo> list = new ArrayList<>();
        if (null != map && !map.isEmpty()) {
        	for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : map.entrySet()) {
        		RequestMappingInfo requestMappingInfo = entry.getKey();
        		HandlerMethod handlerMethod = entry.getValue();
        		if (handlerMethod.toString().indexOf("org.springframework.boot.autoconfigure.web.BasicErrorController") != -1) {
        			continue;
        		}
        		RequestInfo requestInfo = new RequestInfo();
        		requestInfo.setClassPath(handlerMethod.toString());
        		
        		String url = requestMappingInfo.getPatternsCondition().toString();  
        		url = url.substring(1, url.length()-1);  
        		requestInfo.setUrl(url);
        		
        		String method = requestMappingInfo.getMethodsCondition().toString();
        		method = method.substring(1, method.length()-1);  
        		requestInfo.setMethod(method);
        		list.add(requestInfo);
        	}
        }
        return list;
	}
	
}
