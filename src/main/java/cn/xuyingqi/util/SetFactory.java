package cn.xuyingqi.util;

import java.util.HashSet;
import java.util.Set;

/**
 * Set工厂类
 * 
 * @author XuYQ
 *
 */
public final class SetFactory {

	/**
	 * 私有构造方法
	 */
	private SetFactory() {

	}

	/**
	 * 获取一个新的Set对象,默认返回的HashSet
	 * 
	 * @return
	 */
	public static final <T> Set<T> newInstance() {

		return new HashSet<T>();
	}
}