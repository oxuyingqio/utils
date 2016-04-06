package cn.xuyingqi.util.exception;

/**
 * 字节数组为空
 * 
 * @author Administrator
 *
 */
public class ByteArrayIsEmptyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ByteArrayIsEmptyException() {
		super();
	}

	public ByteArrayIsEmptyException(String message) {
		super(message);
	}

	public ByteArrayIsEmptyException(String message, Throwable cause) {
		super(message, cause);
	}

	public ByteArrayIsEmptyException(Throwable cause) {
		super(cause);
	}

	protected ByteArrayIsEmptyException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
