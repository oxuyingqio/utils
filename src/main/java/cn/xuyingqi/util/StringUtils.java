package cn.xuyingqi.util;

/**
 * 字符串工具类
 * 
 * @author XuYQ
 *
 */
public final class StringUtils {

	/**
	 * 私有构造方法
	 */
	private StringUtils() {

	}

	/**
	 * HTML编码
	 * 
	 * @param str
	 * @return
	 */
	public static final String htmlEscape(String str) {

		return str.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}

	/**
	 * Main函数测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String s = "123";
		String ss = new String("123");

		System.out.println(s.hashCode());
		System.out.println(ss.hashCode());
	}
}