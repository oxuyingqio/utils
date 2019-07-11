package cn.xuyingqi.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Map工厂类
 * 
 * @author XuYQ
 *
 */
public final class MapFactory {

	/**
	 * 私有构造方法
	 */
	private MapFactory() {

	}

	/**
	 * 获取一个新的Map对象,默认返回HashMap对象
	 * 
	 * @return
	 */
	public static final <K, V> Map<K, V> newInstance() {

		return new HashMap<K, V>();
	}
}