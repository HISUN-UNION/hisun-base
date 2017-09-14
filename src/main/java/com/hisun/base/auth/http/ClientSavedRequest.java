package com.hisun.base.auth.http;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.util.SavedRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: ClientSavedRequest.java</p>
 * <p>Description: 自定义SavedRequest</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 湖南海数互联信息技术有限公司</p>
 *
 * @author Jason
 * @version v0.1
 * @email jason4j@qq.com
 * @date 2015-11-18 18:43
 */
public class ClientSavedRequest extends SavedRequest{

    private String redirectUrl;

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    /**
     * Constructs a new instance from the given HTTP request.
     *
     * @param request the current request to save.
     */
    public ClientSavedRequest(HttpServletRequest request,String redirectUrl) {
        super(request);
        this.redirectUrl = redirectUrl;
    }

    @Override
    public String getRequestUrl() {
        if(StringUtils.isNotBlank(redirectUrl)){
            return redirectUrl;
        }else{
            return super.getRequestUrl();
        }
    }
}
