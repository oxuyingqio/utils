package cn.xuyingqi.util;

import java.util.ArrayList;

/**
 * List工厂类
 * 
 * @author Administrator
 *
 */
public class ListFactory {

	/**
	 * 获取一个新的ArrayList对象
	 * 
	 * @return
	 */
	public static <T> ArrayList<T> newInstance() {
		return new ArrayList<T>();
	}
}
