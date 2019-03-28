package cn.xuyingqi.util.util;

import java.io.File;

import org.junit.Test;

import cn.xuyingqi.util.FileUtils;

public class FileUtilsTest {

	@Test
	public void test() {

		/**
		 * EasyUI 官网地址
		 */
		String easyuiURL = "http://www.jeasyui.com/";

		/**
		 * 公共的文件路径
		 */
		String commonFile = "easyui/themes/";
		
		String theme = "metro-blue";
		
		/**
		 * 主题涉及的文件
		 */
		String[] themeFiles = new String[] { easyuiURL + commonFile + theme + "/easyui.css",
				easyuiURL + commonFile + theme + "/images/accordion_arrows.png",
				easyuiURL + commonFile + theme + "/images/blank.gif",
				easyuiURL + commonFile + theme + "/images/calendar_arrows.png",
				easyuiURL + commonFile + theme + "/images/combo_arrow.png",
				easyuiURL + commonFile + theme + "/images/datagrid_icons.png",
				easyuiURL + commonFile + theme + "/images/datebox_arrow.png",
				easyuiURL + commonFile + theme + "/images/layout_arrows.png",
				easyuiURL + commonFile + theme + "/images/linkbutton_bg.png",
				easyuiURL + commonFile + theme + "/images/loading.gif",
				easyuiURL + commonFile + theme + "/images/menu_arrows.png",
				easyuiURL + commonFile + theme + "/images/messager_icons.png",
				easyuiURL + commonFile + theme + "/images/pagination_icons.png",
				easyuiURL + commonFile + theme + "/images/panel_tools.png",
				easyuiURL + commonFile + theme + "/images/searchbox_button.png",
				easyuiURL + commonFile + theme + "/images/slider_handle.png",
				easyuiURL + commonFile + theme + "/images/spinner_arrows.png",
				easyuiURL + commonFile + theme + "/images/tabs_icons.png",
				easyuiURL + commonFile + theme + "/images/tree_icons.png",
				easyuiURL + commonFile + theme + "/images/validatebox_warning.png" };

		for (int i = 0; i < themeFiles.length; i++) {

			FileUtils.downloadNetworkResource(themeFiles[i], new File("D:/Users/XuYQ/Desktop/d"));
		}
	}
}
