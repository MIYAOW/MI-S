package com.mi.module.admin.controller;

import com.mi.common.model.BaseResult;
import com.mi.common.model.ReturnCode;
import com.mi.module.blog.entity.User;
import com.mi.module.blog.entity.UserInfo;
import com.mi.module.blog.service.IUserInfoService;
import com.mi.module.blog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * 后台博客用户; InnoDB free: 11264 kB 控制器
 *
 * @author yesh
 *         (M.M)!
 *         Created by 2017-07-09.
 */
@Controller
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IUserInfoService iUserInfoService;

    /**
     * 获取用户信息
     *
     * @param model
     * @return
     */
    @RequestMapping("/userinfo/get")
    public String getUserInfo(Model model) {
        UserInfo userInfo = iUserInfoService.selectByUserId("1");
        model.addAttribute("userInfo", userInfo);
        return "admin/partial/userinfo";
    }

    @RequestMapping("/userinfo/update")
    @ResponseBody
    public BaseResult updateInfo(UserInfo userInfo) {
        iUserInfoService.updateById(userInfo);
        return new BaseResult(null, ReturnCode.SUCCESS);
    }

    @RequestMapping("/userinfo/updatePassword")
    @ResponseBody
    public BaseResult updatePassword(String oldPassword, String newPassword, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (!oldPassword.equals(user.getUserPwd())) {
            return new BaseResult(null, ReturnCode.FAIL, "密码错误");
        }
        user.setUserPwd(oldPassword);
        iUserService.updateById(user);
        return new BaseResult(null, ReturnCode.SUCCESS);
    }

}
