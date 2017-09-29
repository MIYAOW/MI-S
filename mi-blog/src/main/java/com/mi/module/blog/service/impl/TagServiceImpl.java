package com.mi.module.blog.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mi.data.vo.Pager;
import com.mi.module.blog.entity.Tag;
import com.mi.module.blog.entity.Type;
import com.mi.module.blog.mapper.TagMapper;
import com.mi.module.blog.service.ITagService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * 文章标签; InnoDB free: 11264 kB 服务实现类
 *
 * @author yesh
 *         (M.M)!
 *         Created by 2017-07-09.
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

    @Resource
    private TagMapper tagMapper;

    @Override
    public void initPage(Pager pager) {
        EntityWrapper<Tag> ew = new EntityWrapper<>();
        int count = tagMapper.selectCount(ew);
        pager.setTotalCount(count);
    }

    @Override
    public List<Tag> load(Pager pager, String param) {
        pager.setStart(pager.getStart());
        return tagMapper.load(pager,param);
    }

    @Override
    public boolean checkExist(Tag tag) {
        int count = tagMapper.checkExist(tag);
        if (count > 0){
            return true;
        }
        return false;
    }

}
