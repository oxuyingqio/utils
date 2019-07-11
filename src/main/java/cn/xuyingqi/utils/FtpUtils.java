package cn.xuyingqi.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import cn.xuyingqi.utils.exception.FtpException;

/**
 * FTP工具类
 * 
 * @author XuYQ
 *
 */
public final class FtpUtils {

	/**
	 * 主机名
	 */
	private String host;
	/**
	 * 端口号
	 */
	private int port;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;

	/**
	 * FTP客户端
	 */
	private FTPClient ftpClient;

	/**
	 * FTP工具类
	 * 
	 * @param host
	 * @param port
	 * @param username
	 * @param password
	 */
	public FtpUtils(String host, int port, String username, String password) {

		this.host = host;
		this.port = port;
		this.username = username;
		this.password = password;

		this.ftpClient = new FTPClient();
	}

	/**
	 * 连接
	 */
	public final void connect() {

		try {

			// 连接FTP
			this.ftpClient.connect(this.host, this.port);
			// 登录FTP
			this.ftpClient.login(this.username, this.password);

			// 判断是否登录成功
			if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {

				// 关闭连接
				this.ftpClient.disconnect();

				// 抛异常
				throw new FtpException("未连接到服务器，用户名或密码错误！");
			}
		} catch (SocketException e) {

			e.printStackTrace();

			throw new FtpException("主机名异常！");
		} catch (IOException e) {

			e.printStackTrace();

			throw new FtpException("端口号异常！");
		}
	}

	/**
	 * 获取FTP文件流
	 * 
	 * @param fileName
	 *            文件名
	 * @return
	 */
	public final InputStream getFileInputStream(String fileName) {

		try {

			// 设置文件类型
			this.ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			this.ftpClient.enterLocalPassiveMode();

			// 返回文件流
			return this.ftpClient.retrieveFileStream(fileName);
		} catch (IOException e) {

			e.printStackTrace();

			throw new FtpException("文件读取异常！");
		}
	}

	/**
	 * 上传文件
	 * 
	 * @param ftpPath
	 *            文件路径
	 * @param fileName
	 *            文件名
	 * @param input
	 *            输入流
	 */
	public final void uploadFile(String ftpPath, String fileName, InputStream input) {

		try {

			this.ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			this.ftpClient.enterLocalPassiveMode();

			this.ftpClient.changeWorkingDirectory(ftpPath);
			this.ftpClient.storeFile(fileName, input);
		} catch (IOException e) {

			e.printStackTrace();

			throw new FtpException("文件上传异常！");
		}
	}

	/**
	 * 关闭连接
	 */
	public final void disconnect() {

		try {

			// 登出FTP
			this.ftpClient.logout();
			// 判断FTP是否连接
			if (this.ftpClient.isConnected()) {

				// 断开FTP连接
				this.ftpClient.disconnect();
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Main函数测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {

			// 实例化FTP工具类
			FtpUtils fu = new FtpUtils("192.168.70.124", 21, "daikou", "daikou123");

			// 获取当前毫秒值,当文件名处理
			String currentTimeMillis = System.currentTimeMillis() + "";

			System.out.println("====================上传====================");
			// 连接FTP
			fu.connect();
			// 获取字节数组输入流
			ByteArrayInputStream bais = new ByteArrayInputStream("我".getBytes("UTF-8"));
			// 上传文件,参数(FTP路径,FTP文件名,输入流)
			fu.uploadFile("", currentTimeMillis, bais);
			// 关闭字节数组输入流
			bais.close();
			// 断开FTP连接
			fu.disconnect();

			System.out.println("====================下载====================");
			// 连接FTP
			fu.connect();
			// 获取FTP文件输入流
			BufferedReader br = new BufferedReader(
					new InputStreamReader(fu.getFileInputStream(currentTimeMillis), "UTF-8"));
			String line = null;
			while ((line = br.readLine()) != null) {

				System.out.println(line);
			}
			// 断开FTP连接
			fu.disconnect();
		} catch (SocketException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}