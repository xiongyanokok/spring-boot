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
	 * 消息
	 */
	private String message;
	
	/**
	 * 结果
	 */
	private T data;
	
	public Result() {
		
	}
	
	public Result(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public Result(Integer code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public static <T> Result<T> success(T data) {
		return new Result<>(0, "成功", data);
	}
	
	public static Result<String> error(Integer code, String message) {
		return new Result<>(code, message);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
    public static final Result<String> SystemError = new Result<>(10001, "系统错误");
    public static final Result<String> NotLogin = new Result<>(10002, "未登录");
    public static final Result<String> NotBlank = new Result<>(10003, "参数不能为空");
    public static final Result<String> NoAccess = new Result<>(10004, "无权访问");
    public static final Result<String> NoData = new Result<>(10005, "无数据");
    public static final Result<String> NoResource = new Result<>(10006, "资源不存在");
    public static final Result<String> ParamError = new Result<>(10007, "参数格式错误");
}
