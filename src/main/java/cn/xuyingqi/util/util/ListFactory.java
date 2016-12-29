package cn.xuyingqi.util.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * List工厂类
 * 
 * @author Administrator
 *
 */
public class ListFactory {

	/**
	 * List类型
	 * 
	 * @author XuYQ
	 *
	 */
	public enum Type {

		ARRAY_LIST, LINKED_LIST
	}

	/**
	 * 获取一个新的List对象,默认返回的ArrayList
	 * 
	 * @return
	 */
	public static <T> List<T> newInstance() {

		return new ArrayList<T>();
	}

	/**
	 * 获取一个新的List对象
	 * 
	 * @param type
	 * @return
	 */
	public static <T> List<T> newInstance(ListFactory.Type type) {

		switch (type) {
		case ARRAY_LIST:
			return new ArrayList<T>();
		case LINKED_LIST:
			return new LinkedList<T>();
		default:
			return new ArrayList<T>();
		}
	}
}
