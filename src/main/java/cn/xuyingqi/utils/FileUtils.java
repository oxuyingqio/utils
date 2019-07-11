package cn.xuyingqi.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.List;

import cn.xuyingqi.utils.tool.operate.file.OperateFile;

/**
 * 文件工具类
 * 
 * @author XuYQ
 *
 */
public class FileUtils {

	/**
	 * 文件排序
	 * 
	 * @author XuYQ
	 *
	 */
	public enum Order {

		/**
		 * 先文件,后文件夹
		 */
		FILE_FOLDER,
		/**
		 * 先文件夹,后文件
		 */
		FOLDER_FILE
	}

	/**
	 * 将文件source复制到target (FileChannel复制)
	 * 
	 * @param source
	 *            待复制文件
	 * @param target
	 *            复制的位置
	 */
	public static void copyFileByChannel(File source, File target) {

		try {

			// 文件输入流
			FileInputStream fis = new FileInputStream(source);
			// 文件输出流
			FileOutputStream fos = new FileOutputStream(target);

			// 文件输入通道
			FileChannel fci = fis.getChannel();
			// 文件输出通道
			FileChannel fco = fos.getChannel();

			// 复制
			fci.transferTo(0, fci.size(), fco);

			// 关闭
			fis.close();
			fci.close();
			fos.close();
			fco.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 对文件列表进行排序
	 * 
	 * @param files
	 *            待排序的文件数组
	 * @param order
	 *            排序规则
	 */
	public static List<File> sortFileArray(File[] sources, FileUtils.Order order) {

		// 文件列表
		List<File> files = ListFactory.newInstance(ListFactory.ListType.LINKED_LIST);
		// 文件夹列表
		List<File> folders = ListFactory.newInstance(ListFactory.ListType.LINKED_LIST);
		// 返回列表
		List<File> target = ListFactory.newInstance(ListFactory.ListType.LINKED_LIST);

		// 遍历资源文件集合
		int i = 0;
		while (i++ < sources.length) {

			// 获取当前文件
			File file = sources[i - 1];

			// 判断类型
			if (file.isFile()) {
				files.add(file);
			} else {
				folders.add(file);
			}
		}

		// 判断排序方式
		switch (order) {
		case FILE_FOLDER:
			target.addAll(files);
			target.addAll(folders);
			break;
		case FOLDER_FILE:
			target.addAll(folders);
			target.addAll(files);
			break;
		}

		return target;
	}

	/**
	 * 递归文件目录,并操作文件
	 * 
	 * @param file
	 * @param operateFile
	 */
	public static void recursionFile(File file, OperateFile operateFile) {

		// 判断文件是否为空,且存在
		if (file != null && file.exists()) {

			// 操作文件
			operateFile.operateFile(file);

			// 文件是否为目录
			if (file.isDirectory()) {

				// 获取子文件集合
				File[] files = file.listFiles();

				// 遍历子文件,并操作子文件
				int i = 0;
				while (i++ < files.length) {

					// 获取当前文件
					recursionFile(files[i - 1], operateFile);
				}
			}
		}
	}

	/**
	 * 递归文件目录,并操作文件
	 * 
	 * @param file
	 * @param order
	 * @param operateFile
	 */
	public static void recursionFile(File file, FileUtils.Order order, OperateFile operateFile) {

		// 判断文件是否为空,且存在
		if (file != null && file.exists()) {

			// 操作文件
			operateFile.operateFile(file);

			// 文件是否为目录
			if (file.isDirectory()) {

				// 获取子文件,并排序
				List<File> files = FileUtils.sortFileArray(file.listFiles(), order);
				// 遍历子文件,并操作子文件
				for (int i = 0, length = files.size(); i < length; i++) {
					recursionFile(files.get(i), order, operateFile);
				}
			}
		}
	}

	/**
	 * 下载网络资源到本地文件夹
	 * 
	 * @param resourceURLStr
	 *            网络资源地址
	 * @param file
	 *            本地文件夹
	 */
	public static void downloadNetworkResource(String resourceURLStr, File file) {

		try {

			// 网络统一资源定位符
			URL resourceURL = new URL(resourceURLStr);
			// 获取HTTP连接
			HttpURLConnection httpURLConnection = (HttpURLConnection) resourceURL
					.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("192.168.70.124", 808)));
			// 连接
			httpURLConnection.connect();

			// 下载的文件路径
			File downloadFile = new File(file.getPath() + resourceURL.getFile());
			// 父级文件夹不存在,则创建对应文件夹
			if (!downloadFile.getParentFile().exists()) {
				downloadFile.getParentFile().mkdirs();
			}
			// 创建对应文件
			downloadFile.createNewFile();

			// 获取网络资源的输入流
			BufferedInputStream bis = new BufferedInputStream(httpURLConnection.getInputStream());
			// 获取本地文件的输出流
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(downloadFile));

			// 缓冲区长度
			int len = 1024;
			// 缓冲的字节数组
			byte[] b = new byte[len];
			// 读取字节
			while ((len = bis.read(b)) != -1) {

				// 写入
				bos.write(b, 0, len);
			}

			// 清空
			bos.flush();
			// 关闭
			bis.close();
			// 关闭
			bos.close();
			// 关闭
			httpURLConnection.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}