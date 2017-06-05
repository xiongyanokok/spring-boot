package com.xy.plugin;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xy.exception.RestCustomException;
import com.xy.pojo.Result;

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
	 * RestCustomException 全局异常
	 * 
	 * @param e
	 * @param response
	 * @return
	 */
	@ExceptionHandler(RestCustomException.class)
    @ResponseBody
    public Result<String> exceptionHandler(RestCustomException e, HttpServletResponse response) {
		logger.error("RestCustomException：", e);
		if (null == e.getCode()) {
			return exceptionHandler(e, response);
		}
		return Result.error(e.getCode(), e.getMessage());
    } 
	
	/**
	 * RuntimeException 全局异常
	 * 
	 * @param e
	 * @param response
	 * @return
	 */
	@ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Result<String> exceptionHandler(RuntimeException e, HttpServletResponse response) {
		logger.error("RuntimeException：", e);
		return Result.SystemError;
    } 
}
