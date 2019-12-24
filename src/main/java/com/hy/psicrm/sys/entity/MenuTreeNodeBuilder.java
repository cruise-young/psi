package com.hy.psicrm.sys.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Created by CruiseYoung on 2019/12/24 19:42
 */
public class MenuTreeNodeBuilder {
	/**
	 * 把没有层级关系的集合变成有层级关系的
	 */
	public static List<MenuTreeNode> build(List<MenuTreeNode> menus, Integer topPid){
		List<MenuTreeNode> nodes=new ArrayList<>();
		for (MenuTreeNode n1 : menus) {
			if(n1.getPid().equals(topPid)) {
				nodes.add(n1);
			}
			for (MenuTreeNode n2 : menus) {
				if(n1.getId().equals(n2.getPid())) {
					n1.getChildren().add(n2);
				}
			}
		}
		return nodes;
	}
}
