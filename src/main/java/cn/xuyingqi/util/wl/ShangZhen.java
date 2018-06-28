package cn.xuyingqi.util.wl;

public class ShangZhen {

	private XiaYing xy1;
	private XiaYing xy2;
	private XiaYing xy3;
	private XiaYing xy4;
	private XiaYing xy5;
	private XiaYing xy6;

	public ShangZhen(int xy1, int xy2, int xy3, int xy4, int xy5, int xy6) {

		this.xy1 = new XiaYing(xy1);
		this.xy2 = new XiaYing(xy2);
		this.xy3 = new XiaYing(xy3);
		this.xy4 = new XiaYing(xy4);
		this.xy5 = new XiaYing(xy5);
		this.xy6 = new XiaYing(xy6);
	}

	public boolean isLegal() {

		if (this.xy1.equals(xy2) || this.xy1.equals(xy3) || this.xy1.equals(xy4) || this.xy1.equals(xy5)
				|| this.xy1.equals(xy6) || this.xy2.equals(xy3) || this.xy2.equals(xy4) || this.xy2.equals(xy5)
				|| this.xy2.equals(xy6) || this.xy3.equals(xy4) || this.xy3.equals(xy5) || this.xy3.equals(xy6)
				|| this.xy4.equals(xy5) || this.xy4.equals(xy6) || this.xy5.equals(xy6)) {

			return false;
		}

		return true;
	}

	public int qingYuan() {

		int qingYuan = 0;

		// 1
		if (this.xy1.isQingYuan(this.xy2)) {
			qingYuan++;
		}
		if (this.xy1.isQingYuan(this.xy3)) {
			qingYuan++;
		}
		if (this.xy1.isQingYuan(this.xy4)) {
			qingYuan++;
		}
		if (this.xy1.isQingYuan(this.xy5)) {
			qingYuan++;
		}
		if (this.xy1.isQingYuan(this.xy6)) {
			qingYuan++;
		}

		// 2
		if (this.xy2.isQingYuan(this.xy1)) {
			qingYuan++;
		}
		if (this.xy2.isQingYuan(this.xy3)) {
			qingYuan++;
		}
		if (this.xy2.isQingYuan(this.xy4)) {
			qingYuan++;
		}
		if (this.xy2.isQingYuan(this.xy5)) {
			qingYuan++;
		}
		if (this.xy2.isQingYuan(this.xy6)) {
			qingYuan++;
		}

		// 3
		if (this.xy3.isQingYuan(this.xy1)) {
			qingYuan++;
		}
		if (this.xy3.isQingYuan(this.xy2)) {
			qingYuan++;
		}
		if (this.xy3.isQingYuan(this.xy4)) {
			qingYuan++;
		}
		if (this.xy3.isQingYuan(this.xy5)) {
			qingYuan++;
		}
		if (this.xy3.isQingYuan(this.xy6)) {
			qingYuan++;
		}

		// 4
		if (this.xy4.isQingYuan(this.xy1)) {
			qingYuan++;
		}
		if (this.xy4.isQingYuan(this.xy2)) {
			qingYuan++;
		}
		if (this.xy4.isQingYuan(this.xy3)) {
			qingYuan++;
		}
		if (this.xy4.isQingYuan(this.xy5)) {
			qingYuan++;
		}
		if (this.xy4.isQingYuan(this.xy6)) {
			qingYuan++;
		}

		// 5
		if (this.xy5.isQingYuan(this.xy1)) {
			qingYuan++;
		}
		if (this.xy5.isQingYuan(this.xy2)) {
			qingYuan++;
		}
		if (this.xy5.isQingYuan(this.xy3)) {
			qingYuan++;
		}
		if (this.xy5.isQingYuan(this.xy4)) {
			qingYuan++;
		}
		if (this.xy5.isQingYuan(this.xy6)) {
			qingYuan++;
		}

		// 6
		if (this.xy6.isQingYuan(this.xy1)) {
			qingYuan++;
		}
		if (this.xy6.isQingYuan(this.xy2)) {
			qingYuan++;
		}
		if (this.xy6.isQingYuan(this.xy3)) {
			qingYuan++;
		}
		if (this.xy6.isQingYuan(this.xy4)) {
			qingYuan++;
		}
		if (this.xy6.isQingYuan(this.xy5)) {
			qingYuan++;
		}

		return qingYuan;
	}

	@Override
	public String toString() {

		StringBuffer sb = new StringBuffer();
		sb.append("[" + this.xy1.getId() + "], ");
		sb.append("[" + this.xy2.getId() + "], ");
		sb.append("[" + this.xy3.getId() + "], ");
		sb.append("[" + this.xy4.getId() + "], ");
		sb.append("[" + this.xy5.getId() + "], ");
		sb.append("[" + this.xy6.getId() + "]");

		return sb.toString();
	}
}