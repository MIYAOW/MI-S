package com.mi.module.admin.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.mi.common.model.BaseResult;
import com.mi.common.model.ReturnCode;
import com.mi.common.util.IDUntil;
import com.mi.module.blog.entity.Friendlink;
import com.mi.module.blog.service.IFriendlinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


/**
 * 友情链接管理控制器
 * @author yesh
 *         (M.M)!
 *         Created by 2017/7/15.
 */
@Controller
@RequestMapping("/admin/flink")
public class AdminFlinkController {

    @Autowired
    private IFriendlinkService iFriendlinkService;

    /**
     * 跳转到管理链接页面
     * @return
     */
    @RequestMapping("/mgr")
    public String flinkPage() {
        return "admin/flink/flinkList";
    }

    /**
     * 加载列表（分页）
     * @return
     */
    @RequestMapping("/list")
    public String selectPage(Page pages, String param, Model model) {
        Page<Friendlink> page;
        EntityWrapper<Friendlink> ex = new EntityWrapper<>();
        if (StringUtils.checkValNotNull(param)) {
            ex.where("site_name like concat('%',{0},'%')", param);
        }
        page = iFriendlinkService.selectPage(new Page(pages.getCurrent(), pages.getSize()), ex);
        model.addAttribute("page", page);
        return "admin/flink/flinkTable";
    }

    /**
     * 添加跳转
     * @return
     */
    @RequestMapping("/add")
    public String addPage() {
        return "admin/flink/flinkAdd";
    }


    /**
     * 保存友链
     * @param flink
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public BaseResult save(Friendlink flink){
        BaseResult br = new BaseResult();
        flink.setCreateTime(new Date());
        flink.setFlinkId(IDUntil.getRandomId(5));
        boolean  result = iFriendlinkService.insert(flink);
        if (result){
            br.setMsg("添加成功");
            br.setCode(ReturnCode.SUCCESS);
            return br;
        }
        br.setMsg("添加失败");
        br.setCode(ReturnCode.FAIL);
        return br;
    }

    @RequestMapping("/edit")
    public String editPage(String id, Model model){
        Friendlink flink = iFriendlinkService.selectById(id);
        model.addAttribute("flink",flink);
        return "admin/flink/flinkEdit";
    }
    /**
     * 更新友链
     * @param flink
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public BaseResult update(Friendlink flink) {
        BaseResult br = new BaseResult();
        Friendlink paramFlink = new Friendlink();
        paramFlink.setFlinkId(flink.getFlinkId());
        paramFlink.setSiteName(flink.getSiteName());
        paramFlink.setSiteDesc(flink.getSiteDesc());
        paramFlink.setSiteUrl(flink.getSiteUrl());
        paramFlink.setSiteAuthor(flink.getSiteAuthor());
        paramFlink.setSort(flink.getSort());
        paramFlink.setUpdateTime(new Date());
        boolean  result = iFriendlinkService.updateById(paramFlink);
        if (result){
            br.setMsg("修改成功");
            br.setCode(ReturnCode.SUCCESS);
            return br;
        }
        br.setMsg("修改失败");
        br.setCode(ReturnCode.FAIL);
        return br;
    }

    /**
     * 删除友链
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public BaseResult delete(String id){
        BaseResult br = new BaseResult();
        boolean result = iFriendlinkService.deleteById(id);
        if (result){
            br.setMsg("删除成功"+id);
            br.setCode(ReturnCode.SUCCESS);
            return br;
        }
        br.setMsg("删除失败");
        br.setCode(ReturnCode.FAIL);

        return  br;
    }
}
