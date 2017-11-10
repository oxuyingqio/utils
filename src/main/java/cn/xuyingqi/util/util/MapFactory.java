package cn.xuyingqi.util.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Map工厂类
 * 
 * @author Administrator
 *
 */
public class MapFactory {

	/**
	 * 获取一个新的Map对象,默认返回HashMap对象
	 * 
	 * @return
	 */
	public static <K, V> Map<K, V> newInstance() {
		return new HashMap<K, V>();
	}
}
