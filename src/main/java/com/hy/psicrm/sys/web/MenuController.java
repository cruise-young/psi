package com.hy.psicrm.sys.web;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.psicrm.sys.common.Constast;
import com.hy.psicrm.sys.common.DataGridView;
import com.hy.psicrm.sys.entity.Permission;
import com.hy.psicrm.sys.entity.User;
import com.hy.psicrm.sys.service.IPermissionService;
import com.hy.psicrm.sys.utils.WebUtils;
import com.hy.psicrm.sys.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单管理前端控制器
 * @author Created by CruiseYoung on 2019/12/20 23:59
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	private IPermissionService permissionService;

	@RequestMapping("loadIndexLeftMenuJson")
	public JSONObject loadIndexLeftMenuJson(PermissionVo permissionVo) {
		JSONObject result = new JSONObject();
		//查询所有菜单
		QueryWrapper<Permission> queryWrapper=new QueryWrapper<>();
		//设置只能查询菜单
		queryWrapper.eq("type", Constast.TYPE_MENU);
		queryWrapper.eq("status", Constast.VALID);

		User user = (User) WebUtils.getSession().getAttribute("user");
		List<Permission> list=null;
		if(Constast.USER_TYPE_SUPER.equals(user.getType())) {
			list = permissionService.list(queryWrapper);
		}else {
			//根据用户ID+角色+权限去查询
			list = permissionService.list(queryWrapper);
		}
		// return new DataGridView(list);

		result.put("code","0");
		result.put("data",list);
		result.put("msg","");
		result.put("count",list.size());
		return result;
	}

}
