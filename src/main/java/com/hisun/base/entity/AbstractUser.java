package com.hisun.base.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * <p>Title: AbstractUser.java</p>
 * <p>Description: 抽象公共User对象</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 湖南海数互联信息技术有限公司</p>
 *
 * @author Jason
 * @version v0.1
 * @email jason4j@qq.com
 * @date 2015-11-21 14:15
 */
@MappedSuperclass
public class AbstractUser extends TombstoneEntity{

    @Id//主键标识
    @GenericGenerator(name="generator",strategy="uuid.hex")//主键生成器名称及方式
    @GeneratedValue(generator="generator")//主键赋值方式由生成器来进行赋值
    @Column(name="id",nullable=false,unique=true,length=32)//该属性对应数据库列，是否为空，是否唯一等属性
    private String id;//主键

    @Column(name="email",length=256)
    private String email;

    @Column(name="user_name",length=32,unique=true)
    private String username;

    @Column(name = "sex",nullable = false,columnDefinition = "1")
    private Boolean sex = Boolean.TRUE;//性别 true为男

    @Column(name="real_name",length=64)
    private String realname;

    @Column(name="password",length=64)
    private String password;

    @Column(name="tel",length=20)
    private String tel;

    @Column(name="salt",length=64)
    private String salt;

    @Column(name="locked")
    private boolean locked = Boolean.FALSE;

    @Column(name="head_photo")
    private String headPhoto;

    @Column(name="specialty",length=64)
    private String specialty ;//特长

    @Column(name="positional",length=64)
    private String positional;//职称

    @Column(name="website",length=128)
    private String website;//个人主页

    @Column(name="about",length=255)
    private String about;//个人简介

    @Column(name="birthday",nullable=false,columnDefinition="DATE default '1988-01-01'")
    @Temporal(TemporalType.DATE)
    private Date birthday = new Date();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean getLocked() {
        return locked;
    }

    public String getHeadPhoto() {
        return headPhoto;
    }

    public void setHeadPhoto(String headPhoto) {
        this.headPhoto = headPhoto;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getPositional() {
        return positional;
    }

    public void setPositional(String positional) {
        this.positional = positional;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }
}
