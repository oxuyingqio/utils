package cn.xuyingqi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import cn.xuyingqi.utils.exception.DateParseException;

/**
 * 日期工具类
 * 
 * @author XuYQ
 *
 */
public final class DateUtils {

	/**
	 * 默认日期时间格式化
	 */
	private static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 默认日期格式化
	 */
	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	/**
	 * 默认时间格式化
	 */
	private static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

	/**
	 * 私有构造方法
	 */
	private DateUtils() {

	}

	/**
	 * 获取当前日期.使用getDate
	 * 
	 * @return
	 */
	@Deprecated
	public static final Date getNow() {

		return DateUtils.getDate();
	}

	/**
	 * 获取当前日期
	 * 
	 * @return
	 */
	public static final Date getDate() {

		return new Date();
	}

	/**
	 * 获取当前日期
	 * 
	 * @return
	 */
	public static final Calendar getCalendar() {

		return Calendar.getInstance();
	}

	/**
	 * 获取年份
	 * 
	 * @param date
	 * @return
	 */
	public static final int getYear(Date date) {

		Calendar calendar = DateUtils.getCalendar();
		calendar.setTime(date);
		return DateUtils.getYear(calendar);
	}

	/**
	 * 获取年份
	 * 
	 * @return
	 */
	public static final int getYear(Calendar calendar) {

		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 获取当前年份
	 * 
	 * @return
	 */
	public static final int getYear() {

		return DateUtils.getYear(DateUtils.getCalendar());
	}

	/**
	 * 获取月份
	 * 
	 * @param date
	 * @return
	 */
	public static final int getMonth(Date date) {

		Calendar calendar = DateUtils.getCalendar();
		calendar.setTime(date);
		return DateUtils.getMonth(calendar);
	}

	/**
	 * 获取月份
	 * 
	 * @param calendar
	 * @return
	 */
	public static final int getMonth(Calendar calendar) {

		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获取当前月份
	 * 
	 * @return
	 */
	public static final int getMonth() {

		return DateUtils.getMonth(DateUtils.getCalendar());
	}

	/**
	 * 获取天
	 * 
	 * @param date
	 * @return
	 */
	public static final int getDay(Date date) {

		Calendar calendar = DateUtils.getCalendar();
		calendar.setTime(date);
		return DateUtils.getDay(calendar);
	}

	/**
	 * 获取天
	 * 
	 * @param calendar
	 * @return
	 */
	public static final int getDay(Calendar calendar) {

		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取当前天
	 * 
	 * @return
	 */
	public static final int getDay() {

		return DateUtils.getDay(DateUtils.getCalendar());
	}

	/**
	 * 日期增加
	 * 
	 * @param date
	 *            日期
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @param week
	 *            周
	 * @param day
	 *            天
	 * @param hour
	 *            时
	 * @param minute
	 *            分
	 * @param second
	 *            秒
	 * @param millisecond
	 *            毫秒
	 * @return
	 */
	public static final Date add(Date date, int year, int month, int week, int day, int hour, int minute, int second,
			int millisecond) {

		Calendar calendar = DateUtils.getCalendar();
		calendar.setTime(date);

		return DateUtils.add(calendar, year, month, week, day, hour, minute, second, millisecond).getTime();
	}

	/**
	 * 日期增加
	 * 
	 * @param calendar
	 *            日期
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @param week
	 *            周
	 * @param day
	 *            天
	 * @param hour
	 *            时
	 * @param minute
	 *            分
	 * @param second
	 *            秒
	 * @param millisecond
	 *            毫秒
	 * @return
	 */
	public static final Calendar add(Calendar calendar, int year, int month, int week, int day, int hour, int minute,
			int second, int millisecond) {

		calendar.add(Calendar.YEAR, year);
		calendar.add(Calendar.MONTH, month);
		calendar.add(Calendar.DAY_OF_WEEK_IN_MONTH, week);
		calendar.add(Calendar.DAY_OF_MONTH, day);
		calendar.add(Calendar.HOUR_OF_DAY, hour);
		calendar.add(Calendar.MINUTE, minute);
		calendar.add(Calendar.SECOND, second);
		calendar.add(Calendar.MILLISECOND, millisecond);

		return calendar;
	}

	/**
	 * 间隔天数
	 * 
	 * @param date1
	 * @param date2
	 * @param ignoreTime
	 *            忽略时间,仅按日期计算
	 * @return
	 */
	public static final int intervalDays(Date date1, Date date2, boolean ignoreTime) {

		// 是否忽略时间
		if (ignoreTime) {

			Calendar calendar1 = DateUtils.getCalendar();
			calendar1.setTime(date1);
			Calendar calendar2 = DateUtils.getCalendar();
			calendar2.setTime(date2);
			return DateUtils.intervalDays(calendar1, calendar2, ignoreTime);
		} else {

			return (int) (Math.abs(date1.getTime() - date2.getTime()) / 1000 / 60 / 60 / 24);
		}
	}

	/**
	 * 间隔天数
	 * 
	 * @param calendar1
	 * @param calendar2
	 * @param ignoreTime
	 *            忽略时间,仅按日期计算
	 * @return
	 */
	public static final int intervalDays(Calendar calendar1, Calendar calendar2, boolean ignoreTime) {

		// 是否忽略时间
		if (ignoreTime) {

			calendar1.set(java.util.Calendar.HOUR_OF_DAY, 0);
			calendar1.set(java.util.Calendar.MINUTE, 0);
			calendar1.set(java.util.Calendar.SECOND, 0);
			calendar1.set(java.util.Calendar.MILLISECOND, 0);
			calendar2.set(java.util.Calendar.HOUR_OF_DAY, 0);
			calendar2.set(java.util.Calendar.MINUTE, 0);
			calendar2.set(java.util.Calendar.SECOND, 0);
			calendar2.set(java.util.Calendar.MILLISECOND, 0);

			return DateUtils.intervalDays(calendar1.getTime(), calendar2.getTime(), !ignoreTime);
		} else {

			return DateUtils.intervalDays(calendar1.getTime(), calendar2.getTime(), ignoreTime);
		}
	}

	/**
	 * 获取日期格式化工具
	 * 
	 * @param pattern
	 * @return
	 */
	public static final SimpleDateFormat getDateFormatInstance(String pattern) {

		return new SimpleDateFormat(pattern);
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static final String formatDate(Date date, String pattern) {

		return DateUtils.getDateFormatInstance(pattern).format(date);
	}

	/**
	 * 使用默认日期时间格式,格式化日期
	 * 
	 * @param date
	 * @return
	 */
	public static final String formatDateTime(Date date) {

		return DateUtils.formatDate(date, DEFAULT_DATE_TIME_FORMAT);
	}

	/**
	 * 使用默认日期格式,格式化日期
	 * 
	 * @param date
	 * @return
	 */
	public static final String formatDate(Date date) {

		return DateUtils.formatDate(date, DEFAULT_DATE_FORMAT);
	}

	/**
	 * 使用默认时间格式,格式化日期
	 * 
	 * @param date
	 * @return
	 */
	public static final String formatTime(Date date) {

		return DateUtils.formatDate(date, DEFAULT_TIME_FORMAT);
	}

	/**
	 * 解析日期
	 * 
	 * @param dateStr
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static final Date parseDate(String dateStr, String pattern) {

		try {

			return DateUtils.getDateFormatInstance(pattern).parse(dateStr);
		} catch (ParseException e) {

			throw new DateParseException("[数据]：" + dateStr + ".[格式]：" + pattern);
		}
	}

	/**
	 * 解析日期时间
	 * 
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static final Date parseDateTime(String dateStr) {

		return DateUtils.parseDate(dateStr, DEFAULT_DATE_TIME_FORMAT);
	}

	/**
	 * 解析日期
	 * 
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static final Date parseDate(String dateStr) {

		return DateUtils.parseDate(dateStr, DEFAULT_DATE_FORMAT);
	}

	/**
	 * Main函数测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(DateUtils.intervalDays(DateUtils.parseDate("2018-03-31"), DateUtils.getDate(), true));
	}
}