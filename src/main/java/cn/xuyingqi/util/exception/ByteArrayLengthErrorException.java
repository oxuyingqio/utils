package cn.xuyingqi.util.exception;

/**
 * 字节数组长度错误
 * 
 * @author XuYQ
 *
 */
public class ByteArrayLengthErrorException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ByteArrayLengthErrorException() {
		super();
	}

	public ByteArrayLengthErrorException(String message) {
		super(message);
	}

	public ByteArrayLengthErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	public ByteArrayLengthErrorException(Throwable cause) {
		super(cause);
	}

	protected ByteArrayLengthErrorException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
