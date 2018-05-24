package cn.xuyingqi.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import cn.xuyingqi.util.exception.HttpException;
import cn.xuyingqi.util.util.ListFactory;

/**
 * HttpClient工具类
 * 
 * @author XuYQ
 *
 */
public final class HttpClientUtils {

	/**
	 * 默认编码集
	 */
	private static final String CHARSET = "UTF-8";

	/**
	 * HttpClient连接池
	 */
	private static PoolingHttpClientConnectionManager PHCCM;

	/**
	 * 私有构造方法
	 */
	private HttpClientUtils() {

	}

	/**
	 * 初始化
	 */
	private synchronized static final void init() {

		// 判断HttpClient连接池是否为空
		if (PHCCM == null) {

			// 实例化HttpClient连接池
			PHCCM = new PoolingHttpClientConnectionManager();
			// 设置连接池最大连接数
			PHCCM.setMaxTotal(50);
			// 设置每路由最大连接数.默认值是2
			PHCCM.setDefaultMaxPerRoute(5);
		}
	}

	/**
	 * HttpGet请求
	 * 
	 * @param url
	 *            地址
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static final String httpGetRequest(String url)
			throws URISyntaxException, ClientProtocolException, IOException {

		return httpGetRequest(url, new HashMap<String, Object>());
	}

	/**
	 * HttpGet请求
	 * 
	 * @param url
	 *            地址
	 * @param params
	 *            参数
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static final String httpGetRequest(String url, Map<String, Object> params)
			throws URISyntaxException, ClientProtocolException, IOException {

		return httpGetRequest(url, new HashMap<String, Object>(), params);
	}

	/**
	 * HttpGet请求
	 * 
	 * @param url
	 *            地址
	 * @param headers
	 *            头
	 * @param params
	 *            参数
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static final String httpGetRequest(String url, Map<String, Object> headers, Map<String, Object> params)
			throws URISyntaxException, ClientProtocolException, IOException {

		// 设置地址,参数
		URIBuilder urib = new URIBuilder();
		urib.setPath(url);
		urib.setParameters(covertParams2NVPS(params));

		// 实例化HttpGet请求
		HttpGet httpGet = new HttpGet(urib.build());

		// 实例化代理
		HttpHost proxy = new HttpHost("192.168.70.124", 808);
		// 设置代理
		httpGet.setConfig(RequestConfig.custom().setProxy(proxy).build());

		// 遍历添加头元素
		for (Map.Entry<String, Object> param : headers.entrySet()) {

			httpGet.addHeader(param.getKey(), String.valueOf(param.getValue()));
		}

		// 获取结果
		return getResult(httpGet);
	}

	/**
	 * HttpPost请求
	 * 
	 * @param url
	 *            地址
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static final String httpPostRequest(String url) throws ClientProtocolException, IOException {

		return httpPostRequest(url, new HashMap<String, Object>());
	}

	/**
	 * HttpPost请求
	 * 
	 * @param url
	 *            地址
	 * @param params
	 *            参数
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static final String httpPostRequest(String url, Map<String, Object> params)
			throws ClientProtocolException, IOException {

		return httpPostRequest(url, params, CHARSET);
	}

	/**
	 * HttpPost请求
	 * 
	 * @param url
	 *            地址
	 * @param params
	 *            参数
	 * @param charset
	 *            编码集
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static final String httpPostRequest(String url, Map<String, Object> params, String charset)
			throws ClientProtocolException, IOException {

		return httpPostRequest(url, new HashMap<String, Object>(), params, charset);
	}

	/**
	 * HttpPost请求
	 * 
	 * @param url
	 *            地址
	 * @param headers
	 *            头
	 * @param params
	 *            参数
	 * @param charset
	 *            编码集
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static final String httpPostRequest(String url, Map<String, Object> headers, Map<String, Object> params,
			String charset) throws ClientProtocolException, IOException {

		// 实例化HttpPost请求
		HttpPost httpPost = new HttpPost(url);

		// 实例化代理
		HttpHost proxy = new HttpHost("192.168.70.124", 808);
		// 设置代理
		httpPost.setConfig(RequestConfig.custom().setProxy(proxy).build());

		// 遍历添加头元素
		for (Map.Entry<String, Object> param : headers.entrySet()) {

			httpPost.addHeader(param.getKey(), String.valueOf(param.getValue()));
		}

		// 设置请求参数,及编码格式
		httpPost.setEntity(new UrlEncodedFormEntity(covertParams2NVPS(params), charset));

		// 获取结果
		return getResult(httpPost);
	}

	/**
	 * 参数转换
	 * 
	 * @param params
	 * @return
	 */
	private static final List<NameValuePair> covertParams2NVPS(Map<String, Object> params) {

		// 转换参数
		List<NameValuePair> nvps = ListFactory.newInstance();

		// 遍历参数
		for (Map.Entry<String, Object> param : params.entrySet()) {

			nvps.add(new BasicNameValuePair(param.getKey(), String.valueOf(param.getValue())));
		}

		return nvps;
	}

	/**
	 * 获取Http请求处理结果
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	private static final String getResult(HttpRequestBase request) throws ClientProtocolException, IOException {

		// 获取HttpClient
		CloseableHttpClient httpClient = getHttpClient();

		// 获取响应结果
		CloseableHttpResponse response = httpClient.execute(request);
		// 判断响应结果
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

			// 获取响应数据
			HttpEntity entity = response.getEntity();
			if (entity != null) {

				String result = EntityUtils.toString(entity);
				response.close();

				return result;
			}
		} else {

			// 抛出错误异常
			throw new HttpException(response.getStatusLine().toString());
		}

		return "";
	}

	/**
	 * 通过连接池获取HttpClient
	 * 
	 * @return
	 */
	private static final CloseableHttpClient getHttpClient() {

		// 初始化
		init();

		// 返回HttpClient
		return HttpClients.custom().setConnectionManager(PHCCM).build();
	}

	/**
	 * Main函数测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

	}
}