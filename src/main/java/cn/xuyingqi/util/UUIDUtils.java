package cn.xuyingqi.util;

import java.util.UUID;

/**
 * UUID工具类
 * 
 * @author XuYQ
 *
 */
public final class UUIDUtils {

	/**
	 * 获得4个长度的十六进制的UUID
	 * 
	 * @return UUID
	 */
	public static final String get4UUID() {

		String[] uuid = UUID.randomUUID().toString().split("-");

		return uuid[1];
	}

	/**
	 * 获得8个长度的十六进制的UUID
	 * 
	 * @return UUID
	 */
	public static final String get8UUID() {

		String[] uuid = UUID.randomUUID().toString().split("-");

		return uuid[0];
	}

	/**
	 * 获得12个长度的十六进制的UUID
	 * 
	 * @return UUID
	 */
	public static final String get12UUID() {

		String[] uuid = UUID.randomUUID().toString().split("-");

		return uuid[0] + uuid[1];
	}

	/**
	 * 获得16个长度的十六进制的UUID
	 * 
	 * @return UUID
	 */
	public static String get16UUID() {

		String[] uuid = UUID.randomUUID().toString().split("-");

		return uuid[0] + uuid[1] + uuid[2];
	}

	/**
	 * 获得20个长度的十六进制的UUID
	 * 
	 * @return UUID
	 */
	public static final String get20UUID() {

		String[] uuid = UUID.randomUUID().toString().split("-");

		return uuid[0] + uuid[1] + uuid[2] + uuid[3];
	}

	/**
	 * 获得24个长度的十六进制的UUID
	 * 
	 * @return UUID
	 */
	public static final String get24UUID() {

		String[] uuid = UUID.randomUUID().toString().split("-");

		return uuid[0] + uuid[1] + uuid[4];
	}

	/**
	 * 获得32个长度的十六进制的UUID
	 * 
	 * @return UUID
	 */
	public static final String get32UUID() {

		String[] uuid = UUID.randomUUID().toString().split("-");

		return uuid[0] + uuid[1] + uuid[2] + uuid[3] + uuid[4];
	}
}