package cn.xuyingqi.util.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.List;

import cn.xuyingqi.util.tools.operatefile.OperateFile;

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
}
