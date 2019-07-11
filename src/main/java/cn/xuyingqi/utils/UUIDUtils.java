package cn.xuyingqi.utils;

import java.util.UUID;

/**
 * UUID工具类
 * 
 * @author XuYQ
 *
 */
public final class UUIDUtils {

	/**
	 * 私有构造方法
	 */
	private UUIDUtils() {

	}

	/**
	 * 获得长度为4的UUID
	 * 
	 * @return
	 */
	public static final String get4UUID() {

		String[] uuid = UUID.randomUUID().toString().split("-");

		return uuid[1];
	}

	/**
	 * 获得长度为8的UUID
	 * 
	 * @return
	 */
	public static final String get8UUID() {

		String[] uuid = UUID.randomUUID().toString().split("-");

		return uuid[0];
	}

	/**
	 * 获得长度为12的UUID
	 * 
	 * @return
	 */
	public static final String get12UUID() {

		String[] uuid = UUID.randomUUID().toString().split("-");

		return uuid[0] + uuid[1];
	}

	/**
	 * 获得长度为16的UUID
	 * 
	 * @return
	 */
	public static final String get16UUID() {

		String[] uuid = UUID.randomUUID().toString().split("-");

		return uuid[0] + uuid[1] + uuid[2];
	}

	/**
	 * 获得长度为20的UUID
	 * 
	 * @return
	 */
	public static final String get20UUID() {

		String[] uuid = UUID.randomUUID().toString().split("-");

		return uuid[0] + uuid[1] + uuid[2] + uuid[3];
	}

	/**
	 * 获得长度为24的UUID
	 * 
	 * @return
	 */
	public static final String get24UUID() {

		String[] uuid = UUID.randomUUID().toString().split("-");

		return uuid[0] + uuid[1] + uuid[4];
	}

	/**
	 * 获得长度为32的UUID
	 * 
	 * @return
	 */
	public static final String get32UUID() {

		String[] uuid = UUID.randomUUID().toString().split("-");

		return uuid[0] + uuid[1] + uuid[2] + uuid[3] + uuid[4];
	}

	/**
	 * Main函数测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(UUID.randomUUID().toString());
	}
}