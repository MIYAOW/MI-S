package com.mi.module.blog.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 友情链接; InnoDB free: 11264 kB 实体
 * @author yesh
 *         (M.M)!
 *         Created by 2017-07-09.
 */
@TableName("blog_friendlink")
@Data
public class Friendlink extends Model<Friendlink> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("flink_id")
	private String flinkId;
    /**
     * 站点名称
     */
	@TableField("site_name")
	private String siteName;
    /**
     * 站点地址
     */
	@TableField("site_url")
	private String siteUrl;
    /**
     * 站点作者
     */
	@TableField("site_author")
	private String siteAuthor;
    /**
     * 站点描述
     */
	@TableField("site_desc")
	private String siteDesc;
    /**
     * 排序
     */
	private Integer sort;
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


	@Override
	protected Serializable pkVal() {
        return null;
    }
}
