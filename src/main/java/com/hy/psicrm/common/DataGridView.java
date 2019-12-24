package com.hy.psicrm.common;

import cn.hutool.json.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * json数据实体
 * @author Created by CruiseYoung on 2019/12/21 0:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataGridView {

	private Integer code=0;
	private String msg="";
	private Long count=0L;
	private Object data;
	public DataGridView(Long count, Object data) {
		super();
		this.count = count;
		this.data = data;
	}
	public DataGridView(Object data) {
		super();
		this.data = data;
	}


}