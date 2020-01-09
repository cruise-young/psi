package com.hy.psicrm.sys.web;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.psicrm.common.DataGridView;
import com.hy.psicrm.sys.entity.OperateInfo;
import com.hy.psicrm.sys.service.IOperateInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

}

