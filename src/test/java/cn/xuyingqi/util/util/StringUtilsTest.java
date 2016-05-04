package cn.xuyingqi.util.util;

import org.apache.commons.lang3.text.WordUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

public class StringUtilsTest {

	private Logger logger = Logger.getLogger(StringUtilsTest.class);

	@Test
	public void test() {
		this.logger.debug(WordUtils.capitalize("1adfsdf123"));
	}
}
