package cn.xuyingqi.util.exception;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 日期解析异常
 * 
 * @author XuYQ
 *
 */
public class DateParseException extends RuntimeException {

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
		ResourceBundle rb = ResourceBundle.getBundle("net.newcapec.gas.util.i18n.message", Locale.getDefault());
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