package com.xy.exception;

import java.util.Collection;
import java.util.Map;

/**
 * 断言工具类
 * 
 * @author xiongyan
 * @date 2017年6月6日 下午3:41:39
 */
public abstract class Assert {

	/**
	 * assert expression is true
	 * 
	 * @param expression
	 * @param message
	 * @throws BootCustomException if {@code expression} is {@code false}
	 */
	public static void isTrue(boolean expression, String message) {
		if (!expression) {
			throw new BootCustomException(ErrorCode.PARAM_CHECK_ERROR, message);
		}
	}
	
	/**
	 * assert text is not empty
	 * 
	 * @param text
	 * @param message
	 * @throws BootCustomException if the text is empty
	 */
	public static void hasLength(String text, String message) {
		if (null == text || text.length() == 0) {
			throw new BootCustomException(ErrorCode.PARAM_CHECK_ERROR, message);
		}
	}
	
	/**
	 * assert object is not null 
	 * 
	 * @param object
	 * @param message
	 * @throws BootCustomException if the object is not {@code null}
	 */
	public static void isNull(Object object, String message) {
		if (null != object) {
			throw new BootCustomException(ErrorCode.PARAM_CHECK_ERROR, message);
		}
	}
	
	/**
	 * assert object is null
	 * 
	 * @param object
	 * @param message
	 * @throws BootCustomException if the object is {@code null}
	 */
	public static void notNull(Object object, String message) {
		if (null == object) {
			throw new BootCustomException(ErrorCode.PARAM_CHECK_ERROR, message);
		}
	}
	
	/**
	 * assert collection is not empty
	 * 
	 * @param collection
	 * @param message
	 * @throws BootCustomException if the collection is {@code null} or collection no elements
	 */
	public static void notEmpty(Collection<?> collection, String message) {
		if (null == collection || collection.isEmpty()) {
			throw new BootCustomException(ErrorCode.PARAM_CHECK_ERROR, message);
		}
	}
	
	/**
	 * assert map is not empty
	 * 
	 * @param map
	 * @param message
	 * @throws BootCustomException if the map is {@code null} or map no elements
	 */
	public static void notEmpty(Map<?, ?> map, String message) {
		if (null == map || map.isEmpty()) {
			throw new BootCustomException(ErrorCode.PARAM_CHECK_ERROR, message);
		}
	}
	
}
