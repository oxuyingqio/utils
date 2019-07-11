package cn.xuyingqi.utils;

import java.io.FileInputStream;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

/**
 * SSL上下文工厂
 * 
 * @author XuYQ
 *
 */
public final class SSLContextFactory {

	/**
	 * 私有构造方法
	 */
	private SSLContextFactory() {

	}

	/**
	 * 获取SSL上下文
	 * 
	 * @param sslConfig SSL配置
	 * @return
	 */
	public static final SSLContext getInstance(SSLConfig config) {

		try {

			// 密钥库
			KeyStore ks = KeyStore.getInstance(config.getPrivateKey().getType());
			// 设置文件路径,及密码
			ks.load(new FileInputStream(config.getPrivateKey().getPath()),
					config.getPrivateKey().getPassword().toCharArray());

			// 密钥管理工厂
			KeyManagerFactory kmf = KeyManagerFactory.getInstance(config.getPrivateKey().getAlgorithm());
			// 初始化密钥管理工厂
			kmf.init(ks, config.getPrivateKey().getPassword().toCharArray());

			// 密钥库
			KeyStore tks = KeyStore.getInstance(config.getTrustCertificate().getType());
			// 设置文件路径,及密码
			tks.load(new FileInputStream(config.getTrustCertificate().getPath()),
					config.getTrustCertificate().getPassword().toCharArray());

			// 受信证书管理工厂
			TrustManagerFactory tmf = TrustManagerFactory.getInstance(config.getTrustCertificate().getAlgorithm());
			// 初始化受信证书管理工厂
			tmf.init(tks);

			// 获取SSL上下文
			SSLContext sslContext = SSLContext.getInstance(config.getProtocol());
			// 初始化SSL上下文
			sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

			// 返回SSL上下文
			return sslContext;
		} catch (Exception e) {

			// 抛异常
			throw new RuntimeException("初始化SSL上下文失败", e);
		}
	}

	/**
	 * SSL配置
	 * 
	 * @author XuYQ
	 *
	 */
	public static final class SSLConfig {

		/**
		 * 协议
		 */
		private String protocol;
		/**
		 * 私钥
		 */
		private KeyConfig privateKey;
		/**
		 * 信任证书
		 */
		private KeyConfig trustCertificate;

		/**
		 * SSL配置
		 * 
		 * @param protocol         协议
		 * @param privateKey       私钥
		 * @param trustCertificate 信任证书
		 */
		public SSLConfig(String protocol, KeyConfig privateKey, KeyConfig trustCertificate) {

			this.protocol = protocol;
			this.privateKey = privateKey;
			this.trustCertificate = trustCertificate;
		}

		/**
		 * 获取协议
		 * 
		 * @return
		 */
		public String getProtocol() {

			return this.protocol;
		}

		/**
		 * 获取私钥
		 * 
		 * @return
		 */
		public KeyConfig getPrivateKey() {

			return this.privateKey;
		}

		/**
		 * 获取信任证书
		 * 
		 * @return
		 */
		public KeyConfig getTrustCertificate() {

			return this.trustCertificate;
		}

		/**
		 * 密钥配置
		 * 
		 * @author XuYQ
		 *
		 */
		public static final class KeyConfig {

			/**
			 * 路径
			 */
			private String path;
			/**
			 * 密码
			 */
			private String password;
			/**
			 * 类型
			 */
			private String type;
			/**
			 * 算法
			 */
			private String algorithm;

			/**
			 * 密钥配置
			 * 
			 * @param path      路径
			 * @param password  密码
			 * @param type      类型
			 * @param algorithm 算法
			 */
			public KeyConfig(String path, String password, String type, String algorithm) {

				this.path = path;
				this.password = password;
				this.type = type;
				this.algorithm = algorithm;
			}

			/**
			 * 获取路径
			 * 
			 * @return
			 */
			public String getPath() {

				return this.path;
			}

			/**
			 * 获取密码
			 * 
			 * @return
			 */
			public String getPassword() {

				return this.password;
			}

			/**
			 * 获取类型
			 * 
			 * @return
			 */
			public String getType() {

				return this.type;
			}

			/**
			 * 获取算法
			 */
			public String getAlgorithm() {

				return this.algorithm;
			}
		}
	}
}