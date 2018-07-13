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

		// TXY 1 [4,16,3,5]
		// ZWS 2 [16,18,4,6]
		// GFR 3 [14,4,1,2]
		// LQH 4 [1,14,17,3]
		// MXB 5 [2,12,1,24]
		// YXL 6 [2,11,21,8]
		// NGCH 7 [1,2,4,18]
		// XM 8 [1,18,22,21]
		// YHL 9 [18,2,10,7]
		// HDS 10 [22,18,9,25]
		// YES 11 [6,25,3,21]
		// YST 12 [20,13,17,5]
		// GSWL 13 [12,15,4,17]
		// GJX 14 [15,3,4,19]
		// BSN 15 [19,16,13,14]
		// BZT 16 [15,17,1,14]
		// JWM 17 [13,16,20,4]
		// LXL 18 [1,2,3,9]
		// ZHL 19 [16,3,23,4]
		// SGYD 20 [12,13,17,18]
		// XYS 21 [17,6,25,8]
		// GZL 22 [16,3,14,8]
		// ZF 23 [14,15,19,3]
		// LYM 24 [5,1,12,23]
		// LZX 25 [21,6,18,11]

		// PGYDH 26 [14,16,4,27]
		// ZT 27 [2,26,1,17]
		// ML 28 [29,3,19,25]
		// DZ 29 [28,2,7,8]

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
			this.quality = Quality.GREEN;
			this.contactIdS = new Integer[] { 2, 26, 1, 17 };
			break;
		case 28:
			this.name = "美丽";
			this.quality = Quality.GREEN;
			this.contactIdS = new Integer[] { 29, 3, 19, 25 };
			break;
		case 29:
			this.name = "打折";
			this.quality = Quality.GREEN;
			this.contactIdS = new Integer[] { 28, 2, 7, 8 };
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