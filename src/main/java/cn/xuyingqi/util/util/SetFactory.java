package cn.xuyingqi.util.util;

import java.util.HashSet;
import java.util.Set;

/**
 * Set工厂类
 * 
 * @author Administrator
 *
 */
public class SetFactory {

	/**
	 * 获取一个新的Set对象,默认返回的HashSet
	 * 
	 * @return
	 */
	public static <T> Set<T> newInstance() {
		return new HashSet<T>();
	}
}
