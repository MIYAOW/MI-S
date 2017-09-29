package com.mi.common.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 统一返回结果类
 * @author yesh
 *         (M.M)!
 *         Created by 2017/7/5.
 */
public class BaseResult {

    @Getter@Setter
    private String msg;//描述信息
    @Getter
    private Integer code; //状态
    @Getter@Setter
    private Object data; //附加数据

    public void setCode(ReturnCode rc) {
        this.code = rc.getCode();
    }
    public BaseResult(){
        super();
        this.code = null;
        this.data = null;
        this.msg = null;
    }
    //simplified portability data structure
    public BaseResult(Object obj,ReturnCode rc){
        super();
        this.data = obj;
        this.code = rc.getCode();
        this.msg = rc.getName();
    }

    public BaseResult(Object obj,ReturnCode rc,String msg){
        super();
        this.data = obj;
        this.code = rc.getCode();
        this.msg = msg;
    }



}
