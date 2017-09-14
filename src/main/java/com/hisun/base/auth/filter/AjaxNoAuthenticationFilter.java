package com.hisun.base.auth.filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.util.PatternMatcher;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>类名称：AjaxNoAuthenticationFilter</p>
 * <p>类描述：当异步请求时候需要登录，返回错误JSON，代替原来直接返回登录页面</p>
 * <p>公司：湖南海数互联信息技术有限公司</p>
 *
 * @创建人：lyk
 * @创建时间：2015/10/15 9:09
 * @创建人联系方式：liyk_gz@30wish.net
 */
public class AjaxNoAuthenticationFilter extends PathMatchingFilter {

    /**
     * Simple default login URL equal to <code>/login.jsp</code>, which can be overridden by calling the
     * {@link #setLoginUrl(String) setLoginUrl} method.
     */
    public static final String DEFAULT_LOGIN_URL = "/login.jsp";

    /**
     * The login url to used to authenticate a user, used when redirecting users if authentication is required.
     */
    private String loginUrl = DEFAULT_LOGIN_URL;

    private String returnJson = null;

    protected PatternMatcher pathMatcher = new AntPathMatcher();

    public AjaxNoAuthenticationFilter(String returnJson){
        this.returnJson = returnJson;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpRequest = WebUtils.toHttp(request);
        if(pathsMatch(loginUrl,request)){
            return true;
        }
        if("XMLHttpRequest".equals(httpRequest.getHeader("X-Requested-With"))){
            Subject currentUser = SecurityUtils.getSubject();
            if(currentUser != null && currentUser.isAuthenticated()){
                return true;
            }
            HttpServletResponse httpResponse = WebUtils.toHttp(response);
            httpResponse.getWriter().print(returnJson.trim());
            return false;
        }else{
            return true;
        }
    }
}

