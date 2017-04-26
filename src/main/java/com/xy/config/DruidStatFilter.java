package com.xy.config;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;

/**
 * druid监控
 * 
 * @author xiongyan
 * @date 2017年3月9日 上午10:22:13
 */
@WebFilter(urlPatterns = "/*", initParams = {@WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")})
public class DruidStatFilter extends WebStatFilter {

}
