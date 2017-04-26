package com.xy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * json字段过滤 注解
 * 
 * @author xiongyan
 * @date 2016年12月22日 上午11:36:22
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonFilter {

	/**
	 * 要过滤的字段
	 * 
	 * @return
	 */
	Class<?>[] mixins() default Object.class;

	/**
	 * 目标类
	 * 
	 * @return
	 */
	Class<?>[] targets() default Object.class;

}
