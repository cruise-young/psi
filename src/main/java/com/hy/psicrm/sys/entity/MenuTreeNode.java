package com.hy.psicrm.sys.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by CruiseYoung on 2019/12/24 19:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuTreeNode {
	private Integer id;
	@JsonProperty("parentId")
	private Integer pid;
	private String title;
	private String icon;
	private String href;
	private Boolean spread;
	private List<MenuTreeNode> children = new ArrayList<MenuTreeNode>();
	/**
	 * 首页左边导航树的构造器
	 */
	public MenuTreeNode(Integer id, Integer pid, String title, String icon, String href, Boolean spread) {
		super();
		this.id = id;
		this.pid = pid;
		this.title = title;
		this.icon = icon;
		this.href = href;
		this.spread = spread;
	}

	/**
	 * dtree的数据格式
	 * @param id
	 * @param pid
	 * @param title
	 * @param spread
	 */
	public MenuTreeNode(Integer id, Integer pid, String title, Boolean spread) {
		super();
		this.id = id;
		this.pid = pid;
		this.title = title;
		this.spread = spread;
	}

}
