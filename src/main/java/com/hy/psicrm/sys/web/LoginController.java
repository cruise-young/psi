package com.hy.psicrm.sys.web;


import com.hy.psicrm.sys.common.ResultObj;
import com.hy.psicrm.sys.common.UserInfos;
import com.hy.psicrm.sys.common.WebUtils;
import com.hy.psicrm.sys.utils.CryptographyUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CruiseYoung
 * @date
 */
@RestController
@RequestMapping("login")
public class LoginController {
	
	@RequestMapping("login")
	public ResultObj login(String userName, String password) {
		Subject subject = SecurityUtils.getSubject();
//		AuthenticationToken token=new UsernamePasswordToken(userName, password);
		UsernamePasswordToken token=new UsernamePasswordToken(userName, CryptographyUtil.md5(password, "java"));
		try {
			subject.login(token);
			UserInfos userInfos=(UserInfos) subject.getPrincipal();
			//WebUtils.getSession().setAttribute("user", userInfos.getUser());
			return ResultObj.LOGIN_SUCCESS;
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return ResultObj.LOGIN_ERROR_PASS;
		}
	}
}

