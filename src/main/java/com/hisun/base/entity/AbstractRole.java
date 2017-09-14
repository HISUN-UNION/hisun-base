package com.hisun.base.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * <p>类名称:AbstractRole</p>
 * <p>类描述:</p>
 * <p>公司:湖南海数互联信息技术有限公司</p>
 *
 * @创建者:lyk
 * @创建人:15/11/19上午10:29
 * @创建人联系方式:liyk_gz@30wish.net
 */
@MappedSuperclass
public class AbstractRole extends TombstoneEntity {

    @Id//主键标识
    @GenericGenerator(name="generator",strategy="uuid.hex")//主键生成器名称及方式
    @GeneratedValue(generator="generator")//主键赋值方式由生成器来进行赋值
    @Column(name="id",nullable=false,unique=true,length=32)//该属性对应数据库列，是否为空，是否唯一等属性
    protected String id;//主键

    @Column(name="role_name",length=64)
    protected String roleName;//角色名

    @Column(name="sort",length=24)
    protected int sort;//排序号

    @Column(name="role_code",length=32)
    protected String roleCode;//角色字符串

    @Column(name="description",length=255)
    protected String description;//角色描述

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
