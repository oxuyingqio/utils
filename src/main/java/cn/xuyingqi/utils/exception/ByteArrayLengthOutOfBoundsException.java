package cn.xuyingqi.utils.exception;

import java.util.Locale;
import java.util.ResourceBundle;

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

	/**
	 * 异常描述
	 */
	private static String MSG = null;

	static {

		// 获取国际化文件
		ResourceBundle rb = ResourceBundle.getBundle("net.newcapec.gas.util.i18n.message", Locale.getDefault());
		// 获取异常描述
		MSG = rb.getString("ByteArrayLengthOutOfBoundsException");
	}

	/**
	 * 字节数组长度越界
	 */
	public ByteArrayLengthOutOfBoundsException() {

		super(MSG);
	}
}