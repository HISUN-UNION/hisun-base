package com.hisun.base.auth.vo;

/**
 * <p>类名称:PasswordSecurity</p>
 * <p>类描述:</p>
 * <p>公司:湖南海数互联信息技术有限公司</p>
 *
 * @创建者:lyk
 * @创建人:15/11/23上午10:06
 * @创建人联系方式:liyk_gz@30wish.net
 */
public class PasswordSecurity {

    private String password;

    private String salt;

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
}
