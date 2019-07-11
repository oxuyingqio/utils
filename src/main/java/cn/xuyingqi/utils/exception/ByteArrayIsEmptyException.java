package cn.xuyingqi.utils.exception;

import java.util.Locale;
import java.util.ResourceBundle;

import cn.xuyingqi.utils.ByteUtils;

/**
 * 字节数组为空
 * 
 * @author XuYQ
 *
 */
public class ByteArrayIsEmptyException extends RuntimeException {

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
		MSG = rb.getString("ByteArrayIsEmptyException");
	}

	/**
	 * 字节数组为空
	 */
	public ByteArrayIsEmptyException() {

		super(MSG);
	}

	/**
	 * Main函数测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(ByteUtils.byteArray2Short(new byte[] {}));
	}
}