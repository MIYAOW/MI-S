package com.mi.module.blog.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mi.data.vo.Pager;
import com.mi.module.blog.entity.Article;
import com.mi.module.blog.entity.Friendlink;
import com.mi.module.blog.mapper.FriendlinkMapper;
import com.mi.module.blog.service.IFriendlinkService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * 友情链接; InnoDB free: 11264 kB 服务实现类
 *
 * @author yesh
 *         (M.M)!
 *         Created by 2017-07-09.
 */
@Service
public class FriendlinkServiceImpl extends ServiceImpl<FriendlinkMapper, Friendlink> implements IFriendlinkService {

    @Resource
    private FriendlinkMapper friendlinkMapper;

    @Override
    public List<Friendlink> selectAllList() {
        return friendlinkMapper.selectAllList();
    }

}
