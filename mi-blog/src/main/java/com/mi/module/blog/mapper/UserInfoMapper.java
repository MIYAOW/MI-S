package com.mi.module.blog.mapper;

import com.mi.module.blog.entity.UserInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 *
 * 用户详细; InnoDB free: 11264 kB Mapper 接口
 *
 * @author yesh
 *         (M.M)!
 *         Created by 2017-07-09.
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    UserInfo selectByUserId(String uid);
}