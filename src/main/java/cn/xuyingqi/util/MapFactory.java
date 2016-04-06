package cn.xuyingqi.util;

import java.util.HashMap;

/**
 * Map工厂类
 * 
 * @author Administrator
 *
 */
public class MapFactory {

	/**
	 * 获取一个新的HashMap对象
	 * 
	 * @return
	 */
	public static <K, V> HashMap<K, V> newInstance() {
		return new HashMap<K, V>();
	}
}
