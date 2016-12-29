package cn.xuyingqi.util.util.log;

import java.util.Iterator;
import java.util.List;

import cn.xuyingqi.util.util.ListFactory;

/**
 * 日志
 * 
 * @author XuYQ
 *
 */
public class Log {

	/**
	 * 日志
	 */
	private static Log log;

	/**
	 * 日志观察者
	 */
	private List<LogObserver> observers = ListFactory.newInstance();

	/**
	 * 日志.私有构造
	 */
	private Log() {

	}

	/**
	 * 获取单例
	 * 
	 * @return
	 */
	public static final Log getInstance() {

		if (log == null) {
			log = new Log();
		}

		return log;
	}

	/**
	 * DEBUG
	 * 
	 * @param msg
	 */
	public void debug(String msg) {

		Iterator<LogObserver> i = this.observers.iterator();
		while (i.hasNext()) {

			i.next().debug(msg);
		}
	}

	/**
	 * INFO
	 * 
	 * @param msg
	 */
	public void info(String msg) {

		Iterator<LogObserver> i = this.observers.iterator();
		while (i.hasNext()) {

			i.next().info(msg);
		}
	}

	/**
	 * WARN
	 * 
	 * @param msg
	 */
	public void warn(String msg) {

		Iterator<LogObserver> i = this.observers.iterator();
		while (i.hasNext()) {

			i.next().warn(msg);
		}
	}

	/**
	 * ERROR
	 * 
	 * @param msg
	 */
	public void error(String msg) {

		Iterator<LogObserver> i = this.observers.iterator();
		while (i.hasNext()) {

			i.next().error(msg);
		}
	}

	/**
	 * 添加观察者
	 * 
	 * @param observer
	 */
	public void addObserver(LogObserver observer) {

		this.observers.add(observer);
	}

	/**
	 * 移除观察者
	 * 
	 * @param observer
	 */
	public void removeObserver(LogObserver observer) {

		this.observers.remove(observer);
	}
}
