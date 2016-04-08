package cn.xuyingqi.util.exception;

/**
 * 字节下标值越界
 * 
 * @author Administrator
 *
 */
public class IndexOutOfBoundsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IndexOutOfBoundsException() {
		super();
	}

	public IndexOutOfBoundsException(String message) {
		super(message);
	}

	public IndexOutOfBoundsException(String message, Throwable cause) {
		super(message, cause);
	}

	public IndexOutOfBoundsException(Throwable cause) {
		super(cause);
	}

	protected IndexOutOfBoundsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
