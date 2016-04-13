package cn.xuyingqi.util.tools.operatefile.impl;

import java.io.File;

import cn.xuyingqi.util.tools.operatefile.OperateFile;

/**
 * 删除文件
 * 
 * @author Administrator
 *
 */
public class OperateFileDelete implements OperateFile {

	@Override
	public void operateFile(File file) {
		// 文件不为空,且存在
		if (file != null && file.exists()) {
			file.delete();
		}
	}
}
