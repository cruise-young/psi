package com.hy.psicrm.sys.web;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.psicrm.common.Constast;
import com.hy.psicrm.common.DataGridView;
import com.hy.psicrm.sys.entity.MenuTreeNode;
import com.hy.psicrm.sys.entity.MenuTreeNodeBuilder;
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
	public DataGridView loadIndexLeftMenuJson(PermissionVo permissionVo) {
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
			//list = permissionService.list(queryWrapper);
		}

		ArrayList<MenuTreeNode> menus = new ArrayList<>();
		for (Permission p : list) {
			Integer id=p.getId();
			Integer pid=p.getPid();
			String title=p.getTitle();
			String icon=p.getIcon();
			String href=p.getHref();
			Boolean spread=false;
			menus.add(new MenuTreeNode(id, pid, title, icon, href, spread));
		}
		//构造层级关系
		List<MenuTreeNode> menuList = MenuTreeNodeBuilder.build(menus, 1);
		return new DataGridView(menuList);
	}

}
