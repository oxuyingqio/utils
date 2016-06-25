package cn.xuyingqi.util.util;

import cn.xuyingqi.util.exception.ByteArrayIsEmptyException;
import cn.xuyingqi.util.exception.ByteArrayLengthErrorException;
import cn.xuyingqi.util.exception.ByteArrayLengthOutOfBoundsException;

/**
 * 字节工具类<br>
 * <br>
 * 1.byte 1字节8位; short 2字节16位; int 4字节32位; long 8字节64位;<br>
 * 2.byte,short,int,long均为有符号数据,即第一位均为符号位.<br>
 * <br>
 * 3.&(与)操作.若两位均为1,则结果为1;1或0与上1都为它本身.<br>
 * 4.|(或)操作.若两位有一位为1,则结果为1;1或0或上0都为它本身.<br>
 * 5.^(异或)操作.若两位不同则为1,相同则为0.<br>
 * 
 * @author Administrator
 *
 */
public class ByteUtils {

	/**
	 * 将无符号字节(即8位均为数据的字节)转换为有符号的短整型;<br>
	 * 由于Java中的byte是有符号的(即首位用来表示符号位),所以无符号字节的数据范围在正数部分超出了byte所能表示的最大数,导致结果变为负数.
	 * <br>
	 * 因此需要使用两个字节的short类型来接此数.<br>
	 * 若直接强转,则Java内部认为byte的首位依旧是short的符号位,因此数据依旧错误.所以需要使用&进行位与操作.<br>
	 * 
	 * @param b
	 *            无符号字节
	 * @return
	 */
	public static short byte2Short(byte b) {

		// 16进制0xff即为11111111
		return (short) (b & 0xff);
	}

	/**
	 * 将无符号字节(即8位均为数据的字节)转换为有符号的整型;
	 * 
	 * @param b
	 *            无符号字节
	 * @return
	 */
	public static int byte2Int(byte b) {

		return (b & 0xff);
	}

	/**
	 * 将无符号字节(即8位均为数据的字节)转换为有符号的长整型;
	 * 
	 * @param b
	 *            无符号字节
	 * @return
	 */
	public static long byte2Long(byte b) {

		return (b & 0xff);
	}

	/**
	 * 将短整型拆分为长度为2的字节数组
	 * 
	 * @param s
	 * @return
	 */
	public static byte[] short2ByteArray(short s) {

		// 拆分后的字节数组
		byte[] byteArray = new byte[2];
		// 高字节右移8位,即把低字节舍去.再强转为byte,即仅取右移后的8位低字节
		byteArray[0] = (byte) (s >> 8);
		byteArray[1] = (byte) s;

		return byteArray;
	}

	/**
	 * 将整型拆分为长度为4的字节数组
	 * 
	 * @param i
	 * @return
	 */
	public static byte[] int2ByteArray(int i) {

		// 拆分后的字节数组
		byte[] byteArray = new byte[4];
		// 数组长度
		int length = byteArray.length;

		// 遍历数组
		for (int index = 1; index <= length; index++) {

			// 数组的第(index-1)位,要向右移(length-index)字节
			byteArray[index - 1] = (byte) (i >> ((length - index) * 8));
		}

		return byteArray;
	}

	/**
	 * 将长整型拆分为长度为8的字节数组
	 * 
	 * @param l
	 * @return
	 */
	public static byte[] long2ByteArray(long l) {

		// 拆分后的字节数组
		byte[] byteArray = new byte[8];
		// 数组长度
		int length = byteArray.length;

		// 遍历数组
		for (int index = 1; index <= length; index++) {

			// 数组的第(index-1)位,要向右移(length-index)字节
			byteArray[index - 1] = (byte) (l >> ((length - index) * 8));
		}

		return byteArray;
	}

	/**
	 * BCD码转字节数组
	 * 
	 * @param bcd
	 *            bcd码
	 * @return
	 */
	public static byte[] bcd2ByteArray(byte[] bcd) {

		// 转换后字节数组
		byte[] byteArray = new byte[bcd.length * 2];
		// 遍历BCD码
		for (int i = 0, length = bcd.length; i < length; i++) {

			byteArray[i * 2] = (byte) ((bcd[i] & 0xf0) >> 4);
			byteArray[i * 2 + 1] = (byte) (bcd[i] & 0x0f);
		}

		return byteArray;
	}

	/**
	 * 将字符串拆分为字节数组.<br>
	 * 本方法为取出每一个字符,将其直接转为byte,而非使用ASCII值进行转换<br>
	 * 例如:字符1->字节1,而不是字符1->字节49(字符1的ASCII值是49)
	 * 
	 * @param str
	 * @return
	 */
	public static byte[] string2ByteArray(String str) {

		// 拆分后的字节数组
		byte[] byteArray = new byte[str.length()];
		// 遍历字符串每一个字符
		for (int i = 0, length = str.length(); i < length; i++) {

			byteArray[i] = Byte.valueOf(str.charAt(i) + "");
		}

		return byteArray;
	}

	/**
	 * 将字节数组(0<长度<=2)合并为短整型
	 * 
	 * @param byteArray
	 * @return
	 */
	public static short byteArray2Short(byte[] byteArray) {

		switch (byteArray.length) {
		case 0:
			throw new ByteArrayIsEmptyException();
		case 1:
			return ByteUtils.byte2Short(byteArray[0]);
		case 2:
			return (short) ((ByteUtils.byte2Short(byteArray[0]) << 8) | (ByteUtils.byte2Short(byteArray[1])));
		default:
			throw new ByteArrayLengthOutOfBoundsException();
		}
	}

	/**
	 * 将字节数组(0<长度<=4)合并为整型
	 * 
	 * @param byteArray
	 * @return
	 */
	public static int byteArray2Int(byte[] byteArray) {

		// 字节数组长度
		int length = byteArray.length;

		if (length == 0) {
			throw new ByteArrayIsEmptyException();
		} else if (length > 4) {
			throw new ByteArrayLengthOutOfBoundsException();
		} else {
			// 获取最末位的字节
			int i = ByteUtils.byte2Int(byteArray[length - 1]);

			// 遍历字节数组,从倒数第二位向前
			for (int index = length - 1; index > 0; index--) {

				// 数组的第(index-1)位,要向左移(length-index)字节
				i = i | (ByteUtils.byte2Int(byteArray[index - 1]) << ((length - index) * 8));
			}

			return i;
		}
	}

	/**
	 * 将字节数组(0<长度<=8)合并为长整型
	 * 
	 * @param byteArray
	 * @return
	 */
	public static long byteArray2Long(byte[] byteArray) {

		// 字节数组长度
		int length = byteArray.length;

		if (length == 0) {
			throw new ByteArrayIsEmptyException();
		} else if (length > 8) {
			throw new ByteArrayLengthOutOfBoundsException();
		} else {
			// 获取最末位的字节
			long l = ByteUtils.byte2Long(byteArray[length - 1]);

			// 遍历字节数组,从倒数第二位向前
			for (int index = length - 1; index > 0; index--) {

				// 数组的第(index-1)位,要向左移(length-index)字节
				l = l | (ByteUtils.byte2Long(byteArray[index - 1]) << ((length - index) * 8));
			}

			return l;
		}
	}

	/**
	 * 字节数组转BCD码,字节数组长度必须为2的倍数
	 * 
	 * @param byteArray
	 * @return
	 */
	public static byte[] byteArray2BCD(byte[] byteArray) {

		// 字节数组长度
		int byteArrayLength = byteArray.length;
		// 若长度不为2的倍数,则抛出异常
		if (byteArrayLength % 2 != 0) {
			throw new ByteArrayLengthErrorException();
		}

		// BCD码
		byte[] bcd = new byte[byteArrayLength / 2];
		// 遍历字节数组
		for (int i = 0, length = bcd.length; i < length; i++) {

			// 前字节向左位移4位,与上后字节
			bcd[i] = (byte) (((byte) (byteArray[i * 2] << 4)) | (byteArray[i * 2 + 1]));
		}

		return bcd;
	}

	/**
	 * 将字节数组合并为字符串.<br>
	 * 本方法为取出每一位字节,直接作为字符处理,而不是作为ASCII值<br>
	 * 例如:字节49->字符49,而不是字节49->字符1(字符1的ASCII值是49)
	 * 
	 * @param byteArray
	 * @return
	 */
	public static String byteArray2String(byte[] byteArray) {

		// 合并后的字符串
		StringBuffer sb = new StringBuffer(byteArray.length);
		// 遍历字节数组
		for (int i = 0, length = byteArray.length; i < length; i++) {

			sb.append(byteArray[i]);
		}

		return sb.toString();
	}

	/**
	 * 将字节数组顺序反转
	 * 
	 * @param byteArray
	 * @return
	 */
	public static byte[] reverse(byte[] byteArray) {

		// 反转后的字节数组
		byte[] reverseByteArray = new byte[byteArray.length];
		// 遍历字节数组
		for (int i = 1; i <= reverseByteArray.length; i++) {

			reverseByteArray[i - 1] = byteArray[reverseByteArray.length - i];
		}

		return reverseByteArray;
	}

	/**
	 * 异或.将两个字节作为无符号数据进行异或操作.
	 * 
	 * @param byte1
	 * @param byte2
	 * @return
	 */
	public static byte xor(byte byte1, byte byte2) {

		return (byte) (byte1 ^ byte2);
	}

	/**
	 * 异或.将两个字节数组作为无符号进行异或操作.
	 * 
	 * @param byteArray1
	 * @param byteArray2
	 * @return
	 */
	public static byte[] xor(byte[] byteArray1, byte[] byteArray2) {

		// 长度不一致,则抛出异常
		if (byteArray1.length != byteArray2.length) {
			throw new ByteArrayLengthErrorException();
		}

		// 返回的字节数组
		byte[] byteArray = new byte[byteArray1.length];
		// 遍历传入的字节数组
		for (int i = 0; i < byteArray1.length; i++) {

			// 异或每一位
			byteArray[i] = xor(byteArray1[i], byteArray2[i]);
		}

		return byteArray;
	}

	/**
	 * 比较两个字节数组是否一致,比较的是数组内容
	 * 
	 * @param byteArray1
	 * @param byteArray2
	 * @return
	 */
	public static boolean compare(byte[] byteArray1, byte[] byteArray2) {

		// 若长度不一致,则直接返回false
		if (byteArray1.length != byteArray2.length) {
			return false;
		} else {

			// 遍历字节数组内容,判断是否一致
			for (int i = 0, length = byteArray1.length; i < length; i++) {

				if (byteArray1[i] != byteArray2[i]) {
					return false;
				}
			}

			return true;
		}
	}
}
