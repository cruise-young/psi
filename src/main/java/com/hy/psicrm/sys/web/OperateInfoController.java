package com.hy.psicrm.sys.web;


import cn.hutool.Hutool;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.psicrm.common.DataGridView;
import com.hy.psicrm.sys.entity.OperateInfo;
import com.hy.psicrm.sys.service.IOperateInfoService;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CruiseYoung
 * @since 2020-01-07
 */
@RestController
@RequestMapping("sys")
public class OperateInfoController {
    @Autowired
    private IOperateInfoService operateInfoService;

    @RequestMapping("queryOperateInfo")
    public DataGridView queryOperateInfo(OperateInfo operateInfo) {
        IPage<OperateInfo> page=new Page<>(1, 10);
        QueryWrapper<OperateInfo> qw = new QueryWrapper<>();
        qw.like(StringUtils.isNotBlank(operateInfo.getLoginName()),"login_name", operateInfo.getLoginName());
        qw.orderByDesc("login_time");
        operateInfoService.page(page, qw);
        return new DataGridView(page.getTotal(), page.getRecords());
    }
    /**
     * 批量删除
     */
    @RequestMapping("deleteByIds")
    public JSONObject deleteByIds(Integer[] ids) {
        JSONObject result = new JSONObject();
        try {
            operateInfoService.removeByIds(Arrays.asList(ids));
            result.put("code", 200);
            result.put("msg","删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", 500);
            result.put("msg","删除失败");
        }
        return result;
    }
}

