package com.hy.psicrm.sys.web;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.psicrm.common.DataGridView;
import com.hy.psicrm.sys.entity.Notice;
import com.hy.psicrm.sys.service.INoticeService;
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
 * @since 2019-12-27
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {
	@Autowired
	private INoticeService noticeService;


	/**
	 * 查询
	 */
	@RequestMapping("queryNotice")
	public DataGridView loadAllNotice(Notice notice) {
		IPage<Notice> page=new Page<>(1, 10);
		QueryWrapper<Notice> queryWrapper=new QueryWrapper<>();
		queryWrapper.like(StringUtils.isNotBlank(notice.getTitle()), "title", notice.getTitle());
		queryWrapper.like(StringUtils.isNotBlank(notice.getCreateUser()), "create_user", notice.getCreateUser());
//		queryWrapper.ge(notice.getStartTime()!=null, "createtime", notice.getStartTime());
//		queryWrapper.le(notice.getEndTime()!=null, "createtime", notice.getEndTime());
		queryWrapper.orderByDesc("create_time");
		noticeService.page(page, queryWrapper);
		return new DataGridView(page.getTotal(), page.getRecords());
	}

}

