package com.mi.module.blog.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * 文章标签关联; InnoDB free: 11264 kB 实体
 *
 * @author yesh
 *         (M.M)!
 *         Created by 2017-07-09.
 */
@TableName("blog_article_tag")
@Data
public class ArticleTag extends Model<ArticleTag> {

    private static final long serialVersionUID = 1L;

    /**
     * 文章主键
     */
    @TableId("article_id")
	private String articleId;
    /**
     * 标签主键
     */
	@TableField("tag_id")
	private String tagId;



	@Override
	protected Serializable pkVal() {
		return this.articleId;
	}

}
