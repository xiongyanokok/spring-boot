package com.xy.pojo;

/**
 * 接口返回对象
 * 
 * @author xiongyan
 * @date 2017年6月5日 下午2:04:33
 */
public class Result<T> {

	/**
	 * 状态编码
	 * 0 表示成功
	 * 1开头 系统级错误
	 * 2开头 业务级错误
	 */
	private Integer code;
	
	/**
	 * 信息
	 */
	private T data;
	
	public Result() {
		
	}
	
	public Result(Integer code, T data) {
		this.code = code;
		this.data = data;
	}

	public static <T> Result<T> success(T data) {
		return new Result<T>(0, data);
	}
	
	public static <T> Result<T> error(Integer code, T data) {
		return new Result<T>(code, data);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
    public static Result<String> SystemError = new Result<String>(10001, "系统错误");
    public static Result<String> NotLogin = new Result<String>(10002, "未登录");
    public static Result<String> NotBlank = new Result<String>(10003, "参数不能为空");
    public static Result<String> NoAccess = new Result<String>(10004, "无权访问");
    public static Result<String> NoData = new Result<String>(10005, "无数据");
    public static Result<String> NoResource = new Result<String>(10006, "资源不存在");
    public static Result<String> ParamError = new Result<String>(10007, "参数格式错误");
}
