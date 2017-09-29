package com.mi.module.admin.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mi.module.blog.entity.Tag;
import com.mi.module.blog.entity.Type;
import com.mi.module.blog.entity.UserInfo;
import com.mi.module.blog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 页面路由控制器 - 后台
 *
 * @author yesh
 *         (M.M)!
 *         Created by 2017/9/6.
 */
@Controller
public class AdminPageController {
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

    /******************** 博客后台 ********************/

    /**
     * 登录页面
     **/
    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }

    /**
     * 后台首页（文章）
     **/
    @RequestMapping("/admin/home")
    public String homePage() {
        return "redirect:/admin/index";
    }

    /**
     * 后台首页内容
     **/
    @RequestMapping("/admin/index")
    public String mainPage(Model model) {
        UserInfo userInfo = iUserInfoService.selectByUserId("1");
        model.addAttribute("userInfo", userInfo);
        return "admin/index";
    }


}
