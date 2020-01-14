package com.hy.psicrm.sys.web;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.psicrm.common.DataGridView;
import com.hy.psicrm.common.ResultObj;
import com.hy.psicrm.sys.entity.Notice;
import com.hy.psicrm.sys.entity.User;
import com.hy.psicrm.sys.service.INoticeService;
import com.hy.psicrm.sys.vo.NoticeVo;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

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
	public DataGridView loadAllNotice(NoticeVo noticeVo) {
		IPage<Notice> page=new Page<>(1, 10);
		QueryWrapper<Notice> queryWrapper=new QueryWrapper<>();
		queryWrapper.like(StringUtils.isNotBlank(noticeVo.getTitle()), "title", noticeVo.getTitle());
		queryWrapper.like(StringUtils.isNotBlank(noticeVo.getCreateUser()), "create_user", noticeVo.getCreateUser());
		queryWrapper.ge(noticeVo.getStartTime()!=null, "create_time", noticeVo.getStartTime());
		queryWrapper.le(noticeVo.getEndTime()!=null, "create_time", noticeVo.getEndTime());
		queryWrapper.orderByDesc("create_time");
		noticeService.page(page, queryWrapper);
		return new DataGridView(page.getTotal(), page.getRecords());
	}
	/**
	 * 批量删除
	 */
	@RequestMapping("deleteByIds")
	public ResultObj deleteByIds(Integer[] ids) {
		try {
			noticeService.removeByIds(Arrays.asList(ids));
			return ResultObj.删除成功;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.删除失败;
		}
	}
	/**
	 * 添加公告
	 */
	@RequestMapping("addNotice")
	public ResultObj addNotice(NoticeVo noticeVo, HttpServletRequest req) {
		try {
			noticeVo.setCreateTime(new Date());
			User user = (User) req.getSession().getAttribute("user");
			noticeVo.setCreateUser(user.getUserName());
			this.noticeService.save(noticeVo);
			return ResultObj.添加成功;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.添加失败;
		}
	}
	/**
	 * 修改
	 */
	@RequestMapping("editNotice")
	public ResultObj updateNotice(NoticeVo noticeVo) {
		try {
			this.noticeService.updateById(noticeVo);
			return ResultObj.更新成功;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.更新失败;
		}
	}

}

