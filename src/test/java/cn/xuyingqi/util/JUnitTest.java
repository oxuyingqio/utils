package cn.xuyingqi.util;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class JUnitTest {

	@Test
	public void test() throws UnsupportedEncodingException {

		byte[] demo = new byte[] { -46, -75, -50, -15, -49, -75, -51, -77, -78, -69, -76, -26, -44, -38, -74, -44, -45,
				-90, -75, -60, -65, -88, -70, -59, -93, -95, 0, 0, 0, 0, 0, 0 };
		
		
		System.out.println(new String(demo, "GBK"));
		
//		StringBuffer sb = new StringBuffer();
//		for (int i = 0; i < demo.length; i++) {
//
//			String s = Integer.toHexString(demo[i] & 0xff);
//			if (s.length() == 1) {
//				sb.append(0);
//			}
//
//			sb.append(s);
//		}
//
//		System.out.println(sb.toString().toUpperCase());
	}
}
