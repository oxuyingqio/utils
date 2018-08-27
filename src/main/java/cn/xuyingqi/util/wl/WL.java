package cn.xuyingqi.util.wl;

import cn.xuyingqi.util.wl.XiaYing.Quality;

public class WL {

	public static void main(String[] args) {

		// 总个数
		int size = 38;

		for (int a1 = 1; a1 <= size - 5; a1++) {

			for (int a2 = a1 + 1; a2 <= size - 4; a2++) {

				for (int a3 = a2 + 1; a3 <= size - 3; a3++) {

					for (int a4 = a3 + 1; a4 <= size - 2; a4++) {

						for (int a5 = a4 + 1; a5 <= size - 1; a5++) {

							for (int a6 = a5 + 1; a6 <= size - 0; a6++) {

								// 上阵
								ShangZhen sz = new ShangZhen(a1, a2, a3, a4, a5, a6);

								// 是否合法,情缘个数
								if (sz.isLegal() && sz.contacts() >= 16 && sz.quality(Quality.YELLOW) >= 3) {

									System.out.println("【情缘数：" + sz.contacts() + "】   " + sz);
								}
							}
						}
					}
				}
			}
		}
	}
}