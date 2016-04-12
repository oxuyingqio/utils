package cn.xuyingqi.util;

import java.text.DecimalFormat;

import org.apache.log4j.Logger;
import org.junit.Test;

public class JUnitTest {

	private Logger logger = Logger.getLogger(JUnitTest.class);

	@Test
	public void test() {
		logger.debug(ByteUtils.convertSpecifiedLocation2Int(new int[] { 0, 2, 3, 31 }));

		DecimalFormat df = new DecimalFormat("######0.00000000000000000");
		System.out.println(df.format(Math.pow(1.1, 365)));
		System.out.println(df.format(Math.pow(0.9, 365)));
	}
}
