package cn.xuyingqi.utils;

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
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import cn.xuyingqi.utils.exception.HttpException;

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
	private static PoolingHttpClientConnectionManager phccm;

	/**
	 * 私有构造方法
	 */
	private HttpClientUtils() {

	}

	/**
	 * 参数转换
	 * 
	 * @param params
	 * @return
	 */
	private static final List<NameValuePair> param2NVP(Map<String, Object> params) {

		// 转换参数
		List<NameValuePair> nvps = ListFactory.newInstance();

		// 遍历参数
		for (Map.Entry<String, Object> param : params.entrySet()) {

			nvps.add(new BasicNameValuePair(param.getKey(), String.valueOf(param.getValue())));
		}

		return nvps;
	}

	/**
	 * 初始化
	 */
	private synchronized static final void init() {

		// 判断HttpClient连接池是否为空
		if (phccm == null) {

			// 实例化HttpClient连接池
			phccm = new PoolingHttpClientConnectionManager();
			// 设置连接池最大连接数
			phccm.setMaxTotal(50);
			// 设置每路由最大连接数.默认值是2
			phccm.setDefaultMaxPerRoute(5);
		}
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
		return HttpClients.custom().setConnectionManager(phccm).build();
	}

	/**
	 * 获取Http请求处理结果
	 * 
	 * @param request
	 * @param charset
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	private static final String getResult(HttpRequestBase request, String charset)
			throws ClientProtocolException, IOException {

		// 获取HttpClient
		CloseableHttpClient httpClient = getHttpClient();

		// 获取响应结果
		CloseableHttpResponse response = httpClient.execute(request);
		// 判断响应结果
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK
				|| response.getStatusLine().getStatusCode() == HttpStatus.SC_CREATED
				|| response.getStatusLine().getStatusCode() == HttpStatus.SC_ACCEPTED
				|| response.getStatusLine().getStatusCode() == HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION
				|| response.getStatusLine().getStatusCode() == HttpStatus.SC_NO_CONTENT
				|| response.getStatusLine().getStatusCode() == HttpStatus.SC_RESET_CONTENT
				|| response.getStatusLine().getStatusCode() == HttpStatus.SC_PARTIAL_CONTENT
				|| response.getStatusLine().getStatusCode() == HttpStatus.SC_MULTI_STATUS) {

			// 获取响应数据
			HttpEntity entity = response.getEntity();
			// 判断响应数据是否为空
			if (entity == null) {

				// 关闭响应结果
				response.close();

				// 返回
				return "";
			} else {

				// 获取响应结果
				String result = EntityUtils.toString(entity, charset);
				// 关闭输入流
				response.getEntity().getContent().close();
				// 关闭响应结果
				response.close();

				// 返回
				return result;
			}
		} else {

			// 实例化响应结果
			String result = "";

			// 获取响应数据
			HttpEntity entity = response.getEntity();
			// 判断响应数据是否为空
			if (entity != null) {

				// 记录响应结果
				result = EntityUtils.toString(entity, charset);
				// 关闭输入流
				response.getEntity().getContent().close();
			}

			// 关闭响应结果
			response.close();

			// 抛出错误异常
			throw new HttpException(response.getStatusLine().getStatusCode(),
					response.getStatusLine().getReasonPhrase(), result);
		}
	}

	/**
	 * ==========================================================================================
	 */

	/**
	 * HttpGet请求
	 * 
	 * @param url 地址
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
	 * @param url    地址
	 * @param params 参数
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
	 * @param url     地址
	 * @param headers 头
	 * @param params  参数
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static final String httpGetRequest(String url, Map<String, Object> headers, Map<String, Object> params)
			throws URISyntaxException, ClientProtocolException, IOException {

		return httpGetRequest(url, headers, null, params);
	}

	/**
	 * HttpGet请求
	 * 
	 * @param url     地址
	 * @param headers 头
	 * @param timeout 超时时间(秒)
	 * @param params  参数
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static final String httpGetRequest(String url, Map<String, Object> headers, int timeout,
			Map<String, Object> params) throws URISyntaxException, ClientProtocolException, IOException {

		return httpGetRequest(url, headers,
				RequestConfig.custom().setConnectTimeout(timeout * 1000).setConnectionRequestTimeout(timeout * 1000)
						.setSocketTimeout(timeout * 1000).setRedirectsEnabled(true).build(),
				params);
	}

	/**
	 * HttpGet请求
	 * 
	 * @param url       地址
	 * @param headers   头
	 * @param proxyIp   代理地址
	 * @param proxyPort 代理端口
	 * @param params    参数
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static final String httpGetRequest(String url, Map<String, Object> headers, String proxyIp, int proxyPort,
			Map<String, Object> params) throws URISyntaxException, ClientProtocolException, IOException {

		return httpGetRequest(url, headers, RequestConfig.custom().setProxy(new HttpHost(proxyIp, proxyPort)).build(),
				params);
	}

	/**
	 * HttpGet请求
	 * 
	 * @param url           地址
	 * @param headers       头
	 * @param requestConfig 请求配置
	 * @param params        参数
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static final String httpGetRequest(String url, Map<String, Object> headers, RequestConfig requestConfig,
			Map<String, Object> params) throws URISyntaxException, ClientProtocolException, IOException {

		// 设置地址,参数
		URIBuilder urib = new URIBuilder();
		urib.setPath(url);
		urib.setParameters(param2NVP(params));

		// 实例化HttpGet请求
		HttpGet httpGet = new HttpGet(urib.build());

		// 遍历添加头元素
		for (Map.Entry<String, Object> param : headers.entrySet()) {

			httpGet.addHeader(param.getKey(), String.valueOf(param.getValue()));
		}

		// 设置请求配置
		if (requestConfig != null) {

			httpGet.setConfig(requestConfig);
		}

		// 获取结果
		return getResult(httpGet, CHARSET);
	}

	/**
	 * =============================================================================================
	 */

	/**
	 * HttpPost请求
	 * 
	 * @param url 地址
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
	 * @param url    地址
	 * @param params 参数
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
	 * @param url     地址
	 * @param params  参数
	 * @param charset 编码集
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
	 * @param url     地址
	 * @param headers 头
	 * @param params  参数
	 * @param charset 编码集
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static final String httpPostRequest(String url, Map<String, Object> headers, Map<String, Object> params,
			String charset) throws ClientProtocolException, IOException {

		return httpPostRequest(url, headers, null, params, charset);
	}

	/**
	 * HttpPost请求
	 * 
	 * @param url     地址
	 * @param headers 头
	 * @param timeout 超时时间(秒)
	 * @param params  参数
	 * @param charset 编码集
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static final String httpPostRequest(String url, Map<String, Object> headers, int timeout,
			Map<String, Object> params, String charset) throws ClientProtocolException, IOException {

		return httpPostRequest(url, headers,
				RequestConfig.custom().setConnectTimeout(timeout * 1000).setConnectionRequestTimeout(timeout * 1000)
						.setSocketTimeout(timeout * 1000).setRedirectsEnabled(true).build(),
				params, charset);
	}

	/**
	 * HttpPost请求
	 * 
	 * @param url           地址
	 * @param headers       头
	 * @param requestConfig 请求配置
	 * @param params        参数
	 * @param charset       编码集
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static final String httpPostRequest(String url, Map<String, Object> headers, RequestConfig requestConfig,
			Map<String, Object> params, String charset) throws ClientProtocolException, IOException {

		// 实例化HttpPost请求
		HttpPost httpPost = new HttpPost(url);

		// 遍历添加头元素
		for (Map.Entry<String, Object> param : headers.entrySet()) {

			httpPost.addHeader(param.getKey(), String.valueOf(param.getValue()));
		}

		// 设置请求配置
		if (requestConfig != null) {

			httpPost.setConfig(requestConfig);
		}

		// 设置请求参数,及编码格式
		httpPost.setEntity(new UrlEncodedFormEntity(param2NVP(params), charset));

		// 获取结果
		return getResult(httpPost, charset);
	}

	/**
	 * -------------------------------------------------------------------------------------
	 */

	/**
	 * HttpPost请求
	 * 
	 * @param url  地址
	 * @param body 请求体
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static final String httpPostRequest(String url, String body) throws ClientProtocolException, IOException {

		return httpPostRequest(url, body, CHARSET);
	}

	/**
	 * HttpPost请求
	 * 
	 * @param url     地址
	 * @param body    请求体
	 * @param charset 编码集
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static final String httpPostRequest(String url, String body, String charset)
			throws ClientProtocolException, IOException {

		return httpPostRequest(url, new HashMap<String, Object>(), body, charset);
	}

	/**
	 * HttpPost请求
	 * 
	 * @param url     地址
	 * @param headers 头
	 * @param body    请求体
	 * @param charset 编码集
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static final String httpPostRequest(String url, Map<String, Object> headers, String body, String charset)
			throws ClientProtocolException, IOException {

		return httpPostRequest(url, headers, null, body, charset);
	}

	/**
	 * HttpPost请求
	 * 
	 * @param url           地址
	 * @param headers       头
	 * @param requestConfig 请求配置
	 * @param body          请求体
	 * @param charset       编码集
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static final String httpPostRequest(String url, Map<String, Object> headers, RequestConfig requestConfig,
			String body, String charset) throws ClientProtocolException, IOException {

		// 实例化HttpPost请求
		HttpPost httpPost = new HttpPost(url);

		// 遍历添加头元素
		for (Map.Entry<String, Object> param : headers.entrySet()) {

			httpPost.addHeader(param.getKey(), String.valueOf(param.getValue()));
		}

		// 设置请求配置
		if (requestConfig != null) {

			httpPost.setConfig(requestConfig);
		}

		// 设置请求参数,及编码格式
		httpPost.setEntity(new StringEntity(body, charset));

		// 获取结果
		return getResult(httpPost, charset);
	}

	/**
	 * Main函数测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String url = "http://180.101.147.89:8743/iocm/app/sec/v1.1.0/login";
		Map<String, Object> params = MapFactory.newInstance();
		params.put("appId", "rzcoF0rr9cNqpIjEGzVZZ1wfl44a");
		params.put("secret", "456");

		try {

			String rtn = HttpClientUtils.httpPostRequest(url, params);
			System.out.println(rtn);
		} catch (ClientProtocolException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}