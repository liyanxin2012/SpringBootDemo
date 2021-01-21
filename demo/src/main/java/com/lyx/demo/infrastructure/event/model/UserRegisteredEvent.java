package com.lyx.demo.infrastructure.event.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * 已注册用户事件
 *
 * @author Ryan
 */
public class UserRegisteredEvent implements Serializable {

	/**
	 * 用户编号（UUID）
	 */
	@NotNull
	@Size(max = 64)
	private String userId;

	/**
	 * 用户名（必须全局唯一）
	 */
	@NotNull
	@Size(max = 32)
	private String userName;

	/**
	 * 城市编号
	 */
	@Size(max = 6)
	private String cityCode;

	/**
	 * 状态
	 */
	@NotNull
	@Size(max = 1)
	private String status;

	/**
	 * 创建时间
	 */
	@NotNull
	private Date createTime;

	/**
	 * 更新时间
	 */
	@NotNull
	private Date updateTime;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
