package cn.xuyingqi.utils.exception;

/**
 * HTTP异常
 * 
 * @author XuYQ
 *
 */
public final class HttpException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 异常代码
	 */
	private int code;
	/**
	 * 错误信息
	 */
	private String reasonPhrase;
	/**
	 * 错误体
	 */
	private String body;

	/**
	 * HTTP异常
	 * 
	 * @param msg
	 */
	public HttpException(int code, String reasonPhrase, String body) {

		super(reasonPhrase);

		this.code = code;
		this.reasonPhrase = reasonPhrase;
		this.body = body;
	}

	/**
	 * 获取错误代码
	 * 
	 * @return
	 */
	public int getCode() {

		return this.code;
	}

	/**
	 * 获取错误信息
	 * 
	 * @return
	 */
	public String getReasonPhrase() {

		return this.reasonPhrase;
	}

	/**
	 * 获取错误体
	 * 
	 * @return
	 */
	public String getBody() {

		return this.body;
	}

	@Override
	public String getMessage() {

		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append(this.getCode());
		sb.append("]");
		sb.append(this.getReasonPhrase() == null ? "" : this.getReasonPhrase());
		sb.append(" ");
		sb.append(this.getBody() == null ? "" : this.getBody());

		return sb.toString();
	}
}