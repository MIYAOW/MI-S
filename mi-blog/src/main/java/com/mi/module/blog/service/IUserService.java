package com.mi.module.blog.service;

import com.mi.module.blog.entity.User;
import com.baomidou.mybatisplus.service.IService;

/**
 *
 * 博客用户; InnoDB free: 11264 kB 服务接口
 *
 * @author yesh
 *         (M.M)!
 *         Created by 2017-07-09.
 */
public interface IUserService extends IService<User> {
    /**
     * 根据用户名获取用户登录信息
     * @param username
     * @return
     */
    User selectByName(String username);

    /**
     * 获取当前用户
     * @return
     */
    User getCurrentUser();
}
