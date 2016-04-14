package cn.xuyingqi.util.utils;

/**
 * 字符串工具类
 * 
 * @author XuYQ
 *
 */
public class StringUtils {

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}

	/**
	 * 判断字符串是否为空或仅为空格
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(str.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 将字符串首字母大写
	 * 
	 * @param str
	 * @return
	 */
	public static String capitalize(String str) {
		// 获取ASCii值
		char[] charArray = str.toCharArray();
		// 若char在97-122,即a-z的范围内时,则减少32即为大写
		int c = charArray[0];
		if (c >= 97 && c <= 122) {
			charArray[0] -= 32;
		}

		return String.valueOf(charArray);
	}
}
