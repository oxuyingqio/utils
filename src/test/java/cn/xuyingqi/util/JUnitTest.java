package cn.xuyingqi.util;

import org.apache.log4j.Logger;

public class JUnitTest {

	private Logger logger = Logger.getLogger(JUnitTest.class);

	@org.junit.Test
	public void test() {
		logger.debug(Math.pow(2, 0));
	}
}
