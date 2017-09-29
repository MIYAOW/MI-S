package com.mi.module.system.controller;

import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mi.module.system.service.IMiSysLogService;
import com.mi.module.system.entity.MiSysLog;

import java.util.Date;
import java.util.List;


/**
 *
 * 操作日志; InnoDB free: 4096 kB 控制器
 *
 * @author yesh
 *         (M.M)!
 *         Created by 2017-06-28.
 */
@RestController
@RequestMapping("/system/miSysLog")
public class MiSysLogController {

    @Autowired
    IMiSysLogService iMiSysLogService;

    /** selectlist **/
    @RequestMapping(value = "selectPage")
    public List<MiSysLog> selectPage(){
        Page page = iMiSysLogService.selectPage(new Page<MiSysLog>());
        List<MiSysLog> list =  page.getRecords();
        return list;
    }


    /** selectById **/
    @RequestMapping(value = "selectById")
    public MiSysLog selectById(@RequestParam String id){
        MiSysLog entity = iMiSysLogService.selectById(id);
        return entity;
    }

    /** insert **/
    @RequestMapping(value = "insert")
    public void insert(){
        MiSysLog entity;
        entity = new MiSysLog();
        entity.setResult("test"+new Date().getTime());
        iMiSysLogService.insert(entity);
    }

    /** delete **/
    @RequestMapping(value = "delete")
    public void delete(@RequestParam String id){
        iMiSysLogService.deleteById(id);
    }

    /** update **/
    @RequestMapping(value = "update")
    public void update(){

    }

}
