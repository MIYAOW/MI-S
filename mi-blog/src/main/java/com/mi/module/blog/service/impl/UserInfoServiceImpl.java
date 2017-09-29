package com.mi.module.blog.service.impl;

import com.mi.module.blog.entity.UserInfo;
import com.mi.module.blog.mapper.UserInfoMapper;
import com.mi.module.blog.service.IUserInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 
 * 用户详细; InnoDB free: 11264 kB 服务实现类
 *
 * @author yesh
 *         (M.M)!
 *         Created by 2017-07-09.
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo selectByUserId(String uid) {
        return userInfoMapper.selectByUserId(uid);
    }
}
