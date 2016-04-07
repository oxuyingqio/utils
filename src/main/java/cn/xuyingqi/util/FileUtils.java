package cn.xuyingqi.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.List;

/**
 * 文件工具类
 * 
 * @author XuYQ
 *
 */
public class FileUtils {

	/**
	 * 对文件列表进行排序,先文件,后文件夹
	 * 
	 * @param files
	 *            待排序的文件数组
	 */
	public static List<File> sortFile(File[] resources) {
		// 文件列表
		List<File> files = ListFactory.newInstance();
		// 文件夹列表
		List<File> folders = ListFactory.newInstance();
		// 返回列表
		List<File> result = ListFactory.newInstance();

		// 循环
		for (int i = 0, length = resources.length; i < length; i++) {
			File file = resources[i];

			if (file.isFile()) {
				files.add(file);
			} else {
				folders.add(file);
			}
		}

		result.addAll(files);
		result.addAll(folders);
		return result;
	}

	/**
	 * 将文件source复制到target (FileChannel复制)
	 * 
	 * @param source
	 *            待复制文件
	 * @param target
	 *            复制的位置
	 */
	public static void copyFileInChannel(File source, File target) {
		// 输入流
		FileInputStream fis = null;
		// 输出流
		FileOutputStream fos = null;
		// 输入
		FileChannel fci = null;
		// 输出
		FileChannel fco = null;

		try {
			fis = new FileInputStream(source);
			fos = new FileOutputStream(target);
			fci = fis.getChannel();
			fco = fos.getChannel();
			fci.transferTo(0, fci.size(), fco);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				fci.close();
				fos.close();
				fco.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
