package com.mi.module.blog.service;

import com.mi.data.vo.ArticleVo;
import com.mi.data.vo.Pager;
import com.mi.data.vo.TypeVo;
import com.mi.module.blog.entity.Type;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 *
 * 文章类型; InnoDB free: 11264 kB 服务接口
 *
 * @author yesh
 *         (M.M)!
 *         Created by 2017-07-09.
 */
public interface ITypeService extends IService<Type> {

    List<Type> load(Pager pager, String param);

    boolean checkExist(Type type);

    /**
     * 初始化分类信息
     * @return
     */
    List<TypeVo> initTypeList();

    List<ArticleVo> selectArticleByType(Pager pager, String typeId);

    boolean deleteType(String typeId);
}
