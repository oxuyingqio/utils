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
	 * @param source
	 *            无符号字节
	 * @return
	 */
	public static short byte2Short(byte source) {

		// 16进制0xff即为11111111
		return (short) (source & 0xff);
	}

	/**
	 * 将无符号字节(即8位均为数据的字节)转换为有符号的整型;
	 * 
	 * @param source
	 *            无符号字节
	 * @return
	 */
	public static int byte2Int(byte source) {

		return (source & 0xff);
	}

	/**
	 * 将无符号字节(即8位均为数据的字节)转换为有符号的长整型;
	 * 
	 * @param source
	 *            无符号字节
	 * @return
	 */
	public static long byte2Long(byte source) {

		return (source & 0xff);
	}

	/**
	 * 将短整型拆分为长度为2的字节数组
	 * 
	 * @param source
	 *            短整型
	 * @return
	 */
	public static byte[] short2ByteArray(short source) {

		// 拆分后的字节数组
		byte[] target = new byte[2];
		// 高字节右移8位,即把低字节舍去.再强转为byte,即仅取右移后的8位低字节
		target[0] = (byte) (source >> 8);
		target[1] = (byte) source;

		return target;
	}

	/**
	 * 将整型拆分为长度为4的字节数组
	 * 
	 * @param source
	 *            整型
	 * @return
	 */
	public static byte[] int2ByteArray(int source) {

		// 拆分后的字节数组
		byte[] target = new byte[4];
		// 遍历数组
		for (int index = 1, length = target.length; index <= length; index++) {

			// 数组的第(index-1)位,要向右移(length-index)字节
			target[index - 1] = (byte) (source >> ((length - index) * 8));
		}

		return target;
	}

	/**
	 * 将长整型拆分为长度为8的字节数组
	 * 
	 * @param source
	 *            长整型
	 * @return
	 */
	public static byte[] long2ByteArray(long source) {

		// 拆分后的字节数组
		byte[] target = new byte[8];
		// 遍历数组
		for (int index = 1, length = target.length; index <= length; index++) {

			// 数组的第(index-1)位,要向右移(length-index)字节
			target[index - 1] = (byte) (source >> ((length - index) * 8));
		}

		return target;
	}

	/**
	 * BCD码转字节数组
	 * 
	 * @param source
	 *            bcd码
	 * @return
	 */
	public static byte[] bcd2ByteArray(byte[] source) {

		// 转换后字节数组
		byte[] target = new byte[source.length * 2];
		// 遍历BCD码
		for (int index = 0, length = source.length; index < length; index++) {

			target[index * 2] = (byte) ((source[index] & 0xf0) >> 4);
			target[index * 2 + 1] = (byte) (source[index] & 0x0f);
		}

		return target;
	}

	/**
	 * 将字符串拆分为字节数组.<br>
	 * 本方法为取出每一个字符,将其直接转为byte,而非使用ASCII值进行转换<br>
	 * 例如:字符1->字节1,而不是字符1->字节49(字符1的ASCII值是49)
	 * 
	 * @param source
	 *            字符串
	 * @return
	 */
	public static byte[] string2ByteArray(String source) {

		// 拆分后的字节数组
		byte[] target = new byte[source.length()];
		// 遍历字符串每一个字符
		for (int index = 0, length = source.length(); index < length; index++) {

			target[index] = Byte.valueOf(source.charAt(index) + "");
		}

		return target;
	}

	/**
	 * 将字节数组(0<长度<=2)合并为短整型
	 * 
	 * @param source
	 *            字节数组
	 * @return
	 */
	public static short byteArray2Short(byte[] source) {

		switch (source.length) {
		case 0:
			throw new ByteArrayIsEmptyException();
		case 1:
			return ByteUtils.byte2Short(source[0]);
		case 2:
			return (short) ((ByteUtils.byte2Short(source[0]) << 8) | (ByteUtils.byte2Short(source[1])));
		default:
			throw new ByteArrayLengthOutOfBoundsException();
		}
	}

	/**
	 * 将字节数组(0<长度<=4)合并为整型
	 * 
	 * @param source
	 *            字节数组
	 * @return
	 */
	public static int byteArray2Int(byte[] source) {

		// 字节数组的长度
		int length = source.length;

		switch (length) {
		case 0:
			throw new ByteArrayIsEmptyException();
		case 1:
		case 2:
		case 3:
		case 4:
			// 获取最末位的字节
			int target = ByteUtils.byte2Int(source[length - 1]);

			// 遍历字节数组,从倒数第二位向前
			for (int index = length - 1; index > 0; index--) {

				// 数组的第(index-1)位,要向左移(length-index)字节
				target = target | (ByteUtils.byte2Int(source[index - 1]) << ((length - index) * 8));
			}

			return target;
		default:
			throw new ByteArrayLengthOutOfBoundsException();
		}
	}

	/**
	 * 将字节数组(0<长度<=8)合并为长整型
	 * 
	 * @param source
	 *            字节数组
	 * @return
	 */
	public static long byteArray2Long(byte[] source) {

		// 字节数组的长度
		int length = source.length;

		switch (length) {
		case 0:
			throw new ByteArrayIsEmptyException();
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
			// 获取最末位的字节
			long target = ByteUtils.byte2Long(source[length - 1]);

			// 遍历字节数组,从倒数第二位向前
			for (int index = length - 1; index > 0; index--) {

				// 数组的第(index-1)位,要向左移(length-index)字节
				target = target | (ByteUtils.byte2Long(source[index - 1]) << ((length - index) * 8));
			}

			return target;
		default:
			throw new ByteArrayLengthOutOfBoundsException();
		}
	}

	/**
	 * 字节数组转BCD码,字节数组长度必须为2的倍数
	 * 
	 * @param source
	 *            字节数组
	 * @return
	 */
	public static byte[] byteArray2BCD(byte[] source) {

		// 字节数组长度
		int sourceLength = source.length;
		// 若长度不为2的倍数,则抛出异常
		if (sourceLength % 2 != 0) {
			throw new ByteArrayLengthErrorException();
		}

		// BCD码
		byte[] target = new byte[sourceLength / 2];
		// 遍历字节数组
		for (int index = 0, length = target.length; index < length; index++) {

			// 前字节向左位移4位,与上后字节
			target[index] = (byte) (((byte) (source[index * 2] << 4)) | (source[index * 2 + 1]));
		}

		return target;
	}

	/**
	 * 将字节数组合并为字符串.<br>
	 * 本方法为取出每一位字节,直接作为字符处理,而不是作为ASCII值<br>
	 * 例如:字节49->字符49,而不是字节49->字符1(字符1的ASCII值是49)
	 * 
	 * @param source
	 *            字节数组
	 * @return
	 */
	public static String byteArray2String(byte[] source) {

		// 合并后的字符串
		StringBuffer target = new StringBuffer(source.length);
		// 遍历字节数组
		for (int index = 0, length = source.length; index < length; index++) {

			target.append(source[index]);
		}

		return target.toString();
	}

	/**
	 * 将字节数组顺序反转
	 * 
	 * @param source
	 *            字节数组
	 * @return
	 */
	public static byte[] reverse(byte[] source) {

		// 反转后的字节数组
		byte[] target = new byte[source.length];

		// 遍历需要反转的字节数组,反转只需遍历一半即可
		for (int index = 1, length = (source.length / 2); index <= length; index++) {

			// 反转字节数组的(i-1)即为原始数组的(length-i)位
			target[index - 1] = source[source.length - index];
			// 反转字节数组的(length-i)即为原始数组的(i-1)位
			target[target.length - index] = source[index - 1];
		}

		// 若长度为单数,则进行赋值
		if (source.length % 2 == 1) {
			target[target.length / 2] = source[source.length / 2];
		}

		return target;
	}

	/**
	 * 异或.将两个字节进行异或操作.
	 * 
	 * @param source1
	 *            字节1
	 * @param source2
	 *            字节2
	 * @return
	 */
	public static byte xor(byte source1, byte source2) {

		return (byte) (source1 ^ source2);
	}

	/**
	 * 异或.将两个字节数组进行异或操作.
	 * 
	 * @param source1
	 *            字节数组1
	 * @param source2
	 *            字节数组2
	 * @return
	 */
	public static byte[] xor(byte[] source1, byte[] source2) {

		// 长度不一致,则抛出异常
		if (source1.length != source2.length) {
			throw new ByteArrayLengthErrorException();
		}

		// 返回的字节数组
		byte[] target = new byte[source1.length];
		// 遍历传入的字节数组
		for (int index = 0; index < source1.length; index++) {

			// 异或每一位
			target[index] = xor(source1[index], source2[index]);
		}

		return target;
	}

	/**
	 * 查找字节数组中,某段字节数组的位置
	 * 
	 * @param source
	 *            待查找的字节数组
	 * @param target
	 *            查找的字节数组
	 * @return
	 */
	public static int indexOf(byte[] source, byte[] target) {

		return indexOf(source, target, 0);
	}

	/**
	 * 查找字节数组中,某段字节数组的位置
	 * 
	 * @param source
	 *            待查找的字节数组
	 * @param target
	 *            查找的字节数组
	 * @param fromIndex
	 *            待查找的字节数组的起始位置
	 * @return
	 */
	public static int indexOf(byte[] source, byte[] target, int fromIndex) {

		return indexOf(source, 0, source.length, target, 0, target.length, fromIndex);
	}

	/**
	 * 查找字节数组中,某段字节数组的位置
	 * 
	 * @param source
	 *            待查找的字节数组
	 * @param sourceOffset
	 *            查找的起始位置
	 * @param sourceCount
	 *            查找的长度
	 * @param target
	 *            查找的字节数组
	 * @param targetOffset
	 *            查找的字节数组的起始位置
	 * @param targetCount
	 *            查找的字节数组的长度
	 * @param fromIndex
	 *            查找的起始位置
	 * @return
	 */
	public static int indexOf(byte[] source, int sourceOffset, int sourceCount, byte[] target, int targetOffset,
			int targetCount, int fromIndex) {

		if (fromIndex >= sourceCount) {
			return (targetCount == 0 ? sourceCount : -1);
		}
		if (fromIndex < 0) {
			fromIndex = 0;
		}
		if (targetCount == 0) {
			return fromIndex;
		}

		byte first = target[targetOffset];
		int max = sourceOffset + (sourceCount - targetCount);

		for (int index = sourceOffset + fromIndex; index <= max; index++) {
			if (source[index] != first) {
				while (++index <= max && source[index] != first)
					;
			}

			if (index <= max) {
				int j = index + 1;
				int end = j + targetCount - 1;
				for (int k = targetOffset + 1; j < end && source[j] == target[k]; j++, k++)
					;

				if (j == end) {
					return index - sourceOffset;
				}
			}
		}
		return -1;
	}

	/**
	 * 获取指定下标位的值
	 * 
	 * @param data
	 * @param index
	 * @return
	 */
	public static byte bitAt(short data, int index) {

		if (index >= (2 * 8)) {
			throw new IndexOutOfBoundsException();
		}

		return (byte) (data >> (16 - index - 1) & 1);
	}

	/**
	 * 获取指定下标位的值
	 * 
	 * @param data
	 * @param index
	 * @return
	 */
	public static byte bitAt(int data, int index) {

		if (index >= (4 * 8)) {
			throw new IndexOutOfBoundsException();
		}

		return (byte) (data >> (16 - index - 1) & 1);
	}

	/**
	 * 获取指定下标位的值
	 * 
	 * @param data
	 * @param index
	 * @return
	 */
	public static byte bitAt(long data, int index) {

		if (index >= (8 * 8)) {
			throw new IndexOutOfBoundsException();
		}

		return (byte) (data >> (16 - index - 1) & 1);
	}
}
