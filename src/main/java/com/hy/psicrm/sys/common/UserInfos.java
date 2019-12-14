package com.hy.psicrm.sys.common;

import com.hy.psicrm.sys.entity.User;
import lombok.Data;

import java.util.List;

/**
 * @author Created by CruiseYoung on 2019/12/6 23:23
 */
@Data
public class UserInfos {
	private User user;
	private List<String> roles;
	private List<String> permissions;

}
