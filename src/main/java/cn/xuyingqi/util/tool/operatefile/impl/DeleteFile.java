package cn.xuyingqi.util.tool.operatefile.impl;

import java.io.File;

import cn.xuyingqi.util.tool.operatefile.OperateFile;

/**
 * 删除文件
 * 
 * @author Administrator
 *
 */
public class DeleteFile implements OperateFile {

	@Override
	public void operateFile(File file) {
		// 文件不为空,且存在
		if (file != null && file.exists()) {
			file.delete();
		}
	}
}
