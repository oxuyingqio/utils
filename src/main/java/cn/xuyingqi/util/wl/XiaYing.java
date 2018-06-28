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
	 * 情缘ID
	 */
	private Integer[] qingYuanIdS = null;

	/**
	 * 
	 * @param id
	 */
	public XiaYing(Integer id) {

		this.id = id;

		if (this.id == 1) {

			this.qingYuanIdS = new Integer[] { 4, 16, 3, 5 };
		} else if (this.id == 2) {

			this.qingYuanIdS = new Integer[] { 16, 18, 4, 6 };
		} else if (this.id == 3) {

			this.qingYuanIdS = new Integer[] { 14, 4, 1, 2 };
		} else if (this.id == 4) {

			this.qingYuanIdS = new Integer[] { 1, 14, 17, 3 };
		} else if (this.id == 5) {

			this.qingYuanIdS = new Integer[] { 2, 12, 1, 24 };
		} else if (this.id == 6) {

			this.qingYuanIdS = new Integer[] { 2, 11, 21, 8 };
		} else if (this.id == 7) {

			this.qingYuanIdS = new Integer[] { 1, 2, 4, 18 };
		} else if (this.id == 8) {

			this.qingYuanIdS = new Integer[] { 1, 18, 22, 21 };
		} else if (this.id == 9) {

			this.qingYuanIdS = new Integer[] { 18, 2, 10, 7 };
		} else if (this.id == 10) {

			this.qingYuanIdS = new Integer[] { 22, 18, 9, 25 };
		} else if (this.id == 11) {

			this.qingYuanIdS = new Integer[] { 6, 25, 3, 21 };
		} else if (this.id == 12) {

			this.qingYuanIdS = new Integer[] { 20, 13, 17, 5 };
		} else if (this.id == 13) {

			this.qingYuanIdS = new Integer[] { 12, 15, 4, 17 };
		} else if (this.id == 14) {

			this.qingYuanIdS = new Integer[] { 15, 3, 4, 19 };
		} else if (this.id == 15) {

			this.qingYuanIdS = new Integer[] { 19, 16, 13, 14 };
		} else if (this.id == 16) {

			this.qingYuanIdS = new Integer[] { 15, 17, 1, 14 };
		} else if (this.id == 17) {

			this.qingYuanIdS = new Integer[] { 13, 16, 20, 4 };
		} else if (this.id == 18) {

			this.qingYuanIdS = new Integer[] { 1, 2, 3, 9 };
		} else if (this.id == 19) {

			this.qingYuanIdS = new Integer[] { 16, 3, 23, 4 };
		} else if (this.id == 20) {

			this.qingYuanIdS = new Integer[] { 12, 13, 17, 18 };
		} else if (this.id == 21) {

			this.qingYuanIdS = new Integer[] { 17, 6, 25, 8 };
		} else if (this.id == 22) {

			this.qingYuanIdS = new Integer[] { 16, 3, 14, 8 };
		} else if (this.id == 23) {

			this.qingYuanIdS = new Integer[] { 14, 15, 19, 3 };
		} else if (this.id == 24) {

			this.qingYuanIdS = new Integer[] { 5, 1, 12, 23 };
		} else if (this.id == 25) {

			this.qingYuanIdS = new Integer[] { 21, 6, 18, 11 };
		}

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
	}

	/**
	 * 获取ID
	 * 
	 * @return
	 */
	public Integer getId() {

		return this.id;
	}

	public boolean equals(XiaYing xy) {

		return this.getId().equals(xy.getId());
	}

	public boolean isQingYuan(XiaYing xy) {

		return Arrays.asList(this.qingYuanIdS).contains(xy.getId());
	}
}