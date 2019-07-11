package cn.xuyingqi.utils.tool.operate.file.impl;

import java.io.File;

import cn.xuyingqi.utils.tool.operate.file.OperateFile;

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
