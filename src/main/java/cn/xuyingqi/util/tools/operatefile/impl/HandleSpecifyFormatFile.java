package cn.xuyingqi.util.tools.operatefile.impl;

import java.io.File;

import cn.xuyingqi.util.tools.operatefile.OperateFile;

/**
 * 操作指定格式的文件
 * 
 * @author Administrator
 *
 */
public class HandleSpecifyFormatFile implements OperateFile {

	// 文件类型
	private String fileType;
	// 操作文件
	private OperateFile operateFile;

	/**
	 * 操作指定格式的文件
	 * 
	 * @param fileType
	 *            文件类型,*则处理所有格式
	 * @param operateFile
	 *            操作文件
	 */
	public HandleSpecifyFormatFile(String fileType, OperateFile operateFile) {
		this.fileType = fileType;
		this.operateFile = operateFile;
	}

	@Override
	public void operateFile(File file) {
		// 文件不为空,存在
		if (file != null && file.exists()) {
			// 指定文件类型为*,或者文件的类型匹配指定文件类型
			if ("*".equals(fileType) || file.getName().toLowerCase().endsWith(fileType.toLowerCase())) {
				operateFile.operateFile(file);
			}
		}
	}
}
