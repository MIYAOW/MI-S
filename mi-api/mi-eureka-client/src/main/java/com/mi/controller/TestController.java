package com.mi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Swagger 控制器案例模版
 *
 * @author yesh
 *         (M.M)!
 *         Created by 2017/5/7.
 */
@Api(description = "测试用例控制器")
@Controller
@RequestMapping("/swagger")
public class TestController {

    @ApiOperation(value = "TEST案例接口简介(POST)", notes = "接口详细描述")
    @RequestMapping(value = "/test/post", method = RequestMethod.POST)
    @ResponseBody
    public UserRes helloPOST(@RequestBody User user) {
        UserRes u = new UserRes();
        u.setId(user.getId());
        return u;
    }

    @ApiOperation(value = "TEST案例接口简介(GET)", notes = "接口详细描述")
    @RequestMapping(value = "/test/get", method = RequestMethod.GET)
    @ResponseBody
    public UserRes helloGET(@RequestBody User user) {
        UserRes u = new UserRes();
        u.setId(user.getId());
        return u;
    }
}

@ApiModel(value = "User//参数实体")
class User {
    @ApiModelProperty(value = "主键")
    private int id; //主键
    @ApiModelProperty(value = "姓名")
    private int name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}

@ApiModel(value = "UserRes//返回实体")
class UserRes {

    @ApiModelProperty(value = "返回主键")
    private int id;
    @ApiModelProperty(value = "返回姓名")
    private int name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

}