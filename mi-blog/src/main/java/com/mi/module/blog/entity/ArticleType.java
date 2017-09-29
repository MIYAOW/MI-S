package com.mi.module.blog.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * 文章分类关联; InnoDB free: 11264 kB 实体
 *
 * @author yesh
 *         (M.M)!
 *         Created by 2017-07-09.
 */
@TableName("blog_article_type")
@Data
public class ArticleType extends Model<ArticleType> {

    private static final long serialVersionUID = 1L;

    /**
     * 文章主键
     */
    @TableId("article_id")
	private String articleId;
    /**
     * 标签主键
     */
	@TableField("type_id")
	private String typeId;

	@Override
	protected Serializable pkVal() {
		return this.articleId;
	}

}
