package com.hisun.base.auth;

import org.apache.shiro.authc.UsernamePasswordToken;

public class KaptchaUsernamePasswordToken extends UsernamePasswordToken {

	private static final long serialVersionUID = 1L;

	// 验证码字符串
	private String captcha;

    // 判断前后台登录
    private boolean adminLogin;

	public KaptchaUsernamePasswordToken(String username, String password,
			boolean rememberMe, String captcha, boolean adminLogin) {
		super(username, password, rememberMe);
		this.captcha = captcha;
        this.adminLogin = adminLogin;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

    public boolean isAdminLogin() {
        return adminLogin;
    }

    public void setAdminLogin(boolean adminLogin) {
        this.adminLogin = adminLogin;
    }
}
