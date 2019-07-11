package cn.xuyingqi.utils;

import java.math.BigDecimal;

/**
 * 数学工具类
 * 
 * @author XuYQ
 * 
 */
public final class MathUtils {

	/**
	 * 私有构造方法
	 */
	private MathUtils() {

	}

	/**
	 * 加法 d1+d2
	 * 
	 * @param i1
	 * @param i2
	 * @return
	 */
	public static final Double add(Integer i1, Integer i2) {

		BigDecimal bd1 = new BigDecimal(i1 == null ? "0" : i1.toString());
		BigDecimal bd2 = new BigDecimal(i2 == null ? "0" : i2.toString());

		return bd1.add(bd2).doubleValue();
	}

	/**
	 * 加法 d1+d2
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static final Double add(Double d1, Double d2) {

		BigDecimal bd1 = new BigDecimal(d1 == null ? "0" : d1.toString());
		BigDecimal bd2 = new BigDecimal(d2 == null ? "0" : d2.toString());

		return bd1.add(bd2).doubleValue();
	}

	/**
	 * 减法 d1-d2
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static final Double sub(Double d1, Double d2) {

		BigDecimal bd1 = new BigDecimal(d1 == null ? "0" : d1.toString());
		BigDecimal bd2 = new BigDecimal(d2 == null ? "0" : d2.toString());

		return bd1.subtract(bd2).doubleValue();
	}

	/**
	 * 乘法 d1*d2
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static final Double mul(Double d1, Double d2) {

		BigDecimal bd1 = new BigDecimal(d1 == null ? "0" : d1.toString());
		BigDecimal bd2 = new BigDecimal(d2 == null ? "0" : d2.toString());

		return bd1.multiply(bd2).doubleValue();
	}

	/**
	 * 乘法 d1*d2,4舍5入
	 * 
	 * @param d1
	 * @param d2
	 * @param precision
	 *            精度
	 * @return
	 */
	public static final Double mul(Double d1, Double d2, int precision) {

		BigDecimal bd1 = new BigDecimal(d1 == null ? "0" : d1.toString());
		BigDecimal bd2 = new BigDecimal(d2 == null ? "0" : d2.toString());

		return bd1.multiply(bd2).setScale(precision, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 除法 d1/d2
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	@Deprecated
	public static final Double div(Double d1, Double d2) {

		BigDecimal bd1 = new BigDecimal(d1 == null ? "0" : d1.toString());
		BigDecimal bd2 = new BigDecimal(d2 == null ? "0" : d2.toString());

		return bd1.divide(bd2).doubleValue();
	}

	/**
	 * 除法 d1/d2,4舍5入
	 * 
	 * @param d1
	 * @param d2
	 * @param precision
	 *            精度
	 * @return
	 */
	public static final Double div(Double d1, Double d2, int precision) {

		BigDecimal bd1 = new BigDecimal(d1 == null ? "0" : d1.toString());
		BigDecimal bd2 = new BigDecimal(d2 == null ? "0" : d2.toString());

		return bd1.divide(bd2, precision, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * Main函数测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(MathUtils.div(1d, 4d, 2));
	}
}