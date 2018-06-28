package cn.xuyingqi.util.wl;

public class WL {

	public static void main(String[] args) {

		// 总个数
		int size = 25;

		// 符合的情况
		int index = 1;

		for (int a1 = 1; a1 <= size; a1++) {

			for (int a2 = a1; a2 <= size; a2++) {

				for (int a3 = a2; a3 <= size; a3++) {

					for (int a4 = a3; a4 <= size; a4++) {

						for (int a5 = a4; a5 <= size; a5++) {

							for (int a6 = a5; a6 <= size; a6++) {

								ShangZhen sz = new ShangZhen(a1, a2, a3, a4, a5, a6);

								if (sz.isLegal() && sz.qingYuan() >= 17) {

									System.out.println("第" + index++ + "次.情缘数：" + sz.qingYuan());
									System.out.println(sz);
								}
							}
						}
					}
				}
			}
		}
	}
}