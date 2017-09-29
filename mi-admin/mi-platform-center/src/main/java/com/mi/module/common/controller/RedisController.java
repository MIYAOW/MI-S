package com.mi.module.common.controller;

import com.mi.common.annotation.Dev;
import com.mi.config.redis.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Redis 控制器
 *
 * @author yesh
 *         (M.M)!
 *         Created by 2017-06-28.
 */
@Api(description = "Redis 测试 控制器")
@Dev
@RestController
@RequestMapping("/redis")
public class RedisController {


    @ApiOperation(value = "接口简介",notes = "接口详细描述")
    @ApiImplicitParam(name = "name",required = true,paramType = "query" ,dataType = "String")
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(@RequestParam(value = "name",required = false) String name) {
        RedisUtil.set("name:",name);
        return RedisUtil.get("name:").toString();
    }


}
