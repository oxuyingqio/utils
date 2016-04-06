package cn.xuyingqi.util.exception;

/**
 * 字节数组长度越界
 * 
 * @author Administrator
 *
 */
public class ByteArrayLengthOutOfBoundsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ByteArrayLengthOutOfBoundsException() {
		super();
	}

	public ByteArrayLengthOutOfBoundsException(String message) {
		super(message);
	}

	public ByteArrayLengthOutOfBoundsException(String message, Throwable cause) {
		super(message, cause);
	}

	public ByteArrayLengthOutOfBoundsException(Throwable cause) {
		super(cause);
	}

	protected ByteArrayLengthOutOfBoundsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
