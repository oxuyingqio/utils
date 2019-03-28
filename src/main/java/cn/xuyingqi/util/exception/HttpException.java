package cn.xuyingqi.util.exception;

/**
 * HTTP异常
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
	 * HTTP异常
	 * 
	 * @param msg
	 */
	public HttpException(String msg) {

		super(msg);
	}
}