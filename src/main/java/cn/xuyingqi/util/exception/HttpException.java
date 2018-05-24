package cn.xuyingqi.util.exception;

/**
 * Http请求异常
 * 
 * @author XuYQ
 *
 */
public class HttpException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Http请求异常
	 */
	public HttpException(String msg) {

		super(msg);
	}
}