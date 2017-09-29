package com.mi.module.blog.service;

import com.mi.data.vo.Pager;
import com.mi.module.blog.entity.Friendlink;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 *
 * 友情链接; InnoDB free: 11264 kB 服务接口
 *
 * @author yesh
 *         (M.M)!
 *         Created by 2017-07-09.
 */
public interface IFriendlinkService extends IService<Friendlink> {

    /** 获取所有友情链接 **/
    List<Friendlink> selectAllList();


}
