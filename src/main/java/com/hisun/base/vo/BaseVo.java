package com.hisun.base.vo;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * 
 *<p>类名称：BaseVo</p>
 *<p>类描述: </p>
 *<p>公司：湖南海数互联信息技术有限公司</p>
 *@创建人：Rocky
 *@创建时间：2014-12-19 下午3:12:57
 *@创建人联系方式：24212477@qq.com
 *@version
 */
public class BaseVo {
	
	protected String createUser;
	protected String createUserName;
	protected Date createDate;
	protected String createDateStr;
	protected String updateUser;
	protected String updateUserName;
	protected Date updateDate;
	protected String updateDateStr;
	
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
		if(this.createDate!=null){
			this.createDateStr = new DateTime(this.createDate).toString("yyyy-MM-dd HH:mm:ss");
		}else{
			this.createDateStr="";
		}
	}
	public String getCreateDateStr() {
		return createDateStr;
	}
	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public String getUpdateUserName() {
		return updateUserName;
	}
	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
		if(this.updateDate!=null){
			this.updateDateStr = new DateTime(this.updateDate).toString("yyyy-MM-dd HH:mm:ss");
		}else{
			this.updateDateStr="";
		}
	}
	public String getUpdateDateStr() {
		return updateDateStr;
	}
	public void setUpdateDateStr(String updateDateStr) {
		this.updateDateStr = updateDateStr;
	}
	
}
