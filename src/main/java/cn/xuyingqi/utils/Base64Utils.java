package cn.xuyingqi.utils;

import java.io.UnsupportedEncodingException;

/**
 * Base64工具类
 * 
 * @author XuYQ
 *
 */
public final class Base64Utils {

	/**
	 * 编码字符
	 */
	private static final char[] BASE64_ENCODE_CHARS = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e',
			'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/' };
	/**
	 * 解码字符
	 */
	private static final byte[] BASE64_DECODE_CHARS = new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
			-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
			-1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2,
			3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1,
			26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1,
			-1, -1, -1, -1 };

	/**
	 * 私有构造方法
	 */
	private Base64Utils() {

	}

	/**
	 * 编码
	 * 
	 * @param data
	 * @return
	 */
	public static final String encode(byte[] data) {

		StringBuffer sb = new StringBuffer();

		int length = data.length;
		int index = 0;
		int b1, b2, b3;

		while (index < length) {

			b1 = data[index++] & 0xff;
			if (index == length) {

				sb.append(BASE64_ENCODE_CHARS[b1 >>> 2]);
				sb.append(BASE64_ENCODE_CHARS[(b1 & 0x3) << 4]);
				sb.append("==");
				break;
			}

			b2 = data[index++] & 0xff;
			if (index == length) {

				sb.append(BASE64_ENCODE_CHARS[b1 >>> 2]);
				sb.append(BASE64_ENCODE_CHARS[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);
				sb.append(BASE64_ENCODE_CHARS[(b2 & 0x0f) << 2]);
				sb.append("=");
				break;
			}

			b3 = data[index++] & 0xff;
			sb.append(BASE64_ENCODE_CHARS[b1 >>> 2]);
			sb.append(BASE64_ENCODE_CHARS[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);
			sb.append(BASE64_ENCODE_CHARS[((b2 & 0x0f) << 2) | ((b3 & 0xc0) >>> 6)]);
			sb.append(BASE64_ENCODE_CHARS[b3 & 0x3f]);
		}

		return sb.toString();
	}

	/**
	 * 解码
	 * 
	 * @param str
	 * @return
	 */
	public static final byte[] decode(String str) throws UnsupportedEncodingException {

		StringBuffer sb = new StringBuffer();

		byte[] data = str.getBytes("US-ASCII");
		int length = data.length;
		int index = 0;
		int b1, b2, b3, b4;

		while (index < length) {

			do {

				b1 = BASE64_DECODE_CHARS[data[index++]];
			} while (index < length && b1 == -1);
			if (b1 == -1)
				break;

			do {

				b2 = BASE64_DECODE_CHARS[data[index++]];
			} while (index < length && b2 == -1);
			if (b2 == -1)
				break;

			sb.append((char) ((b1 << 2) | ((b2 & 0x30) >>> 4)));

			do {

				b3 = data[index++];
				if (b3 == 61)
					return sb.toString().getBytes("iso8859-1");
				b3 = BASE64_DECODE_CHARS[b3];
			} while (index < length && b3 == -1);
			if (b3 == -1)
				break;

			sb.append((char) (((b2 & 0x0f) << 4) | ((b3 & 0x3c) >>> 2)));

			do {

				b4 = data[index++];
				if (b4 == 61)
					return sb.toString().getBytes("iso8859-1");
				b4 = BASE64_DECODE_CHARS[b4];
			} while (index < length && b4 == -1);
			if (b4 == -1)
				break;

			sb.append((char) (((b3 & 0x03) << 6) | b4));
		}

		return sb.toString().getBytes("iso8859-1");
	}
}