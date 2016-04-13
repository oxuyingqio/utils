package cn.xuyingqi.util.utils;

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
	public static enum ListType {
		arrayList, linkedList
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
	 * @return
	 */
	public static <T> List<T> newInstance(ListFactory.ListType listType) {
		switch (listType) {
		case arrayList:
			return new ArrayList<T>();
		case linkedList:
			return new LinkedList<T>();
		default:
			return new ArrayList<T>();
		}
	}
}
