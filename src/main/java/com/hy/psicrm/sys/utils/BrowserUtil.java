package com.hy.psicrm.sys.utils;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Created by CruiseYoung on 2019/12/17 18:42
 */
public class BrowserUtil {
	/**
	 * 判断是否为IE浏览器
	 * @param userAgent
	 * @return
	 */
	public static boolean isMSBrowser(String userAgent) {
		String ua = userAgent.toLowerCase();
		String[] ieSignals = {"msie", "trident", "edge"};

		for (String signal : ieSignals) {
			if (ua.contains(signal)){
				return true;
			}
		}
		return false;
	}

	/**
	 * 检测浏览器   是不是 极速 模式
	 * 360浏览器 =AppleWebKit
	 * 火狐=Firefox
	 * 搜狗=AppleWebKit
	 * qq浏览器=AppleWebKit
	 * 极速内核（webkit内核），兼容内核（trident内核）
	 * @return true极速模式    false 兼容模式
	 */
	public static boolean checkUserAgent(String UserAgent){
		boolean falg = true;
		UserAgent = UserAgent.toLowerCase();
		if(UserAgent.indexOf("trident")!=-1){
			falg = false;
		}
		return falg;
	}

}
