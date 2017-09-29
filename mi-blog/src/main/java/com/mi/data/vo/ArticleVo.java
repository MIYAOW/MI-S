package com.mi.data.vo;


import com.baomidou.mybatisplus.annotations.TableId;
import com.mi.module.blog.entity.Tag;
import com.mi.module.blog.entity.Type;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 自定义文章类
 * @author yesh
 *         (M.M)!
 *         Created by 2017/7/9.
 */
@Data
public class ArticleVo implements Serializable {

    /**
     * 主键
     */
    private String articleId;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 简介
     */
    private String description;
    /**
     * 状态 0：正常  1：不可用
     */
    private Integer status;
    /**
     * 状态 0：原创  1：装载
     */
    private Integer classType;
    /**
     * 作者
     */
    private String author;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 访问量
     */
    private Integer lookCount;

    private List<Type> typeList; //文章类别
    private List<Tag> tagList;   //标签列表


}
