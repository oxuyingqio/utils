package cn.xuyingqi.util.tools.operatefile.impl;

import java.io.File;

import org.apache.log4j.Logger;

import cn.xuyingqi.util.tools.operatefile.OperateFile;

/**
 * 打印文件名称
 * 
 * @author Administrator
 *
 */
public class OperateFilePrintName implements OperateFile {

	// 日志
	private Logger logger = Logger.getLogger(OperateFile.class);

	@Override
	public void operateFile(File file) {
		// 文件不为空,且存在
		if (file != null && file.exists()) {
			logger.debug(file.getName());
		}
	}
}
