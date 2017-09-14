/**
 * 
 */
package com.hisun.base.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * 
 *<p>类名称：BaseEntity</p>
 *<p>类描述: 定义了一些实体通用属性。业务实体通过继承此基类实体，获得一些通用属性项。</p>
 *<p>公司：湖南海数互联信息技术有限公司</p>
 *@创建人：Rocky
 *@创建时间：2014-10-17 下午2:46:09
 *@创建人联系方式：24212477@qq.com
 *@version
 */
@MappedSuperclass
public class BaseEntity{

    @Column(name="create_user_id")
	protected String createUserId;
	@Column(name="create_user_name",length=32)
	protected String createUserName;
	@Column(name="create_date")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createDate;
    @Column(name="update_user_id")
	protected String updateUserId;
	@Column(name="update_user_name",length=32)
	protected String updateUserName;
	@Column(name="update_date")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date updateDate;

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public String getUpdateUserName() {
		return updateUserName;
	}
	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
}

