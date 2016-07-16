package cn.xuyingqi.util.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.List;

import cn.xuyingqi.util.tool.operatefile.OperateFile;

/**
 * 文件工具类
 * 
 * @author XuYQ
 *
 */
public class FileUtils {

	/**
	 * 将文件source复制到target (FileChannel复制)
	 * 
	 * @param source
	 *            待复制文件
	 * @param target
	 *            复制的位置
	 * @throws IOException
	 */
	public static void copyFileInChannel(File source, File target) throws IOException {

		// 输入流
		FileInputStream fis = null;
		// 输出流
		FileOutputStream fos = null;
		// 输入
		FileChannel fci = null;
		// 输出
		FileChannel fco = null;

		fis = new FileInputStream(source);
		fos = new FileOutputStream(target);

		fci = fis.getChannel();
		fco = fos.getChannel();
		fci.transferTo(0, fci.size(), fco);

		fis.close();
		fci.close();
		fos.close();
		fco.close();
	}

	/**
	 * 递归文件目录,并操作文件
	 * 
	 * @param path
	 * @param operateFile
	 */
	public static void recursionFile(File file, OperateFile operateFile) {

		// 判断文件是否为空,且存在
		if (file != null && file.exists()) {
			// 操作文件
			operateFile.operateFile(file);

			// 文件是否为目录
			if (file.isDirectory()) {
				// 获取子文件,并排序
				List<File> files = FileUtils.sortFileArray(file.listFiles());
				// 遍历子文件,并操作子文件
				for (int i = 0, length = files.size(); i < length; i++) {
					recursionFile(files.get(i), operateFile);
				}
			}
		}
	}

	/**
	 * 对文件列表进行排序,先文件,后文件夹
	 * 
	 * @param files
	 *            待排序的文件数组
	 */
	public static List<File> sortFileArray(File[] sources) {

		// 文件列表
		List<File> files = ListFactory.newInstance(ListFactory.ListType.linkedList);
		// 文件夹列表
		List<File> folders = ListFactory.newInstance(ListFactory.ListType.linkedList);
		// 返回列表
		List<File> target = ListFactory.newInstance(ListFactory.ListType.linkedList);

		// 循环
		for (int i = 0, length = sources.length; i < length; i++) {
			File file = sources[i];

			if (file.isFile()) {
				files.add(file);
			} else {
				folders.add(file);
			}
		}

		target.addAll(files);
		target.addAll(folders);
		return target;
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

		// 缓冲输入流
		BufferedInputStream bis = null;
		// 缓冲输出流
		BufferedOutputStream bos = null;

		try {

			// 网络统一资源定位符
			URL resourceURL = new URL(resourceURLStr);
			// 获取HTTP连接
			HttpURLConnection httpURLConnection = (HttpURLConnection) resourceURL.openConnection();
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
			bis = new BufferedInputStream(httpURLConnection.getInputStream());
			// 获取本地文件的输出流
			bos = new BufferedOutputStream(new FileOutputStream(downloadFile));

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
			httpURLConnection.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				bis.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
