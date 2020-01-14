package com.hy.psicrm.sys.web;


import com.hy.psicrm.common.ResultObj;
import com.hy.psicrm.common.UserInfos;
import com.hy.psicrm.sys.entity.OperateInfo;
import com.hy.psicrm.sys.service.IOperateInfoService;
import com.hy.psicrm.sys.utils.CryptographyUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author CruiseYoung
 * @date
 */
@RestController
@RequestMapping("login")
public class LoginController {
	private final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private IOperateInfoService operateInfoService;

	@RequestMapping("login")
	public ResultObj login(String userName, String password, HttpServletRequest req) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(userName, CryptographyUtil.md5(password, "java"));
		logger.info("token:{}", token);
		try {
			subject.login(token);
			UserInfos userInfos=(UserInfos) subject.getPrincipal();
			logger.info("userInfos:{}", userInfos);
			req.getSession().setAttribute("user", userInfos.getUser());

			// 保存登录信息
			OperateInfo operateInfo = new OperateInfo();
			operateInfo.setLoginIp(req.getRemoteAddr());
			operateInfo.setLoginName(userName);
			operateInfo.setLoginTime(new Date());
			operateInfoService.save(operateInfo);

			return ResultObj.登陆成功;
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return ResultObj.登陆用户名或密码不正确;
		}
	}
}

