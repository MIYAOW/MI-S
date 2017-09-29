package com.mi.data.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 类别视图
 * @author yesh
 *         (M.M)!
 *         Created by 2017/8/16.
 */
@Data
public class TypeVo implements Serializable {
    private String typeId;
    private String typeName; //分类名
    private String aliasName;//分类别名
    private Integer articleCount;//此分类下文章的数量
}
