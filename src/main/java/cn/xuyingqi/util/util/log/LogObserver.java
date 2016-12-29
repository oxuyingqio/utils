package cn.xuyingqi.util.util.log;

/**
 * 日志观察者
 * 
 * @author XuYQ
 *
 */
public interface LogObserver {

	/**
	 * DEBUG级别日志
	 * 
	 * @param msg
	 */
	public void debug(String msg);

	/**
	 * INFO级别日志
	 * 
	 * @param msg
	 */
	public void info(String msg);

	/**
	 * WARN级别日志
	 * 
	 * @param msg
	 */
	public void warn(String warn);

	/**
	 * ERROR级别日志
	 * 
	 * @param msg
	 */
	public void error(String error);
}
