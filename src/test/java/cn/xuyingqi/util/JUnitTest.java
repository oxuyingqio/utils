package cn.xuyingqi.util;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import cn.xuyingqi.util.util.ListFactory;

public class JUnitTest {

	@Test
	public void test() throws UnsupportedEncodingException {

//		byte[] demo = new byte[] { -46, -75, -50, -15, -49, -75, -51, -77, -78, -69, -76, -26, -44, -38, -74, -44, -45,
//				-90, -75, -60, -65, -88, -70, -59, -93, -95, 0, 0, 0, 0, 0, 0 };
//		
//		
//		System.out.println(new String(demo, "GBK"));
		
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
		
		
//		String s = "10";
//		System.out.println(Integer.parseInt(s, 16));
		
		
		List<Integer> list = ListFactory.newInstance();
		for (int i = 0; i < 20; i++) {
			list.add(i);
		}
		
		List<Integer> test = ListFactory.newInstance();

		int i = 0;
		while (list.size() > 0) {

			if (list.size() > 4) {
				test = list.subList(4 * i, (4 * i) + 4);
			} else {
				test = list.subList(4 * i, (4 * i) + list.size());
			}

			System.out.println(i + "==当前list长度：" + list.size());
			System.out.println(i + "==当前list内容：" + Arrays.toString(list.toArray()));
			System.out.println(i + "==当前test长度：" + test.size());
			System.out.println(i + "==当前test内容：" + Arrays.toString(test.toArray()));

			i++;
			if (i >= 5) {
				break;
			}
		}
	}
}
