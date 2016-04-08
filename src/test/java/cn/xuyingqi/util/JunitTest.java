package cn.xuyingqi.util;

public class JunitTest {

	@org.junit.Test
	public void test() {
		int a = 1231241111;
		System.out.println(ByteUtils.byteArray2Int(ByteUtils.int2ByteArray(a)));
	}
}
