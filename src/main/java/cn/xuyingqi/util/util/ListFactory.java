package cn.xuyingqi.util.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * List工厂类
 * 
 * @author XuYQ
 *
 */
public final class ListFactory {

	/**
	 * List类型
	 * 
	 * @author XuYQ
	 *
	 */
	public static enum ListType {

		ARRAY_LIST, LINKED_LIST
	}

	/**
	 * 私有构造方法
	 */
	private ListFactory() {

	}

	/**
	 * 获取一个新的List对象,默认返回的ArrayList
	 * 
	 * @return
	 */
	public static final <T> List<T> newInstance() {

		return ListFactory.newInstance(ListType.ARRAY_LIST);
	}

	/**
	 * 获取一个新的List对象
	 * 
	 * @return
	 */
	public static final <T> List<T> newInstance(ListFactory.ListType listType) {

		switch (listType) {
		case ARRAY_LIST:

			return new ArrayList<T>();
		case LINKED_LIST:

			return new LinkedList<T>();
		default:

			return new ArrayList<T>();
		}
	}
}