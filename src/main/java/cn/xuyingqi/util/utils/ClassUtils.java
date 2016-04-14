package cn.xuyingqi.util.utils;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * 类工具类
 * 
 * @author XuYQ
 *
 */
public class ClassUtils {

	/**
	 * 获取类字段,及递归获取父类字段,忽略访问级别
	 * 
	 * @param clazz
	 * @return
	 */
	public static Set<Field> getFieldSet(Class<?> clazz) {
		Set<Field> fieldSet = SetFactory.newInstance();

		// 查找本类字段
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0, length = fields.length; i < length; i++) {
			fieldSet.add(fields[i]);
		}

		// 递归调用查找父类字段
		Class<?> claSuper = clazz.getSuperclass();
		if (claSuper != null) {
			fieldSet.addAll(getFieldSet(claSuper));
		}

		return fieldSet;
	}

	/**
	 * 获取类字段,本类不存在时,继续向父类寻找,忽略访问级别
	 * 
	 * @param clazz
	 * @param fieldName
	 * @return
	 */
	public static Field getField(Class<?> clazz, String fieldName) {
		// 查找本类字段
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			if (fieldName.equals(fields[i].getName())) {
				return fields[i];
			}
		}

		// 递归调用查找父类字段
		Class<?> claSuper = clazz.getSuperclass();
		if (claSuper != null) {
			return getField(claSuper, fieldName);
		}

		return null;
	}
}
