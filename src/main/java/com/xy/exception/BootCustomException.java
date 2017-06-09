package com.xy.exception;

/**
 * 自定义异常
 * 
 * @author xiongyan
 * @date 2017年3月7日 下午4:35:32
 */
public class BootCustomException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 异常代码
	 */
	private Integer code;
	
	public BootCustomException() {
        super();
    }

    public BootCustomException(String message) {
        super(message);
    }

    public BootCustomException(Integer code, String message) {
        super(message);
        this.code = code;
    }
    
    public BootCustomException(Integer code, String message, Throwable cause) {
    	super(message, cause);
    	this.code = code;
    }
    
    public BootCustomException(String message, Throwable cause) {
    	super(message, cause);
    }
    
    public BootCustomException(Throwable cause) {
    	super(cause);
    }


	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
