package com.mi.module.system.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 *
 * 操作日志; InnoDB free: 4096 kB 实体
 *
 * @author yesh
 *         (M.M)!
 *         Created by 2017-06-28.
 */
@TableName("mi_sys_log")
public class MiSysLog extends Model<MiSysLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("log_id")
	private String logId;
    /**
     * 请求路径
     */
	private String url;
    /**
     * 请求类型
     */
	@TableField("http_method")
	private String httpMethod;
    /**
     * IP地址
     */
	private String ip;
    /**
     * 请求方法类
     */
	@TableField("class_method")
	private String classMethod;
    /**
     * 请求参数
     */
	private String args;
    /**
     * 操作者
     */
	@TableField("op_user")
	private String opUser;
    /**
     * 执行时间(毫秒)
     */
	@TableField("spend_time")
	private Integer spendTime;
    /**
     * 返回结果
     */
	private String result;


	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getClassMethod() {
		return classMethod;
	}

	public void setClassMethod(String classMethod) {
		this.classMethod = classMethod;
	}

	public String getArgs() {
		return args;
	}

	public void setArgs(String args) {
		this.args = args;
	}

	public String getOpUser() {
		return opUser;
	}

	public void setOpUser(String opUser) {
		this.opUser = opUser;
	}

	public Integer getSpendTime() {
		return spendTime;
	}

	public void setSpendTime(Integer spendTime) {
		this.spendTime = spendTime;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	protected Serializable pkVal() {
		return this.logId;
	}

}
