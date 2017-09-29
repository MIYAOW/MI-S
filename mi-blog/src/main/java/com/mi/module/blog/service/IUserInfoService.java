package com.mi.module.blog.service;

import com.mi.module.blog.entity.UserInfo;
import com.baomidou.mybatisplus.service.IService;

/**
 *
 * 用户详细; InnoDB free: 11264 kB 服务接口
 *
 * @author yesh
 *         (M.M)!
 *         Created by 2017-07-09.
 */
public interface IUserInfoService extends IService<UserInfo> {

    /** 通过用户ID 获取用户详细 **/
    UserInfo selectByUserId(String uid);
}
