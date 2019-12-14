package com.hy.psicrm.sys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转
 * 不能用@restController
 * 所以单独一个
 * @author 007
 */
@Controller
@RequestMapping("sys")
public class SystemController {
	
	/**
	 * 跳转到登陆页面
	 */
	@RequestMapping("toLogin.do")
	public String toLogin() {
		// template目录下login.html
		// jtzy下所有文件和url访问都会放行 ？ todo 即可通过这种方式来进入template下页面？
		// shiroFilterFactoryBean.setLoginUrl("/sys/toLogin.do");
		// 拦截template下配置的请求，上一行的路径要写对！
		return "login";
	}
	
	/**
	 * 跳转到主页
	 */
	@RequestMapping("toIndex.do")
	public String index() {
		// template目录下index/index.html
		return "index/index";
	}
	
}
