package com.xy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 签名验签注解
 * 
 * @author xiongyan
 * @date 2016年12月22日 上午11:36:22
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Sign {

	/**
	 * 签名类型
	 * 
	 * @return
	 */
	String type() default "MD5";

}
