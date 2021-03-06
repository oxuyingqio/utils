package cn.xuyingqi.utils.exception;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 日期解析异常
 * 
 * @author XuYQ
 *
 */
public final class DateParseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 异常描述
	 */
	private static String MSG = null;

	static {

		// 获取国际化文件
		ResourceBundle rb = ResourceBundle.getBundle("i18n.utils.message", Locale.getDefault());
		// 获取异常描述
		MSG = rb.getString("DateParseException");
	}

	/**
	 * 日期解析异常
	 * 
	 * @param msg
	 */
	public DateParseException(String msg) {

		super(MSG + msg);
	}
}