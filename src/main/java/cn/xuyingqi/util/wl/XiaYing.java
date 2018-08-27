package cn.xuyingqi.util.wl;

import java.util.Arrays;

/**
 * 
 * @author XuYQ
 *
 */
public class XiaYing {

	/**
	 * ID
	 */
	private Integer id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 品质
	 */
	private Quality quality;
	/**
	 * 联系ID
	 */
	private Integer[] contactIdS = null;

	/**
	 * 
	 * @param id
	 */
	public XiaYing(Integer id) {

		// 佟湘玉 1 [4,16,3,5]
		// 祝无双 2 [16,18,4,6]
		// 郭芙蓉 3 [14,4,1,2]
		// 吕轻侯 4 [1,14,17,3]
		// 莫小贝 5 [2,12,1,24]
		// 燕小六 6 [2,11,21,8]
		// 南宫残花 7 [1,2,4,18]
		// 小米 8 [1,18,22,21]
		// 杨惠兰 9 [18,2,10,7]
		// 洪大师 10 [22,18,9,25]
		// 一二三 11 [6,25,3,21]
		// 岳松涛 12 [20,13,17,5]
		// 公孙乌龙 13 [12,15,4,17]
		// 郭巨侠 14 [15,3,4,19]
		// 白三娘 15 [19,16,13,14]
		// 白展堂 16 [15,17,1,14]
		// 姬无命 17 [13,16,20,4]
		// 李秀莲 18 [1,2,3,9]
		// 展红绫 19 [16,3,23,4]
		// 上官云顿 20 [12,13,17,18]
		// 邢玉森 21 [17,6,25,8]
		// 恭长老 22 [16,3,14,8]
		// 追风 23 [14,15,19,3]
		// 路一鸣 24 [5,1,12,23]
		// 娄知县 25 [21,6,18,11]

		// 平谷一点红 26 [14,16,4,27]
		// 展堂 27 [2,26,1,17]
		// 美丽 28 [29,3,19,25]
		// 打折 29 [28,2,7,8]

		// 凌腾云 30 [31,26,27,34]
		// 莫小宝 31 [30,27,38,36]
		// 断指轩辕 32 [33,18,13,35]
		// 佟伯达 33 [32,1,17,37]

		// 金长老 34 [36,30,26,38]
		// 姬无病 35 [37,17,16,32]
		// 银长老 36 [34,31,27,28]
		// 姬无力 37 [35,17,18,33]

		// 祝小云 38 [31,29,24,5]

		this.id = id;

		switch (this.id) {
		case 1:
			this.name = "佟湘玉";
			this.quality = Quality.PURPLE;
			this.contactIdS = new Integer[] { 4, 16, 3, 5 };
			break;
		case 2:
			this.name = "祝无双";
			this.quality = Quality.PURPLE;
			this.contactIdS = new Integer[] { 16, 18, 4, 6 };
			break;
		case 3:
			this.name = "郭芙蓉";
			this.quality = Quality.PURPLE;
			this.contactIdS = new Integer[] { 14, 4, 1, 2 };
			break;
		case 4:
			this.name = "吕轻侯";
			this.quality = Quality.PURPLE;
			this.contactIdS = new Integer[] { 1, 14, 17, 3 };
			break;
		case 5:
			this.name = "莫小贝";
			this.quality = Quality.BLUE;
			this.contactIdS = new Integer[] { 2, 12, 1, 24 };
			break;
		case 6:
			this.name = "燕小六";
			this.quality = Quality.BLUE;
			this.contactIdS = new Integer[] { 2, 11, 21, 8 };
			break;
		case 7:
			this.name = "南宫残花";
			this.quality = Quality.BLUE;
			this.contactIdS = new Integer[] { 1, 2, 4, 18 };
			break;
		case 8:
			this.name = "小米";
			this.quality = Quality.GREEN;
			this.contactIdS = new Integer[] { 1, 18, 22, 21 };
			break;
		case 9:
			this.name = "杨惠兰";
			this.quality = Quality.GREEN;
			this.contactIdS = new Integer[] { 18, 2, 10, 7 };
			break;
		case 10:
			this.name = "洪大师";
			this.quality = Quality.GREEN;
			this.contactIdS = new Integer[] { 22, 18, 9, 25 };
			break;
		case 11:
			this.name = "一二三";
			this.quality = Quality.GREEN;
			this.contactIdS = new Integer[] { 6, 25, 3, 21 };
			break;
		case 12:
			this.name = "岳松涛";
			this.quality = Quality.YELLOW;
			this.contactIdS = new Integer[] { 20, 13, 17, 5 };
			break;
		case 13:
			this.name = "公孙乌龙";
			this.quality = Quality.YELLOW;
			this.contactIdS = new Integer[] { 12, 15, 4, 17 };
			break;
		case 14:
			this.name = "郭巨侠";
			this.quality = Quality.YELLOW;
			this.contactIdS = new Integer[] { 15, 3, 4, 19 };
			break;
		case 15:
			this.name = "白三娘";
			this.quality = Quality.YELLOW;
			this.contactIdS = new Integer[] { 19, 16, 13, 14 };
			break;
		case 16:
			this.name = "白展堂";
			this.quality = Quality.YELLOW;
			this.contactIdS = new Integer[] { 15, 17, 1, 14 };
			break;
		case 17:
			this.name = "姬无命";
			this.quality = Quality.PURPLE;
			this.contactIdS = new Integer[] { 13, 16, 20, 4 };
			break;
		case 18:
			this.name = "李秀莲";
			this.quality = Quality.PURPLE;
			this.contactIdS = new Integer[] { 1, 2, 3, 9 };
			break;
		case 19:
			this.name = "展红绫";
			this.quality = Quality.PURPLE;
			this.contactIdS = new Integer[] { 16, 3, 23, 4 };
			break;
		case 20:
			this.name = "上官云顿";
			this.quality = Quality.PURPLE;
			this.contactIdS = new Integer[] { 12, 13, 17, 18 };
			break;
		case 21:
			this.name = "邢玉森";
			this.quality = Quality.BLUE;
			this.contactIdS = new Integer[] { 17, 6, 25, 8 };
			break;
		case 22:
			this.name = "恭长老";
			this.quality = Quality.BLUE;
			this.contactIdS = new Integer[] { 16, 3, 14, 8 };
			break;
		case 23:
			this.name = "追风";
			this.quality = Quality.BLUE;
			this.contactIdS = new Integer[] { 14, 15, 19, 3 };
			break;
		case 24:
			this.name = "路一鸣";
			this.quality = Quality.BLUE;
			this.contactIdS = new Integer[] { 5, 1, 12, 23 };
			break;
		case 25:
			this.name = "娄知县";
			this.quality = Quality.GREEN;
			this.contactIdS = new Integer[] { 21, 6, 18, 11 };
			break;

		case 26:
			this.name = "平谷一点红";
			this.quality = Quality.YELLOW;
			this.contactIdS = new Integer[] { 14, 16, 4, 27 };
			break;
		case 27:
			this.name = "展堂";
			this.quality = Quality.PURPLE;
			this.contactIdS = new Integer[] { 2, 26, 1, 17 };
			break;
		case 28:
			this.name = "美丽";
			this.quality = Quality.BLUE;
			this.contactIdS = new Integer[] { 29, 3, 19, 25 };
			break;
		case 29:
			this.name = "打折";
			this.quality = Quality.BLUE;
			this.contactIdS = new Integer[] { 28, 2, 7, 8 };
			break;

		case 30:
			this.name = "凌腾云";
			this.quality = Quality.YELLOW;
			this.contactIdS = new Integer[] { 31, 26, 27, 34 };
			break;
		case 31:
			this.name = "莫小宝";
			this.quality = Quality.YELLOW;
			this.contactIdS = new Integer[] { 30, 27, 38, 36 };
			break;
		case 32:
			this.name = "断指轩辕";
			this.quality = Quality.YELLOW;
			this.contactIdS = new Integer[] { 33, 18, 13, 35 };
			break;
		case 33:
			this.name = "佟伯达";
			this.quality = Quality.YELLOW;
			this.contactIdS = new Integer[] { 32, 1, 17, 37 };
			break;

		case 34:
			this.name = "金长老";
			this.quality = Quality.PURPLE;
			this.contactIdS = new Integer[] { 36, 30, 26, 38 };
			break;
		case 35:
			this.name = "姬无病";
			this.quality = Quality.PURPLE;
			this.contactIdS = new Integer[] { 37, 17, 16, 32 };
			break;
		case 36:
			this.name = "银长老";
			this.quality = Quality.PURPLE;
			this.contactIdS = new Integer[] { 34, 31, 27, 28 };
			break;
		case 37:
			this.name = "姬无力";
			this.quality = Quality.PURPLE;
			this.contactIdS = new Integer[] { 35, 17, 18, 33 };
			break;

		case 38:
			this.name = "祝小云";
			this.quality = Quality.BLUE;
			this.contactIdS = new Integer[] { 31, 29, 24, 5 };
			break;
		}
	}

	/**
	 * 获取ID
	 * 
	 * @return
	 */
	public Integer getId() {

		return this.id;
	}

	/**
	 * 获取名称
	 * 
	 * @return
	 */
	public String getName() {

		return this.name;
	}

	/**
	 * 获取品质
	 * 
	 * @return
	 */
	public Quality getQuality() {

		return this.quality;
	}

	/**
	 * 是否相同
	 * 
	 * @param xy
	 * @return
	 */
	public boolean equals(XiaYing xy) {

		return this.getId().equals(xy.getId());
	}

	/**
	 * 是否有联系
	 * 
	 * @param xy
	 * @return
	 */
	public boolean hadContact(XiaYing xy) {

		return Arrays.asList(this.contactIdS).contains(xy.getId());
	}

	/**
	 * 品质
	 * 
	 * @author XuYQ
	 *
	 */
	public enum Quality {

		GREEN("绿卡"), BLUE("蓝卡"), PURPLE("紫卡"), YELLOW("金卡");

		/**
		 * 描述
		 */
		private String desc;

		/**
		 * 描述
		 * 
		 * @param desc
		 */
		private Quality(String desc) {

			this.desc = desc;
		}

		public String getDesc() {

			return this.desc;
		}
	}
}