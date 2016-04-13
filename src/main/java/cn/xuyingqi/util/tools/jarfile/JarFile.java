package cn.xuyingqi.util.tools.jarfile;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import cn.xuyingqi.util.utils.ResourceUtils;

/**
 * 
 * @author XuYQ
 *
 */
public class JarFile {

	private URL url;

	public JarFile(String filePath) throws MalformedURLException {
		url = JarFile.class.getResource(filePath);
		if (ResourceUtils.isJarURL(url)) {
			url = ResourceUtils.extractJarFileURL(url);
		}
	}

	public File getFile() throws URISyntaxException {
		return new File(new URI(url.toString()).getSchemeSpecificPart());
	}
}
