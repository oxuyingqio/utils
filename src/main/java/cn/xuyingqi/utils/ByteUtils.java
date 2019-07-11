package cn.xuyingqi.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import cn.xuyingqi.utils.exception.ByteArrayIsEmptyException;
import cn.xuyingqi.utils.exception.ByteArrayLengthErrorException;
import cn.xuyingqi.utils.exception.ByteArrayLengthOutOfBoundsException;

/**
 * 字节工具类<br>
 * <br>
 * 1.byte 1字节8位; short 2字节16位; int 4字节32位; long 8字节64位;<br>
 * 2.byte,short,int,long均为有符号数据,即第一位均为符号位.<br>
 * 3.&(与)操作. 若两位均为1,则结果为1; 任意值与上1都为它本身.<br>
 * 4.|(或)操作. 若两位有一位为1,则结果为1; 任意值或上0都为它本身.<br>
 * 5.^(异或)操作. 若两位不同则为1,相同则为0.<br>
 * 
 * @author XuYQ
 *
 */
public final class ByteUtils {

	/**
	 * 私有构造方法
	 */
	private ByteUtils() {

	}

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
	public static final short byte2Short(byte source) {

		return (short) (source & 0xff);
	}

	/**
	 * 将短整型拆分为长度为2的字节数组
	 * 
	 * @param source
	 *            短整型
	 * @return
	 */
	public static final byte[] short2ByteArray(short source) {

		// 拆分后的字节数组
		byte[] target = new byte[2];
		// 高字节右移8位,即把低字节舍去.再强转为byte,即仅取右移后的8位低字节
		target[0] = (byte) (source >> 8);
		target[1] = (byte) source;

		return target;
	}

	/**
	 * 将字节数组(0<长度<=2)合并为短整型
	 * 
	 * @param source
	 *            字节数组
	 * @return
	 */
	public static final short byteArray2Short(byte[] source) {

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
	 * 将无符号字节(即8位均为数据的字节)转换为有符号的整型;
	 * 
	 * @param source
	 *            无符号字节
	 * @return
	 */
	public static final int byte2Int(byte source) {

		return (source & 0xff);
	}

	/**
	 * 将整型拆分为长度为4的字节数组
	 * 
	 * @param source
	 *            整型
	 * @return
	 */
	public static final byte[] int2ByteArray(int source) {

		// 拆分后的字节数组
		byte[] target = new byte[4];
		// 遍历数组
		for (int index = 1, length = target.length; index <= length; index++) {

			// 数组的第(index-1)位,要向右移(length-index)*8字节
			target[index - 1] = (byte) (source >> ((length - index) * 8));
		}

		return target;
	}

	/**
	 * 将字节数组(0<长度<=4)合并为整型
	 * 
	 * @param source
	 *            字节数组
	 * @return
	 */
	public static final int byteArray2Int(byte[] source) {

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
	 * 将无符号字节(即8位均为数据的字节)转换为有符号的长整型;
	 * 
	 * @param source
	 *            无符号字节
	 * @return
	 */
	public static final long byte2Long(byte source) {

		return (source & 0xff);
	}

	/**
	 * 将长整型拆分为长度为8的字节数组
	 * 
	 * @param source
	 *            长整型
	 * @return
	 */
	public static final byte[] long2ByteArray(long source) {

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
	 * 将字节数组(0<长度<=8)合并为长整型
	 * 
	 * @param source
	 *            字节数组
	 * @return
	 */
	public static final long byteArray2Long(byte[] source) {

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
	 * BCD码转字节数组
	 * 
	 * @param source
	 *            bcd码
	 * @return
	 */
	public static final byte[] bcd2ByteArray(byte[] source) {

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
	 * 字节数组转BCD码,字节数组长度必须为2的倍数
	 * 
	 * @param source
	 *            字节数组
	 * @return
	 */
	public static final byte[] byteArray2BCD(byte[] source) {

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
	 * 将单字符十六进制字符串拆分为字节数组.<br>
	 * 本方法为取出每一个十六进制字符,将其直接转为byte,而非使用ASCII值进行转换<br>
	 * 例如:字符A->字节10,而不是字符A->字节65(字符A的ASCII值是65)
	 * 
	 * @param source
	 *            字符串
	 * @return
	 */
	public static final byte[] singleHexString2ByteArray(String source) {

		// 拆分后的字节数组
		byte[] target = new byte[source.length()];
		// 遍历字符串每一个字符
		for (int index = 0, length = source.length(); index < length; index++) {

			target[index] = Byte.valueOf(source.charAt(index) + "", 16);
		}

		return target;
	}

	/**
	 * 将字节数组合并为单字符十六进制字符串.(单字节不能超过16)<br>
	 * 本方法为取出每一位字节,直接作为字符处理,而不是作为ASCII值<br>
	 * 例如:字节65->字符65,而不是字节65->字符A(字符A的ASCII值是65)
	 * 
	 * @param source
	 *            字节数组
	 * @return
	 */
	public static final String byteArray2SingleHexString(byte[] source) {

		// 合并后的字符串
		StringBuffer target = new StringBuffer(source.length);
		// 遍历字节数组
		for (int index = 0, length = source.length; index < length; index++) {

			target.append(Integer.toHexString(ByteUtils.byte2Int(source[index])).toUpperCase());
		}

		return target.toString();
	}

	/**
	 * 将双字符十六进制字符串拆分为字节数组.<br>
	 * 本方法为取出每两个字符,将其直接转为byte,而非使用ASCII值进行转换<br>
	 * 例如:字符0A->字节10,而不是字符0A->字节65(字符A的ASCII值是65)<br>
	 * 本方法与单字符的区别在于一个是两个字符代表一位字节,一个是一个字符代表一位字节.
	 * 
	 * @param source
	 *            字符串
	 * @return
	 */
	public static final byte[] doubleHexString2ByteArray(String source) {

		// 拆分后的字节数组
		byte[] target = new byte[source.length() / 2];
		// 遍历字符串每两个字符
		for (int index = 0; index < target.length; index++) {

			// 获取值.使用短整型接,预防数值越界
			short value = Short.valueOf(source.charAt(2 * index) + "" + source.charAt(2 * index + 1), 16);
			// 强转为byte
			target[index] = (byte) value;
		}

		return target;
	}

	/**
	 * 将字节数组合并为双字符十六进制字符串.<br>
	 * 本方法为取出每一位字节,直接作为字符处理,而不是作为ASCII值<br>
	 * 例如:字节65->字符65,而不是字节65->字符0A(字符0A的ASCII值是65)
	 * 
	 * @param source
	 *            字节数组
	 * @return
	 */
	public static final String byteArray2DoubleHexString(byte[] source) {

		// 合并后的字符串
		StringBuffer target = new StringBuffer(source.length);
		// 遍历字节数组
		for (int index = 0, length = source.length; index < length; index++) {

			// 获取对应16进制字符串
			String hex = Integer.toHexString(ByteUtils.byte2Int(source[index])).toUpperCase();
			// 判断是否仅一位.仅一位则补0
			if (hex.length() == 1) {

				target.append("0");
			}
			target.append(hex);
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
	public static final byte[] reverse(byte[] source) {

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
	public static final byte xor(byte source1, byte source2) {

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
	public static final byte[] xor(byte[] source1, byte[] source2) {

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
	public static final int indexOf(byte[] source, byte[] target) {

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
	public static final int indexOf(byte[] source, byte[] target, int fromIndex) {

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
	public static final int indexOf(byte[] source, int sourceOffset, int sourceCount, byte[] target, int targetOffset,
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
	 * 获取指定下标位的值,下标从左向右,从0开始
	 * 
	 * @param data
	 * @param index
	 * @return
	 */
	public static final byte bitAt(byte data, int index) {

		if (index >= 8) {

			throw new IndexOutOfBoundsException();
		}

		return (byte) (data >> (8 - index - 1) & 1);
	}

	/**
	 * 获取指定下标位的值
	 * 
	 * @param data
	 * @param index
	 * @return
	 */
	public static final byte bitAt(short data, int index) {

		if (index >= 16) {

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
	public static final byte bitAt(int data, int index) {

		if (index >= 32) {

			throw new IndexOutOfBoundsException();
		}

		return (byte) (data >> (32 - index - 1) & 1);
	}

	/**
	 * 获取指定下标位的值
	 * 
	 * @param data
	 * @param index
	 * @return
	 */
	public static final byte bitAt(long data, int index) {

		if (index >= 64) {

			throw new IndexOutOfBoundsException();
		}

		return (byte) (data >> (64 - index - 1) & 1);
	}

	/**
	 * 设置某位的值
	 * 
	 * @param data
	 *            数据
	 * @param index
	 *            指定位
	 * @param value
	 *            值,true为1,false为0
	 * @return
	 */
	public static final byte setBit(byte data, int index, boolean value) {

		if (index <= 0 || index >= 8) {

			throw new IndexOutOfBoundsException();
		}

		if (value) {

			return (byte) (data | (1 << (7 - index)));
		} else {

			return (byte) (data & ~(1 << (7 - index)));
		}
	}

	/**
	 * 设置某位的值
	 * 
	 * @param data
	 *            数据
	 * @param index
	 *            指定位
	 * @param value
	 *            值,true为1,false为0
	 * @return
	 */
	public static final short setBit(short data, int index, boolean value) {

		if (index <= 0 || index >= 16) {

			throw new IndexOutOfBoundsException();
		}

		if (value) {

			return (short) (data | (1 << (16 - index)));
		} else {

			return (short) (data & ~(1 << (16 - index)));
		}
	}

	/**
	 * 设置某位的值
	 * 
	 * @param data
	 *            数据
	 * @param index
	 *            指定位
	 * @param value
	 *            值,true为1,false为0
	 * @return
	 */
	public static final int setBit(int data, int index, boolean value) {

		if (index <= 0 || index >= 32) {

			throw new IndexOutOfBoundsException();
		}

		if (value) {

			return (int) (data | (1 << (32 - index)));
		} else {

			return (int) (data & ~(1 << (32 - index)));
		}
	}

	/**
	 * 设置某位的值
	 * 
	 * @param data
	 *            数据
	 * @param index
	 *            指定位
	 * @param value
	 *            值,true为1,false为0
	 * @return
	 */
	public static final long setBit(long data, int index, boolean value) {

		if (index <= 0 || index >= 64) {

			throw new IndexOutOfBoundsException();
		}

		if (value) {

			return (long) (data | (1 << (64 - index)));
		} else {

			return (long) (data & ~(1 << (64 - index)));
		}
	}

	/**
	 * 时间转换为十六进制七字节字节数组(年低字节在前高字节在后物联网表协议专用)
	 * 
	 * @author xujh
	 * 
	 * @param date
	 *            时间
	 * 
	 * @return 时间字节数组
	 */
	public static final byte[] date2ByteArray(Date date) {

		// 目标字节数组
		byte[] target = new byte[7];

		// 获得当前日期字符串
		String dateStr = DateUtils.formatDate(date, "yyyy MM dd HH mm ss");
		// 分割字符串
		String[] dateStrs = dateStr.split(" ");

		// 设置字节数组数据
		short year = Short.valueOf(dateStrs[0]);
		target[0] = (byte) year;
		target[1] = (byte) (year >> 8);
		target[2] = Byte.valueOf(dateStrs[1]);
		target[3] = Byte.valueOf(dateStrs[2]);
		target[4] = Byte.valueOf(dateStrs[3]);
		target[5] = Byte.valueOf(dateStrs[4]);
		target[6] = Byte.valueOf(dateStrs[5]);

		return target;
	}

	/**
	 * 时间(年月日)转换为十六进制两个字节字节数组(低字节在前高字节在后物联网表协议专用)
	 * 
	 * @author xujh
	 * 
	 * @param date
	 *            时间
	 * 
	 * @return 时间(年月日YYMMDD)字节数组
	 */
	public static final byte[] date2DoubleByteArray(Date date) {

		// 待返回字节数组
		byte[] target = new byte[2];

		// 格式化当前时间
		String dateStr = DateUtils.formatDate(date, "yyyy MM dd");
		// 时间数组
		String[] dateStrs = dateStr.split(" ");

		// 年
		int year = Integer.parseInt(dateStrs[0]);
		// 月
		int month = Integer.parseInt(dateStrs[1]);
		// 日
		int day = Integer.parseInt(dateStrs[2]);
		// 年求余
		year = year % 100;
		// 年左移9位
		year = year << 9;
		// 月左移5位
		month = month << 5;

		int newDate = year | month | day;
		// 获得低字节在前高字节在后双字节字节数组
		target = ByteUtils.reverse(ByteUtils.short2ByteArray((short) newDate));

		// 返回两字节字节数组
		return target;
	}

	/**
	 * 压缩的双字节日期字节数组转换成标准日期
	 * 
	 * @author xujh
	 * @since 2018-1-29 16:57:35
	 * 
	 * @param dateByte
	 * 
	 * @return 标准日期(yyyy-MM-dd)
	 */
	public static final Date doubleDateByteArray2Date(byte[] dateByte) {

		// 获得年
		int year = (dateByte[0] >> 1) + 2000;
		// 获得月
		int month = ((ByteUtils.byteArray2Int(dateByte)) & 0x01E0) >> 5;
		// 获得日
		int day = (dateByte[1] & 0x1f);

		String formatDate = year + "-" + month + "-" + day;

		return DateUtils.parseDate(formatDate);
	}

	/**
	 * 七个字节数组日期转换成时间格式
	 * 
	 * @param dateByteArray
	 *            时间字节数组(年是低字节在前高字节在后)
	 * 
	 * @author xujh
	 * 
	 * @since 2017-10-11 12:15:16
	 * 
	 * @return 格式化后时间(yyyy-MM-dd HH:mm:ss)
	 */
	public static final Date byteArray2Date(byte[] dateByteArray) {

		// 上报时间字节数组
		String month = "";
		String day = "";
		String hours = "";
		String minute = "";
		String second = "";
		// 月
		if ((int) dateByteArray[2] < 10) {

			month = "0" + ByteUtils.byteArray2Int(new byte[] { dateByteArray[2] });
		} else {

			month = ByteUtils.byteArray2Int(new byte[] { dateByteArray[2] }) + "";
		}
		// 日
		if ((int) dateByteArray[3] < 10) {

			day = "0" + ByteUtils.byteArray2Int(new byte[] { dateByteArray[3] });
		} else {

			day = ByteUtils.byteArray2Int(new byte[] { dateByteArray[3] }) + "";
		}
		// 时
		if ((int) dateByteArray[4] < 10) {

			hours = "0" + ByteUtils.byteArray2Int(new byte[] { dateByteArray[4] });
		} else {

			hours = ByteUtils.byteArray2Int(new byte[] { dateByteArray[4] }) + "";
		}

		// 分
		if ((int) dateByteArray[5] < 10) {

			minute = "0" + ByteUtils.byteArray2Int(new byte[] { dateByteArray[5] });
		} else {

			minute = ByteUtils.byteArray2Int(new byte[] { dateByteArray[5] }) + "";
		}

		// 秒
		if ((int) dateByteArray[6] < 10) {

			second = "0" + ByteUtils.byteArray2Int(new byte[] { dateByteArray[6] });
		} else {

			second = ByteUtils.byteArray2Int(new byte[] { dateByteArray[6] }) + "";
		}

		// 上报时间
		String date = ByteUtils.byteArray2Int(new byte[] { dateByteArray[1], dateByteArray[0] }) + "-" + month + "-"
				+ day + " " + hours + ":" + minute + ":" + second;

		return DateUtils.parseDateTime(date);
	}

	/**
	 * 四个字节数组日期转换成时间格式
	 * 
	 * @param dateByteArray
	 *            时间字节数组(年是低字节在前高字节在后)
	 * 
	 * @author xujh
	 * 
	 * @since 2018-8-9 15:38:02
	 * 
	 * @return 格式化后时间(yyyy-MM-dd HH:mm:ss)
	 */
	public static final Date fourByteArray2Date(byte[] dateByteArray) {

		// 上报时间字节数组
		String month = "";
		String day = "";

		// 月
		if ((int) dateByteArray[2] < 10) {

			month = "0" + ByteUtils.byteArray2Int(new byte[] { dateByteArray[2] });
		} else {

			month = ByteUtils.byteArray2Int(new byte[] { dateByteArray[2] }) + "";
		}
		// 日
		if ((int) dateByteArray[3] < 10) {

			day = "0" + ByteUtils.byteArray2Int(new byte[] { dateByteArray[3] });
		} else {

			day = ByteUtils.byteArray2Int(new byte[] { dateByteArray[3] }) + "";
		}

		// 上报时间
		String date = ByteUtils.byteArray2Int(new byte[] { dateByteArray[1], dateByteArray[0] }) + "-" + month + "-"
				+ day;

		return DateUtils.parseDate(date);
	}

	/**
	 * 字节数组转成16进制拼接字符串(字节空格间隔)
	 * 
	 * @since 2017-10-18 17:04:41
	 * 
	 * @param byteArray
	 *            待转换字节数组
	 * 
	 * @return 拼接后的16进制字符串
	 */
	public static final String byteArray2HexStringAppend(byte[] byteArray) {

		// 待返回字符串
		StringBuffer buffer = new StringBuffer();
		// 遍历拼接
		for (byte dByte : byteArray) {

			String str = Integer.toHexString(ByteUtils.byte2Short(dByte));
			buffer.append(str.length() < 2 ? ("0" + str) : str).append(" ");
		}
		// 返回
		return buffer.toString();
	}

	/**
	 * 字节数组累加和取反
	 * 
	 * @param byteArray
	 *            待累加和取反字节数组
	 * 
	 * @return 返回累加和取反
	 */
	public static final byte byteArray2SumNegation(byte[] byteArray) {

		long dataSumNegation = 0;
		if (byteArray != null && byteArray.length > 0) {

			for (int i = 0; i < byteArray.length; i++) {

				dataSumNegation += (long) (byteArray[i] & 0xff);
			}
			// 取反
			dataSumNegation = ~dataSumNegation;
		}

		return (byte) dataSumNegation;
	}
	
	/**
	  * 天信MODBUS协议计算CRC16校验码
	  *
	  * @param bytes
	  * 
	  * @return	十六进制字符串
	  */
	 public static String getCRC(byte[] bytes) {
	     int CRC = 0x0000ffff;
	     int POLYNOMIAL = 0x0000a001;

	     int i, j;
	     for (i = 0; i < bytes.length; i++) {
	         CRC ^= ((int) bytes[i] & 0x000000ff);
	         for (j = 0; j < 8; j++) {
	             if ((CRC & 0x00000001) != 0) {
	                 CRC >>= 1;
	                 CRC ^= POLYNOMIAL;
	             } else {
	                 CRC >>= 1;
	             }
	         }
	     }
	     return Integer.toHexString(CRC);
	 }
		/**
		 * 获取文件内某段文件
		 * 
		 * @param	file	文件
		 * 
		 * @param	byteLength	索要文件字节大小
		 * 
		 * @param	count	索要文件段
		 * 
		 * @return	索要文件字节数组
		 * */
		@SuppressWarnings("resource")
		public static byte[] getDataByteArrayFromFile(File file,int byteLength,int count){
			FileInputStream fileInputStream = null;
		    try {
		    	fileInputStream = new FileInputStream(file);
		    	int length = 0;
		    	byte[] buf = new byte[byteLength];  //建立缓存数组，缓存数组的大小一般都是1024的整数倍，理论上越大效率越好
		    	int i = 1;
				while((length = fileInputStream.read(buf))!=-1){
				    if(i==count){
				    	byte[] rtnByteArray = new byte[length];
				    	System.arraycopy(buf, 0, rtnByteArray, 0, rtnByteArray.length);
				    	return rtnByteArray;
				    }
				    i++;
				}
				fileInputStream.close(); //关闭资源
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}
		    return null;
		}
	
	/**
	 * Main函数测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "88 00 2f 00 68 d4 ac e3 6b c1 0a 32 30 31 38 31 31 30 38 30 30 30 30 30 30 31 36 52 14 00 00 00 01 04 3e 24 24 0f 00 00 00 00 e2 07 0b 07 32 33 30 ad 16 77 ";
		str = str.replaceAll(" ", "");
		System.out.println(str);
//		System.out.println(BigDecimal.valueOf(Long.valueOf("123456395900")).divide(new BigDecimal(100)).longValue());
//		String str = "2863311530";
//		Integer in = Integer.valueOf(str);
//		System.out.println(in);
//		byte[] bt = ByteUtils.long2ByteArray(Long.valueOf(str));
//		byte[] bt1 = new byte[4];
//		System.arraycopy(bt, 4, bt1, 0, bt1.length);
//		System.out.println(ByteUtils.byteArray2DoubleHexString(bt1));
//		File file = new File("D:/filePath/default/APP2.bin");
//		
//		System.out.println("文件名称："+file.getName()+"文件大小："+file.length());
//		
//		 FileInputStream fileInputStream = null;
//		try {
//			fileInputStream = new FileInputStream(file);
//			int length = 0;
//		    byte[] buf = new byte[fileInputStream.available()];  //建立缓存数组，缓存数组的大小一般都是1024的整数倍，理论上越大效率越好
//				while((length = fileInputStream.read(buf))!=-1){
//				    System.out.println("CRC校验码："+ByteUtils.getCRC(buf));
//				}
//				fileInputStream.close(); //关闭资源
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println(BigDecimal.valueOf(2.2).multiply(new BigDecimal(100)).intValue());

	}
}