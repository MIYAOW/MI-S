package com.mi.module.blog.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.mi.data.vo.ArticleVo;
import com.mi.data.vo.TypeVo;
import com.mi.module.blog.entity.Article;
import com.mi.module.blog.entity.Friendlink;
import com.mi.module.blog.entity.Tag;
import com.mi.module.blog.entity.UserInfo;
import com.mi.module.blog.service.*;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

/**
 * 菜单控制器
 *
 * @author yesh
 *         (M.M)!
 *         Created by 2017/9/8.
 */
@Controller
@Log4j
public class MenuController {
    @Autowired
    private IUserInfoService iUserInfoService;
    @Autowired
    private IFriendlinkService iFriendlinkService;
    @Autowired
    private IArticleService iArticleService;
    @Autowired
    private ITagService iTagService;
    @Autowired
    private ITypeService iTypeService;

    /**
     * 主页
     **/
    @RequestMapping("/")
    public String home(Model model) {
        //后期参数定义 做成多博客系统
        UserInfo uInfo = iUserInfoService.selectByUserId("1");
        model.addAttribute("userInfo", uInfo);

        //友情链接
        List<Friendlink> fLinkList = iFriendlinkService.selectAllList();
        model.addAttribute("fLinkList", fLinkList);

        //类别
        List<TypeVo> typeList = iTypeService.initTypeList();
        model.addAttribute("typeList", typeList);

        //获取归档列表
        List<Map> archiveList = iArticleService.selectArticleArchiveList();
        model.addAttribute("archiveList", archiveList);

        //标签云
        List<Tag> tagList = iTagService.selectList(null);
        model.addAttribute("tagList", tagList);

        EntityWrapper<Article> exA = new EntityWrapper<>();
        Article article = new Article();
        article.setStatus(1);
        exA.setEntity(article);
        model.addAttribute("articleCount", iArticleService.selectCount(exA));
        model.addAttribute("tagCount", iTagService.selectCount(null));

        return "blog/index";
    }

    /**
     * 加载分页列表数据
     *
     * @param model
     * @return
     */
    @RequestMapping("/article/list")
    public String selectArticleList(Page pages, Model model) {
        Page<ArticleVo> page;
        page = iArticleService.selectArticleList(new Page(pages.getCurrent(), 5));
        model.addAttribute("page", page);

        return "blog/main";
    }

    /**
     * 时间归档
     **/
    @RequestMapping("/archive")
    public String selectArticleByArchive(Page pages, Model model) {
        Page<ArticleVo> page;
        page = iArticleService.selectArticleByArchive(new Page(pages.getCurrent(), 5));
        //按照时间对象分离时间轴
        model.addAttribute("page", page);
        return "blog/archive";
    }


    /**
     * 关于作者
     **/
    @RequestMapping("/about/me")
    public String aboutMe(Model model) {
        model.addAttribute("vt", 1000);
        return "blog/aboutMe";
    }


    /**
     * 全局搜索
     *
     * @param keyword 关键字
     * @param model
     * @return
     */
    @RequestMapping("/article/content/search")
    public String search(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("keyword", keyword);
        List<Article> articleList = iArticleService.selectArticleListByKeywords(paramMap);
        model.addAttribute("articleList", articleList);
        return "blog/part/search-info";
    }

}
