package cn.xuyingqi.util.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

import org.apache.commons.lang3.text.WordUtils;

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

	/**
	 * 获取对应字段的set方法
	 * 
	 * @param field
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public static Method getSetMethod(Class<?> clazz, Field field) throws NoSuchMethodException, SecurityException {
		String setMethodName = "set" + WordUtils.capitalize(field.getName());
		return clazz.getMethod(setMethodName, field.getType());
	}

	/**
	 * 获取对应字段的get方法
	 * 
	 * @param field
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public static Method getGetMethod(Class<?> clazz, Field field) throws NoSuchMethodException, SecurityException {
		String setMethodName = "get" + WordUtils.capitalize(field.getName());
		return clazz.getMethod(setMethodName, field.getType());
	}

	/**
	 * 调用对象的set方法,仅支持byte,short,int,long,float,char,boolean,String类型及其封装类型
	 * 
	 * @param t
	 * @param field
	 * @param value
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static <T> void invokeSetMethod(T t, Field field, String value) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// 获取set方法
		Method setMethod = getSetMethod(t.getClass(), field);
		if (setMethod != null) {
			if (field.getType() == byte.class || field.getType() == Byte.class) {
				setMethod.invoke(t, Byte.valueOf(value));
			} else if (field.getType() == short.class || field.getType() == Short.class) {
				setMethod.invoke(t, Short.valueOf(value));
			} else if (field.getType() == int.class || field.getType() == Integer.class) {
				setMethod.invoke(t, Integer.valueOf(value));
			} else if (field.getType() == long.class || field.getType() == Long.class) {
				setMethod.invoke(t, Long.valueOf(value));
			} else if (field.getType() == float.class || field.getType() == Float.class) {
				setMethod.invoke(t, Float.valueOf(value));
			} else if (field.getType() == double.class || field.getType() == Double.class) {
				setMethod.invoke(t, Double.valueOf(value));
			} else if (field.getType() == char.class || field.getType() == Character.class) {
				setMethod.invoke(t, value.toCharArray()[0]);
			} else if (field.getType() == boolean.class || field.getType() == Boolean.class) {
				setMethod.invoke(t, Boolean.valueOf(value));
			} else if (field.getType() == String.class) {
				setMethod.invoke(t, value);
			}
		}
	}
}
