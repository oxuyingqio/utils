package cn.xuyingqi.util.utils;

/**
 * 字符串工具类
 * 
 * @author XuYQ
 *
 */
public class StringUtils {

	/**
	 * 将字符串转换为首字母大写
	 * 
	 * @param str
	 * @return
	 */
	public static String capitalize(String str) {
		// 获取字符数组
		char[] charArray = str.toCharArray();
		// 获取首位的ASCii值
		int c = charArray[0];
		// 若值在97-122,即a-z的范围内,则减少32即为大写
		if (97 <= c && c <= 122) {
			charArray[0] -= 32;
		}

		return String.valueOf(charArray);
	}
}
