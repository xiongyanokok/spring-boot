package com.xy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * controller的基类
 * 
 * @author xiongyan
 * @date 2016年10月27日 下午2:06:29
 */
public abstract class BaseController {

	/**
	 * HttpServletRequest
	 */
	@Autowired
	protected HttpServletRequest request;

	/**
	 * HttpServletResponse
	 */
	@Autowired
	protected HttpServletResponse response;

	/**
	 * HttpSession
	 */
	@Autowired
	protected HttpSession session;
	
}
