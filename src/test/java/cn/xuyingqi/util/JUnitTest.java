package cn.xuyingqi.util;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import cn.xuyingqi.util.util.ListFactory;

public class JUnitTest {

	@Test
	public void test() throws UnsupportedEncodingException {

		// byte[] demo = new byte[] { -46, -75, -50, -15, -49, -75, -51, -77,
		// -78, -69, -76, -26, -44, -38, -74, -44, -45,
		// -90, -75, -60, -65, -88, -70, -59, -93, -95, 0, 0, 0, 0, 0, 0 };
		//
		// System.out.println(new String(demo, "GBK"));

		// StringBuffer sb = new StringBuffer();
		// for (int i = 0; i < demo.length; i++) {
		//
		// String s = Integer.toHexString(demo[i] & 0xff);
		// if (s.length() == 1) {
		// sb.append(0);
		// }
		//
		// sb.append(s);
		// }
		//
		// System.out.println(sb.toString().toUpperCase());

		// String s = "10";
		// System.out.println(Integer.parseInt(s, 16));

		int count = 4;

		List<Integer> list = ListFactory.newInstance();
		for (int i = 0; i < 18; i++) {
			list.add(i);
		}

		double maxTime = Math.ceil((double) list.size() / count);

		int time = 0;
		while (time < maxTime) {

			List<Integer> temp = list.subList(count * time,
					count * (time + 1) > list.size() ? list.size() : count * (time + 1));
			System.out.println("temp内容：" + Arrays.toString(temp.toArray()));

			time++;
		}
	}
}
