package cn.xuyingqi.util;

import java.util.HashSet;

/**
 * Set工厂类
 * 
 * @author Administrator
 *
 */
public class SetFactory {

	/**
	 * 获取一个新的HashSet对象
	 * 
	 * @return
	 */
	public static <T> HashSet<T> newInstance() {
		return new HashSet<T>();
	}
}
