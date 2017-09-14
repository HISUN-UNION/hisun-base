package com.hisun.base.auth.credentials;

import com.hisun.base.auth.KaptchaUsernamePasswordToken;
import com.hisun.base.auth.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * <p>Title: RetryLimitHashedCredentialsMatcher</p>
 * <p>Description: 密码重试次数限制</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 湖南海数互联信息技术有限公司</p>
 * @author Jason
 * @email jason4j@qq.com
 * @date 2015年3月25日 上午10:37:44 
 * @version
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

    private Cache<String, AtomicInteger> passwordRetryCache;

    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        KaptchaUsernamePasswordToken usernamePasswordToken = (KaptchaUsernamePasswordToken) token;
        if (StringUtils.equalsIgnoreCase(Constants.NO_PASSWORD, String.valueOf(usernamePasswordToken.getPassword()))&&StringUtils.equalsIgnoreCase(Constants.NO_CAPTCHA,usernamePasswordToken.getCaptcha())) {
            return true;
        }else{
            String username = (String) token.getPrincipal();
            //retry count + 1
            AtomicInteger retryCount = passwordRetryCache.get(username);
            if (retryCount == null) {
                retryCount = new AtomicInteger(0);
                passwordRetryCache.put(username, retryCount);
            }
            if (retryCount.incrementAndGet() > 5) {
                //if retry count > 5 throw

                throw new ExcessiveAttemptsException();
            }

            boolean matches = super.doCredentialsMatch(token, info);
            if (matches) {
                //clear retry count
                passwordRetryCache.remove(username);
            }
            return matches;
        }
    }
}
