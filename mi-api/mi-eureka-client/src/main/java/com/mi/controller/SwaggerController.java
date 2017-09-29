package com.mi.controller;

import io.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

/**
 * Swagger 控制器案例模版
 * @author yesh
 *         (M.M)!
 *         Created by 2017/5/7.
 */
@Api(description = "Swagger模版控制器")
@RestController
@RequestMapping("/swagger")
public class SwaggerController {
    private static final Logger log = Logger.getLogger(SwaggerController.class);

    @ApiOperation(value = "Swagger2案例接口（Get）", notes = "接口案例详细描述")
    @ApiImplicitParam(name = "name",required = true,paramType = "query" ,dataType = "String")
    @RequestMapping(value = "hello" ,method = RequestMethod.GET)
    public String hello(@RequestParam(value = "name",required = false) String name){
        log.info("Hello Swagger : my name is" + name);
        return "Hello Swagger : my name is "+ name;
    }

}
