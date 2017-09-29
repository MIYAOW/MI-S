package com.mi.config.druid;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;

/**
 * 数据库监控过滤器
 * @author yesh
 *         (M.M)!
 *         Created by 2017/6/16.
 */
@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*",
		initParams = {
				@WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
		}
)
public class DruidStatFilter extends WebStatFilter {

}
