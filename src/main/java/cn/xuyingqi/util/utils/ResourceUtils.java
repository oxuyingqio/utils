package cn.xuyingqi.util.utils;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 资源文件工具类
 * 
 * @author XuYQ
 *
 */
public class ResourceUtils {

	// URL 前缀 file:
	public static final String URL_PREFIX_FILE = "file:";

	// URL Protocol jar
	public static final String URL_PROTOCOL_JAR = "jar";

	// 系统jar文件分隔符
	public static final String URL_JAR_SEPARATOR = "!/";

	/**
	 * URL的Protocol是否为Jar
	 * 
	 * @param url
	 * @return
	 */
	public static boolean isJarURL(URL url) {
		String protocol = url.getProtocol();
		return URL_PROTOCOL_JAR.equals(protocol);
	}

	/**
	 * 获取
	 * 
	 * @param jarUrl
	 * @return
	 * @throws MalformedURLException
	 */
	public static URL extractJarFileURL(URL jarUrl) throws MalformedURLException {
		String urlFile = jarUrl.getFile();
		System.out.println("=====================" + urlFile);
		int separatorIndex = urlFile.indexOf(URL_JAR_SEPARATOR);
		if (separatorIndex != -1) {
			String jarFile = urlFile.substring(0, separatorIndex);
			System.out.println("=====================" + jarFile);
			try {
				return new URL(jarFile);
			} catch (MalformedURLException ex) {
				if (!jarFile.startsWith("/")) {
					jarFile = "/" + jarFile;
				}
				return new URL(URL_PREFIX_FILE + jarFile);
			}
		} else {
			return jarUrl;
		}
	}
}
