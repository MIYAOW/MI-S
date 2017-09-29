package com.mi.module.admin.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.mi.common.model.BaseResult;
import com.mi.common.model.ReturnCode;
import com.mi.common.util.IDUntil;
import com.mi.data.vo.Pager;
import com.mi.module.blog.entity.*;
import com.mi.module.blog.service.IArticleTagService;
import com.mi.module.blog.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * 标签管理控制器
 * @author yesh
 *         (M.M)!
 *         Created by 2017/7/15.
 */
@Controller
@RequestMapping("/admin/tag")
public class AdminTagController {

    @Autowired
    private ITagService iTagService;

    @Autowired
    private IArticleTagService iArticleTagService;

    /**
     * 跳转标签展示页面
     * @return
     */
    @RequestMapping("/mgr")
    public String tagPage() {
        return "admin/tag/tagList";
    }


    /**
     * 分页加载标签
     * @param pages 分页对象
     * @param param  搜索条件
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String selectPage(Page pages, String param, Model model) {
        Page<Tag> page;
        EntityWrapper<Tag> ex = new EntityWrapper<>();
        if (StringUtils.checkValNotNull(param)) {
            ex.where("tag_name like concat('%',{0},'%')", param);
        }
        ex.orderBy("sort", true);
        ex.orderBy("create_time", true);
        page = iTagService.selectPage(new Page(pages.getCurrent(), pages.getSize()), ex);
        model.addAttribute("page", page);
        return "admin/tag/tagTable";
    }

    /**
     * 跳转到添加页面
     * @return
     */
    @RequestMapping("/add")
    public String addPage(){
        return "admin/tag/tagAdd";
    }


    /**
     * 添加保存标签
     * @param tag 分类信息对象
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public BaseResult save(Tag tag){
        if (tag.getSort()==null){
            tag.setSort(0);
        }
        //检查数据是否存在
        boolean result =  iTagService.checkExist(tag);
        tag.setTagId(IDUntil.getRandomId(5));
        tag.setCreateTime(new Date());
        if (result){
            return new BaseResult(null, ReturnCode.FAIL,"已存在标签");
        }else if (iTagService.insert(tag)){
            return new BaseResult(null, ReturnCode.SUCCESS);
        }else {
            return new BaseResult(null, ReturnCode.FAIL,"添加标签失败");
        }

    }

    /**
     * 跳转修改页面
     * @param tagId 分类id
     * @param model
     * @return
     */
    @RequestMapping("/edit")
    public String editPage(String tagId, Model model){
        Tag tag = iTagService.selectById(tagId);
        model.addAttribute("tag",tag);
        return "admin/tag/tagEdit";
    }

    /**
     * 更新分类信息
     * @param tag 分类信息对象
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public BaseResult update(Tag tag){
        if (tag.getSort()==null){
            tag.setSort(0);
        }
        //检查数据是否存在
        boolean result =  iTagService.checkExist(tag);
        if (result){
            return new BaseResult(null, ReturnCode.FAIL,"已存在标签");
        }else if (iTagService.updateById(tag)){
            return new BaseResult(null, ReturnCode.SUCCESS);
        }else {
            return new BaseResult(null, ReturnCode.FAIL,"修改标签失败");
        }

    }

    /**
     * 删除之前查询是否存在文章
     * @param tagId
     * @return
     */
    @RequestMapping("/delCheckExist")
    @ResponseBody
    public BaseResult delCheckExist(String tagId){
        EntityWrapper<ArticleTag> ew = new EntityWrapper<>();
        ArticleTag articleTag =new ArticleTag();
        articleTag.setTagId(tagId);
        ew.setEntity(articleTag);

        int count = iArticleTagService.selectCount(ew);
        if (count > 0){
            return new BaseResult(null, ReturnCode.FAIL,"当前分类已存在文章");
        }
        return new BaseResult(null, ReturnCode.SUCCESS);
    }

    /**
     * 删除
     *
     * @param typeId
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public BaseResult delete(String typeId){
        if(iTagService.deleteById(typeId)){
            return new BaseResult(null, ReturnCode.SUCCESS);
        }
        return new BaseResult(null, ReturnCode.FAIL);

    }


}
