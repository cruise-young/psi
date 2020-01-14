package com.hy.psicrm.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CruiseYoung
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultObj {

	private Integer code;
	private String msg;

	public static final ResultObj  登陆成功=new ResultObj(Constast.OK, "登陆成功");
	public static final ResultObj  登陆用户名或密码不正确=new ResultObj(Constast.ERROR, "登陆失败,用户名或密码不正确");
	public static final ResultObj  登陆验证码不正确=new ResultObj(Constast.ERROR, "登陆失败,验证码不正确");

	public static final ResultObj  更新成功=new ResultObj(Constast.OK, "更新成功");
	public static final ResultObj  更新失败=new ResultObj(Constast.ERROR, "更新失败");

	public static final ResultObj  添加成功=new ResultObj(Constast.OK, "添加成功");
	public static final ResultObj  添加失败=new ResultObj(Constast.ERROR, "添加失败");

	public static final ResultObj  删除成功=new ResultObj(Constast.OK, "删除成功");
	public static final ResultObj  删除失败=new ResultObj(Constast.ERROR, "删除失败");


}
