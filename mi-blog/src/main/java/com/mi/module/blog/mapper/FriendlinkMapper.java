package com.mi.module.blog.mapper;

import com.mi.data.vo.Pager;
import com.mi.module.blog.entity.Friendlink;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * 友情链接; InnoDB free: 11264 kB Mapper 接口
 *
 * @author yesh
 *         (M.M)!
 *         Created by 2017-07-09.
 */
public interface FriendlinkMapper extends BaseMapper<Friendlink> {

    List<Friendlink> selectAllList();

}