package cn.xuyingqi.util.util;

import org.junit.Test;

public class ByteUtilsTest {

	@Test
	public void test() {

		// byte2Int
		// byte b = (byte) 244;
		// System.out.println(b);
		// System.out.println(ByteUtils.byte2Int(b));

		// short2ByteArray
		// short s = 244;
		// byte[] byteArray = ByteUtils.short2ByteArray(s);
		// for (int index = 0; index < byteArray.length; index++) {
		// System.out.println(byteArray[index]);
		// }

		// bcd2String
		// byte[] bcd = { 32, 22, 6, 32, 23, 16, 16 };
		// String bcdStr = ByteUtils.bcd2String(bcd);
		// System.out.println(bcdStr);
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		// try {
		// System.out.println(sdf.parse(bcdStr));
		// } catch (ParseException e) {
		// e.printStackTrace();
		// }

		// byte[] byteArray = { 0, 0 };
		// int i = ByteUtils.byteArray2Int(byteArray);
		// System.out.println(i == 0x0000);
		byte[] byteArray = { (byte) 255, (byte) 255 };
		int i = ByteUtils.byteArray2Int(byteArray);
		System.out.println(i);
		System.out.println(0xffff);
		System.out.println(i == 0xffff);
	}
}