package cn.xuyingqi.util;

import org.apache.log4j.Logger;

public class JunitTest {
	
	private Logger logger = Logger.getLogger(JunitTest.class);

	@org.junit.Test
	public void test() {
		logger.debug("1232313123");
	}
}
