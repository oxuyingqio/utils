package cn.xuyingqi.util.wl;

import cn.xuyingqi.util.wl.XiaYing.Quality;

/**
 * 
 * @author XuYQ
 *
 */
public class ShangZhen {

	private XiaYing xy1;
	private XiaYing xy2;
	private XiaYing xy3;
	private XiaYing xy4;
	private XiaYing xy5;
	private XiaYing xy6;

	/**
	 * 
	 * @param xy1
	 * @param xy2
	 * @param xy3
	 * @param xy4
	 * @param xy5
	 * @param xy6
	 */
	public ShangZhen(int xy1, int xy2, int xy3, int xy4, int xy5, int xy6) {

		this.xy1 = new XiaYing(xy1);
		this.xy2 = new XiaYing(xy2);
		this.xy3 = new XiaYing(xy3);
		this.xy4 = new XiaYing(xy4);
		this.xy5 = new XiaYing(xy5);
		this.xy6 = new XiaYing(xy6);
	}

	/**
	 * 是否合法
	 * 
	 * @return
	 */
	public boolean isLegal() {

		// 存在重复,则不合法
		if (this.xy1.equals(xy2) || this.xy1.equals(xy3) || this.xy1.equals(xy4) || this.xy1.equals(xy5)
				|| this.xy1.equals(xy6) || this.xy2.equals(xy3) || this.xy2.equals(xy4) || this.xy2.equals(xy5)
				|| this.xy2.equals(xy6) || this.xy3.equals(xy4) || this.xy3.equals(xy5) || this.xy3.equals(xy6)
				|| this.xy4.equals(xy5) || this.xy4.equals(xy6) || this.xy5.equals(xy6)) {

			return false;
		}

		// 16.白展堂不合法
		if (this.xy1.getId() == 16 || this.xy2.getId() == 16 || this.xy3.getId() == 16 || this.xy4.getId() == 16
				|| this.xy5.getId() == 16 || this.xy6.getId() == 16) {

			return false;
		}

		return true;
	}

	/**
	 * 计算联系
	 * 
	 * @return
	 */
	public int contacts() {

		int contacts = 0;

		// 1
		if (this.xy1.hadContact(this.xy2)) {
			contacts++;
		}
		if (this.xy1.hadContact(this.xy3)) {
			contacts++;
		}
		if (this.xy1.hadContact(this.xy4)) {
			contacts++;
		}
		if (this.xy1.hadContact(this.xy5)) {
			contacts++;
		}
		if (this.xy1.hadContact(this.xy6)) {
			contacts++;
		}

		// 2
		if (this.xy2.hadContact(this.xy1)) {
			contacts++;
		}
		if (this.xy2.hadContact(this.xy3)) {
			contacts++;
		}
		if (this.xy2.hadContact(this.xy4)) {
			contacts++;
		}
		if (this.xy2.hadContact(this.xy5)) {
			contacts++;
		}
		if (this.xy2.hadContact(this.xy6)) {
			contacts++;
		}

		// 3
		if (this.xy3.hadContact(this.xy1)) {
			contacts++;
		}
		if (this.xy3.hadContact(this.xy2)) {
			contacts++;
		}
		if (this.xy3.hadContact(this.xy4)) {
			contacts++;
		}
		if (this.xy3.hadContact(this.xy5)) {
			contacts++;
		}
		if (this.xy3.hadContact(this.xy6)) {
			contacts++;
		}

		// 4
		if (this.xy4.hadContact(this.xy1)) {
			contacts++;
		}
		if (this.xy4.hadContact(this.xy2)) {
			contacts++;
		}
		if (this.xy4.hadContact(this.xy3)) {
			contacts++;
		}
		if (this.xy4.hadContact(this.xy5)) {
			contacts++;
		}
		if (this.xy4.hadContact(this.xy6)) {
			contacts++;
		}

		// 5
		if (this.xy5.hadContact(this.xy1)) {
			contacts++;
		}
		if (this.xy5.hadContact(this.xy2)) {
			contacts++;
		}
		if (this.xy5.hadContact(this.xy3)) {
			contacts++;
		}
		if (this.xy5.hadContact(this.xy4)) {
			contacts++;
		}
		if (this.xy5.hadContact(this.xy6)) {
			contacts++;
		}

		// 6
		if (this.xy6.hadContact(this.xy1)) {
			contacts++;
		}
		if (this.xy6.hadContact(this.xy2)) {
			contacts++;
		}
		if (this.xy6.hadContact(this.xy3)) {
			contacts++;
		}
		if (this.xy6.hadContact(this.xy4)) {
			contacts++;
		}
		if (this.xy6.hadContact(this.xy5)) {
			contacts++;
		}

		return contacts;
	}

	/**
	 * 品质数量
	 * 
	 * @param quality
	 * @return
	 */
	public int quality(Quality quality) {

		int qualityNum = 0;
		if (xy1.getQuality() == quality) {

			qualityNum++;
		}
		if (xy2.getQuality() == quality) {

			qualityNum++;
		}
		if (xy3.getQuality() == quality) {

			qualityNum++;
		}
		if (xy4.getQuality() == quality) {

			qualityNum++;
		}
		if (xy5.getQuality() == quality) {

			qualityNum++;
		}
		if (xy6.getQuality() == quality) {

			qualityNum++;
		}

		return qualityNum;
	}

	@Override
	public String toString() {

		StringBuffer sb = new StringBuffer();
		sb.append("【" + this.xy1.getName() + "[" + this.xy1.getQuality().getDesc() + "]】, ");
		sb.append("【" + this.xy2.getName() + "[" + this.xy2.getQuality().getDesc() + "]】, ");
		sb.append("【" + this.xy3.getName() + "[" + this.xy3.getQuality().getDesc() + "]】, ");
		sb.append("【" + this.xy4.getName() + "[" + this.xy4.getQuality().getDesc() + "]】, ");
		sb.append("【" + this.xy5.getName() + "[" + this.xy5.getQuality().getDesc() + "]】, ");
		sb.append("【" + this.xy6.getName() + "[" + this.xy6.getQuality().getDesc() + "]】 ");

		return sb.toString();
	}
}