package cn.xuyingqi.util;

import org.apache.log4j.Logger;

public class JUnitTest {

	private Logger logger = Logger.getLogger(JUnitTest.class);

	@org.junit.Test
	public void test() {
		logger.debug(ByteUtils.convertSpecifiedLocation2Int(new int[] { 0, 2, 3, 31 }));
	}
}
