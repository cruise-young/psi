package com.hy.psicrm.sys.web;

import com.hy.psicrm.sys.utils.BrowserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 页面跳转
 * 不能用@restController
 * 所以单独一个
 * @author 007
 */
@Controller
@RequestMapping("sys")
public class SystemController {
	private final Logger logger = LoggerFactory.getLogger(SystemController.class);
	/**
	 * 跳转到登陆页面
	 */
	@RequestMapping("toLogin.do")
	public ModelAndView toLogin(HttpServletResponse resp, HttpServletRequest req) {
		// template目录下login.html
		// shiroFilterFactoryBean.setLoginUrl("/sys/toLogin.do");
		// 拦截template下配置的请求，上一行的路径要写对！
		ModelAndView mav = new ModelAndView();
		String userAgent = req.getHeader("User-Agent");
		//判断是否ie
		if(BrowserUtil.isMSBrowser(userAgent)){
			mav.setViewName("system/errorBrowser");
		}else{
			logger.info("跳转到登陆页面");
			mav.setViewName("login");
		}
		return mav;
	}

	/**
	 * 跳转到主页
	 */
	@RequestMapping("toIndex.do")
	public String index() {
		// template目录下index/index.html
		return "index/index";
	}

	/**
	 * 跳转到工作台
	 */
	@RequestMapping("toMain.do")
	public String main() {
		return "index/main";
	}

	/**
	 * 跳转到公告
	 */
	@RequestMapping("toOperateInfo.do")
	public String operateInfo() {
		return "system/operateInfo";
	}

	/**
	 * 跳转到公告
	 */
	@RequestMapping("toNotice.do")
	public String notice() {
		return "system/announcement";
	}

}
