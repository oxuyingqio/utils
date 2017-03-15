package cn.xuyingqi.util.util;

import java.math.BigDecimal;

/**
 * 数学计算工具
 * 
 * @author XuYQ
 * 
 */
public class MathUtils {

	/**
	 * 加法 d1+d2
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static Double add(Integer d1, Integer d2) {

		BigDecimal bd1 = new BigDecimal(d1 == null ? "0" : d1.toString());
		BigDecimal bd2 = new BigDecimal(d2 == null ? "0" : d2.toString());

		return bd1.add(bd2).doubleValue();
	}

	/**
	 * 加法 d1+d2
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static Double add(Double d1, Double d2) {

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
	public static Double sub(Double d1, Double d2) {

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
	public static Double mul(Double d1, Double d2) {

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
	public static Double mul(Double d1, Double d2, int precision) {

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
	public static Double div(Double d1, Double d2) {

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
	public static Double div(Double d1, Double d2, int precision) {

		BigDecimal bd1 = new BigDecimal(d1 == null ? "0" : d1.toString());
		BigDecimal bd2 = new BigDecimal(d2 == null ? "0" : d2.toString());

		return bd1.divide(bd2).setScale(precision, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
