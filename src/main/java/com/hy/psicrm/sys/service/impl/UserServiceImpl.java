package com.hy.psicrm.sys.service.impl;

import com.hy.psicrm.sys.entity.User;
import com.hy.psicrm.sys.mapper.UserMapper;
import com.hy.psicrm.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CruiseYoung
 * @since 2019-12-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
