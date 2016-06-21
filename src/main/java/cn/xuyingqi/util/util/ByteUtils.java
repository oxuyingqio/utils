package cn.xuyingqi.util.util;

import cn.xuyingqi.util.exception.ByteArrayIsEmptyException;
import cn.xuyingqi.util.exception.ByteArrayLengthOutOfBoundsException;
import cn.xuyingqi.util.exception.IndexOutOfBoundsException;

/**
 * 字节工具类
 * 
 * 1.byte 1字节8位; short 2字节16位; int 4字节32位; long 8字节64位;
 * 2.byte,short,int,long均为有符号数据,即第一位均为符号位.
 * 
 * 3.&(与)操作.若两位均为1,则结果为1;1或0与上1都为它本身.
 * 
 * 4.|(或)操作.若两位有一位为1,则结果为1;1或0或上0都为它本身.
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
	 * @return
	 */
	public static int byte2Int(byte b) {
		return (b & 0xff);
	}

	/**
	 * 将无符号字节(即8位均为数据的字节)转换为有符号的长整型;
	 * 
	 * @param b
	 * @return
	 */
	public static long byte2Long(byte b) {
		return (b & 0xff);
	}

	/**
	 * 将短整型转换为2个字节
	 * 
	 * @param s
	 * @return
	 */
	public static byte[] short2ByteArray(short s) {
		byte[] byteArray = new byte[2];
		// 高字节右移8位,即把低字节舍去.再强转为byte,即仅取右移后的8位低字节
		byteArray[0] = (byte) (s >> 8);
		byteArray[1] = (byte) s;
		return byteArray;
	}

	/**
	 * 将整型转换为4个字节
	 * 
	 * @param i
	 * @return
	 */
	public static byte[] int2ByteArray(int i) {
		byte[] byteArray = new byte[4];
		for (int index = 0; index < 4; index++) {
			byteArray[index] = (byte) (i >> (8 * (3 - index)));
		}
		return byteArray;
	}

	/**
	 * 将长整型转换为8个字节
	 * 
	 * @param l
	 * @return
	 */
	public static byte[] long2ByteArray(long l) {
		byte[] byteArray = new byte[8];
		for (int index = 0; index < 8; index++) {
			byteArray[index] = (byte) (l >> (8 * (7 - index)));
		}
		return byteArray;
	}

	/**
	 * 将字节数组(0<长度<=2)转换为短整型
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
	 * 将字节数组(0<长度<=4)转换为整型
	 * 
	 * @param byteArray
	 * @return
	 */
	public static int byteArray2Int(byte[] byteArray) {
		if (byteArray.length == 0) {
			throw new ByteArrayIsEmptyException();
		} else if (byteArray.length > 4) {
			throw new ByteArrayLengthOutOfBoundsException();
		} else {
			int i = ByteUtils.byte2Int(byteArray[byteArray.length - 1]);
			for (int index = byteArray.length - 2; index >= 0; index--) {
				i = i | (ByteUtils.byte2Int(byteArray[index]) << (8 * (3 - index)));
			}
			return i;
		}
	}

	/**
	 * 将字节数组(0<长度<=8)转换为长整型
	 * 
	 * @param byteArray
	 * @return
	 */
	public static long byteArray2Long(byte[] byteArray) {
		if (byteArray.length == 0) {
			throw new ByteArrayIsEmptyException();
		} else if (byteArray.length > 8) {
			throw new ByteArrayLengthOutOfBoundsException();
		} else {
			long l = ByteUtils.byte2Long(byteArray[byteArray.length - 1]);
			for (int index = byteArray.length - 2; index >= 0; index--) {
				l = l | (ByteUtils.byte2Long(byteArray[index]) << (8 * (7 - index)));
			}
			return l;
		}
	}

	/**
	 * 将指定下标值的位转换为1,并得到对应字节<br>
	 * 
	 * 下标值从0开始,大于等于8则抛异常
	 * 
	 * @param indexArray
	 * @return
	 */
	public static byte convertSpecifiedLocation2Byte(int[] indexArray) {
		// 返回的字节,默认为0
		byte b = 0;
		// 遍历需要转换的下标值数组
		for (int index = 0, length = indexArray.length; index < length; index++) {
			// 下标值
			int indexValue = indexArray[index];
			// 大于等于8则抛异常
			if (indexValue < 8) {
				b = (byte) (b | (1 << indexValue));
			} else {
				throw new IndexOutOfBoundsException();
			}
		}
		return b;
	}

	/**
	 * 将指定下标值的位转换为1,并得到对应短整型<br>
	 * 
	 * 下标值从0开始,大于等于16则抛异常
	 * 
	 * @param indexArray
	 * @return
	 */
	public static short convertSpecifiedLocation2Short(int[] indexArray) {
		// 返回的,默认为0
		short s = 0;
		// 遍历需要转换的下标值数组
		for (int index = 0, length = indexArray.length; index < length; index++) {
			// 下标值
			int indexValue = indexArray[index];
			// 大于等于16则抛异常
			if (indexValue < 16) {
				s = (short) (s | (1 << indexValue));
			} else {
				throw new IndexOutOfBoundsException();
			}
		}
		return s;
	}

	/**
	 * 将指定下标值的位转换为1,并得到对应整型<br>
	 * 
	 * 下标值从0开始,大于等于32则抛异常
	 * 
	 * @param indexArray
	 * @return
	 */
	public static int convertSpecifiedLocation2Int(int[] indexArray) {
		// 返回的,默认为0
		int i = 0;
		// 遍历需要转换的下标值数组
		for (int index = 0, length = indexArray.length; index < length; index++) {
			// 下标值
			int indexValue = indexArray[index];
			// 大于等于32则抛异常
			if (indexValue < 32) {
				i = i | (1 << indexValue);
			} else {
				throw new IndexOutOfBoundsException();
			}
		}
		return i;
	}

	/**
	 * 将指定下标值的位转换为1,并得到对应长整型<br>
	 * 
	 * 下标值从0开始,大于等于64则抛异常
	 * 
	 * @param indexArray
	 * @return
	 */
	public static long convertSpecifiedLocation2Long(int[] indexArray) {
		// 返回的,默认为0
		long l = 0;
		// 遍历需要转换的下标值数组
		for (int index = 0, length = indexArray.length; index < length; index++) {
			// 下标值
			int indexValue = indexArray[index];
			// 大于等于64则抛异常
			if (indexValue < 64) {
				l = l | (1 << indexValue);
			} else {
				throw new IndexOutOfBoundsException();
			}
		}
		return l;
	}

	/**
	 * 将字节数组顺序反转
	 * 
	 * @param byteArray
	 * @return
	 */
	public static byte[] reverse(byte[] byteArray) {
		byte[] reverseByteArray = new byte[byteArray.length];
		for (int i = 0; i < reverseByteArray.length; i++) {
			reverseByteArray[i] = byteArray[reverseByteArray.length - 1 - i];
		}

		return reverseByteArray;
	}

	/**
	 * BCD码转字符串
	 * 
	 * @param bcd
	 *            bcd码
	 * @return
	 */
	public static String bcd2String(byte[] bcd) {

		// 临时字符串
		StringBuffer sb = new StringBuffer(bcd.length * 2);
		// 遍历BCD码
		for (int i = 0; i < bcd.length; i++) {
			sb.append((byte) ((bcd[i] & 0xf0) >> 4));
			sb.append((byte) (bcd[i] & 0x0f));
		}

		return sb.toString();
	}
}
