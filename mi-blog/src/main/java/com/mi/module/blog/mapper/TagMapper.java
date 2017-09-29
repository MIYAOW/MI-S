package com.mi.module.blog.mapper;

import com.mi.data.vo.Pager;
import com.mi.module.blog.entity.Tag;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mi.module.blog.entity.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * 文章标签; InnoDB free: 11264 kB Mapper 接口
 *
 * @author yesh
 *         (M.M)!
 *         Created by 2017-07-09.
 */
public interface TagMapper extends BaseMapper<Tag> {

    List<Tag> load(@Param("pager") Pager pager,@Param("param") String param);

    int checkExist(Tag tag);
}