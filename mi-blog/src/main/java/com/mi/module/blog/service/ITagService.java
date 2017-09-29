package com.mi.module.blog.service;

import com.mi.data.vo.Pager;
import com.mi.module.blog.entity.Tag;
import com.baomidou.mybatisplus.service.IService;
import com.mi.module.blog.entity.Type;

import java.util.List;

/**
 *
 * 文章标签; InnoDB free: 11264 kB 服务接口
 *
 * @author yesh
 *         (M.M)!
 *         Created by 2017-07-09.
 */
public interface ITagService extends IService<Tag> {

    void initPage(Pager pager);

    List<Tag> load(Pager pager, String param);

    boolean checkExist(Tag tag);
}
