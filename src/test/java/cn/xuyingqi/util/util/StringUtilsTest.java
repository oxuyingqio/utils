package cn.xuyingqi.util.util;

import org.apache.log4j.Logger;
import org.junit.Test;

import cn.xuyingqi.util.util.StringUtils;

public class StringUtilsTest {

	private Logger logger = Logger.getLogger(StringUtilsTest.class);

	@Test
	public void test() {
		this.logger.debug(StringUtils.capitalize("a123"));
	}
}
