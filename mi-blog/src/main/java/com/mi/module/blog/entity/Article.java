package com.mi.module.blog.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * 文章; InnoDB free: 11264 kB 实体
 *
 * @author yesh
 *         (M.M)!
 *         Created by 2017-07-09.
 */
@TableName("blog_article")
@Data
public class Article extends Model<Article> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("article_id")
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
     * 状态 0：原创  1：转载
     */
    private Integer classType;

    /**
     * 作者
     */
	private String author;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 修改时间
     */
	@TableField("update_time")
	private Date updateTime;
    /**
     * 访问量
     */
	@TableField("look_count")
	private Integer lookCount;



	@Override
	protected Serializable pkVal() {
		return this.articleId;
	}

}
