package cn.xuyingqi.utils;

import java.util.Vector;

/**
 * Vector工厂类
 * 
 * @author XuYQ
 *
 */
public final class VectorFactory {

	/**
	 * 私有构造方法
	 */
	private VectorFactory() {

	}

	/**
	 * 获取一个新的Vector对象
	 * 
	 * @return
	 */
	public static final <T> Vector<T> newInstance() {

		return new Vector<T>();
	}
}