package com.mi.module.blog.mapper;

import com.mi.data.vo.ArticleVo;
import com.mi.data.vo.Pager;
import com.mi.data.vo.TypeVo;
import com.mi.module.blog.entity.Type;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * 文章类型; InnoDB free: 11264 kB Mapper 接口
 *
 * @author yesh
 *         (M.M)!
 *         Created by 2017-07-09.
 */
public interface TypeMapper extends BaseMapper<Type> {

    List<Type> load(@Param("pager") Pager pager, @Param("param") String param);

    int checkExist(Type type);

    List<TypeVo> initTypeList();

}