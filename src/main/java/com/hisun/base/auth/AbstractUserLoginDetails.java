package com.hisun.base.auth;

import java.io.Serializable;

/**
 * <p> Title : net.wish30.base.entity.AbstrsctUserLoginDetails</p>
 * <p> Description: 抽象UserLoginDetails</p>
 * <p> Copyright: Copyright (c) 2016</p>
 * <p> Company: 湖南海数互联信息技术有限公司</p>
 *
 * @author Jason
 * @email jason4j@qq.com
 * @date 2016年03月15 11:01
 */
public abstract class AbstractUserLoginDetails implements Serializable {

    private String userid;
    private String password;
    private String salt;
    private String email;
    private String username;
    private String realname;
    private String tel;

    private String tenantId;
    private String tenantName;
    private String property;
    private String headPhoto;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getHeadPhoto() {
        return headPhoto;
    }

    public void setHeadPhoto(String headPhoto) {
        this.headPhoto = headPhoto;
    }
}
