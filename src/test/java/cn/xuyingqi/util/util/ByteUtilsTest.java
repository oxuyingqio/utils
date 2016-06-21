package cn.xuyingqi.util.util;

import org.junit.Test;

public class ByteUtilsTest {

	@Test
	public void test() {
		byte b = (byte) 244;
		System.out.println(b);
		System.out.println(ByteUtils.byte2Int(b));

		short s = 244;
		byte[] ss = ByteUtils.short2ByteArray(s);
		for (int i = 0; i < ss.length; i++) {
			System.out.println(ss[i]);
		}

		byte[] bcd = { 32, 22, 6, 32, 23, 16, 16 };
		System.out.println(ByteUtils.bcd2String(bcd));
	}
}
