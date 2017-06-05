package com.xy.exception;

/**
 * 自定义异常
 * 
 * @author xiongyan
 * @date 2017年3月7日 下午4:35:32
 */
public class RestCustomException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 异常代码
	 */
	private Integer code;
	
	public RestCustomException() {
        super();
    }

    public RestCustomException(String message) {
        super(message);
    }

    public RestCustomException(Integer code, String message) {
        super(message);
        this.code = code;
    }
    
    public RestCustomException(Integer code, String message, Exception e) {
    	super(message, e.getCause());
    	this.code = code;
    }
    
    public RestCustomException(String message, Throwable cause) {
    	super(message, cause);
    }
    
    public RestCustomException(Throwable cause) {
    	super(cause);
    }


	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
