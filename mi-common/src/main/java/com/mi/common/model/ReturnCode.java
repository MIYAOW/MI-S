package com.mi.common.model;

/**
 * 结果编码枚举
 * @author yesh
 *         (M.M)!
 *         Created by 2017/7/5.
 */
public enum ReturnCode {

    SUCCESS("成功",200),
    FAIL("失败",400),
    UNAUTHORIZED("未认证",401),
    NOT_FOUND("接口不存在",404),
    INTERNAL_SERVER_ERROR("服务器内部错误",500);

    private String name;
    private int code;

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }


    ReturnCode(String name,int code) {
        this.name = name;
        this.code = code;
    }


}
