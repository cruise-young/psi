package com.hy.psicrm.sys.common;

public interface Constast {
	
	
	/**
	 * 状态码
	 * 
	 */
	public static final Integer OK=200;
	public static final Integer ERROR=-1;

	/**
	 * 状态
	 */
	public static final Object VALID = 1;
	public static final Object INVALID = 0;

	/**
	 * 菜单权限类型
	 */
	public static final String TYPE_MENU = "menu";
	public static final String TYPE_PERMISSION = "permission";

	/**
	 * 用户类型
	 */
	public static final Integer USER_TYPE_SUPER = 0;
	public static final Integer USER_TYPE_NORMAL = 1;

}
