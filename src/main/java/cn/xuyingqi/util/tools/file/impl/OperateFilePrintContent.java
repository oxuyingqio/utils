package cn.xuyingqi.util.tools.file.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;

import cn.xuyingqi.util.tools.file.OperateFile;

/**
 * 打印文件内容
 * 
 * @author Administrator
 *
 */
public class OperateFilePrintContent implements OperateFile {

	// 日志
	private Logger logger = Logger.getLogger(OperateFile.class);

	// 默认缓冲区大小
	private static final int DEFAULT_BUFFER_SIZE = 1024;
	// 默认读取文件的编码格式
	private static final String DEFAULT_CHARSET_NAME = "GBK";

	// 读取文件的编码格式
	private String charsetName = DEFAULT_CHARSET_NAME;

	/**
	 * 打印文件内容
	 */
	public OperateFilePrintContent() {
	}

	/**
	 * 打印文件内容
	 * 
	 * @param charsetName
	 *            读取文件的编码格式
	 */
	public OperateFilePrintContent(String charsetName) {
		this.charsetName = charsetName;
	}

	@Override
	public void operateFile(File file) {
		// 文件不为空,存在,且是一个文件
		if (file != null && file.exists() && file.isFile()) {
			try {
				// 文件输入流
				FileInputStream fis = new FileInputStream(file);
				// 输出文件内容
				byte[] temp = new byte[DEFAULT_BUFFER_SIZE];
				while (fis.read(temp) != -1) {
					logger.debug("\n" + new String(temp, charsetName));
				}
				// 关闭
				fis.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
