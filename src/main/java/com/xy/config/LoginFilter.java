package com.xy.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 登录过滤器
 * 
 * @author xiongyan
 * @date 2017年3月9日 下午1:59:57
 */
@WebFilter(urlPatterns="/api/*")
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("过滤器初始化");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("过滤器-->执行过滤操作");
        chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("过滤器销毁");
	}

}
