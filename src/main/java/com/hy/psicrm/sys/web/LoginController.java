package com.hy.psicrm.sys.web;


import com.hy.psicrm.sys.common.ResultObj;
import com.hy.psicrm.sys.common.UserInfos;
import com.hy.psicrm.sys.utils.CryptographyUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author CruiseYoung
 * @date
 */
@RestController
@RequestMapping("login")
public class LoginController {
	private final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping("login")
	public JSONObject login(String userName, String password, HttpServletRequest req) {
		JSONObject result = new JSONObject();
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(userName, CryptographyUtil.md5(password, "java"));
		logger.info("token:{}", token);
		try {
			subject.login(token);
			UserInfos userInfos=(UserInfos) subject.getPrincipal();
			logger.info("userInfos:{}", userInfos);
			req.getSession().setAttribute("user", userInfos.getUser());
			result.put("code", 200);
			result.put("msg","登陆成功");
			return result;
		} catch (AuthenticationException e) {
			e.printStackTrace();
			result.put("code", 500);
			result.put("msg","登陆失败,用户名或密码不正确");
			return result;
		}
	}
}

