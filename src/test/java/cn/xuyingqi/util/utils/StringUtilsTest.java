package cn.xuyingqi.util.utils;

import org.apache.log4j.Logger;
import org.junit.Test;

public class StringUtilsTest {

	private Logger logger = Logger.getLogger(StringUtilsTest.class);

	@Test
	public void test() {
		this.logger.debug(StringUtils.capitalize("a123"));
	}
}
