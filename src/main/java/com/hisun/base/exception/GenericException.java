package com.hisun.base.exception;
/**
 * 
 *<p>类名称：GenericException</p>
 *<p>类描述: </p>
 *<p>公司：湖南海数互联信息技术有限公司</p>
 *@创建人：Rocky
 *@创建时间：2014-12-8 下午3:36:55
 *@创建人联系方式：24212477@qq.com
 *@version
 */
public class GenericException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String errorCode;

	/**
	 * 错误信息
	 */
	private String errorMsg;



	public GenericException() {
		super();
	}
	
	public GenericException(String errorCode,String errorMsg) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	public GenericException(String message) {
		super(message);
	}
	
	public GenericException(Throwable cause) {
		super(cause);
	}

	public GenericException(String message, Throwable cause) {
		super(message, cause);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
