package cn.xuyingqi.util.tools.jar;

import java.net.URL;

public class JarFile {

	public JarFile(String filePath) {
		URL url = JarFile.class.getResource(filePath);
		System.out.println(url);
	}

	public static void main(String[] args) {
		new JarFile("/public/demo.jsp");
	}
}
