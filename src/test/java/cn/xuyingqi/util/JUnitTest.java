package cn.xuyingqi.util;

import org.apache.log4j.Logger;
import org.junit.Test;

import cn.xuyingqi.util.util.ByteUtils;

public class JUnitTest {

	private Logger logger = Logger.getLogger(JUnitTest.class);

	@Test
	public void test() {
		this.logger.debug(ByteUtils.convertSpecifiedLocation2Int(new int[] { 0, 2, 3, 31 }));
	}
}
