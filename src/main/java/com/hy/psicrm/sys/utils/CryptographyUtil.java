package com.hy.psicrm.sys.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 *
 * @author Created by CruiseYoung on 2019/12/9 22:18
 */
public class CryptographyUtil {
	public static void main(String[] args) throws Exception {
		System.out.println(md5("123456", "java"));
	}

	/**
	 * Md5加密  加盐
	 * 123456 =ba61ce8fa1e3725876e6363c76043c8d
	 */
	public static String md5(String pwd, String salt) {
		return new Md5Hash(pwd, salt).toString();
	}

}
