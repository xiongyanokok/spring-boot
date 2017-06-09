package com.xy.exception;

/**
 * 业务级错误码
 * 
 * @author xiongyan
 * @date 2017年6月6日 下午4:19:08
 */
public interface ErrorCode {

	/**
	 * 参数检查失败
	 */
	public static final Integer PARAM_CHECK_ERROR = 20001;
	/**
	 * 结果检查失败
	 */
	public static final Integer RESULT_CHECK_ERROR = 20002;
	/**
	 * 数据库保存失败
	 */
	public static final Integer DB_SAVE_ERROR = 20003;
	/**
	 * 数据库更新失败
	 */
	public static final Integer DB_UPDATE_ERROR = 20004;
	/**
	 * 数据库删除失败
	 */
	public static final Integer DB_DELETE_ERROR = 20005;
	/**
	 * 数据库查询失败
	 */
	public static final Integer DB_QUERY_ERROR = 20006;
	
}
