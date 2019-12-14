package com.hy.psicrm.sys.realm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.psicrm.sys.common.UserInfos;
import com.hy.psicrm.sys.entity.User;
import com.hy.psicrm.sys.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Created by CruiseYoung on 2019/12/6 23:32
 */
public class UserRealm extends AuthorizingRealm {

	@Autowired
	private IUserService userService;

	@Override
	public String getName() {
		return this.getClass().getSimpleName();
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("user_name", token.getPrincipal().toString());
		User user = userService.getOne(queryWrapper);

		if(user != null) {
			UserInfos userInfos = new UserInfos();
			userInfos.setUser(user);
//			userInfos.setRoles();
//			userInfos.setPermissions();
			ByteSource salt = ByteSource.Util.bytes(user.getSalt());
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userInfos, user.getPassword(), this.getName());

			return info;
		}

		return null;
	}

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		return null;
	}
}
