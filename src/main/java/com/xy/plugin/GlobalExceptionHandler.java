package com.xy.plugin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 * 
 * @author xiongyan
 * @date 2017年3月28日 下午4:15:46
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * 全局异常
	 * 
	 * @param e
	 * @param response
	 * @return
	 */
	@ExceptionHandler(Exception.class)  
    @ResponseBody
    public Map<String, Object> exceptionHandler(RuntimeException e, HttpServletResponse response) {
		logger.error("全局异常：", e);
		Map<String, Object> map = new HashMap<>();
		map.put("code", -1);
		map.put("msg", "系统错误");
        return map;  
    } 
}
