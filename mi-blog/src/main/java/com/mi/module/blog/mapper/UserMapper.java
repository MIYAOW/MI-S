package com.mi.module.blog.mapper;

import com.mi.module.blog.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * 博客用户; InnoDB free: 11264 kB Mapper 接口
 *
 * @author yesh
 *         (M.M)!
 *         Created by 2017-07-09.
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    User selectByName(String username);
}