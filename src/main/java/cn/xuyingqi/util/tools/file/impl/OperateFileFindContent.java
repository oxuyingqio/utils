package cn.xuyingqi.util.tools.file.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import cn.xuyingqi.util.tools.file.OperateFile;

/**
 * 查找内容是否在文件中存在,并标明位置
 * 
 * @author Administrator
 *
 */
public class OperateFileFindContent implements OperateFile {

	// 日志
	private Logger logger = Logger.getLogger(OperateFile.class);

	// 待查找的内容
	private String findContent = null;
	// 是否忽略大小写
	private boolean ignoreCase = true;

	/**
	 * 查找内容是否在文件中存在,并标明位置
	 * 
	 * @param findContent
	 *            待查找的内容
	 */
	public OperateFileFindContent(String findContent) {
		this.findContent = findContent;
	}

	/**
	 * 查找内容是否在文件中存在,并标明位置
	 * 
	 * @param findContent
	 *            待查找的内容
	 * @param ignoreCase
	 *            是否忽略大小写
	 */
	public OperateFileFindContent(String findContent, boolean ignoreCase) {
		this.findContent = findContent;
		this.ignoreCase = ignoreCase;
	}

	@Override
	public void operateFile(File file) {
		// 文件不为空,且存在
		if (file != null && file.exists()) {
			try {
				// 缓冲读取流
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				// 本行内容
				String lineContent = null;
				// 标记行数
				int line = 0;
				while ((lineContent = br.readLine()) != null) {
					// 行数增加
					line++;
					// 获取查找内容是否在文件中存在
					int index = -1;
					// 是否忽略大小写
					if (ignoreCase) {
						index = lineContent.toLowerCase().indexOf(findContent.toLowerCase());
					} else {
						index = lineContent.indexOf(findContent);
					}
					// 存在,输出位置
					if (index != -1) {
						logger.debug(file.getPath() + " (" + line + ":" + index + ")");
					}
				}
				// 关闭
				br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
