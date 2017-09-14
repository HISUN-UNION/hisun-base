package com.hisun.base.auth.service;

import com.google.common.collect.Maps;
import com.hisun.base.auth.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * <p>Title: SessionHelper.java </p>
 * <p>Package net.wish30.cloud.auth.service </p>
 * <p>Description: 正常退出的session的管理</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 湖南海数互联信息技术有限公司</p>
 * @author Jason
 * @email jason4j@qq.com
 * @date 2015年4月10日 上午9:40:39 
 * @version 
 */
@Service
public class SessionHelper {

	@Resource
	private SessionDAO sessionDAO;
	
	/**
	 * 获取所有session的用户名
	 * @return
	 */
	public Map<String,String> sessionPrincipal(){
		Map<String,String> maps = Maps.newHashMap();
		Collection<Session> sessions =  sessionDAO.getActiveSessions();
		Iterator<Session> it = sessions.iterator();
		while(it.hasNext()){
			Session session = it.next();
			String loginName  = principal(session);
			if(StringUtils.isNotBlank(loginName)){
				maps.put(loginName,session.getId().toString());
			}
		}
		return maps;
	}
	
	private String principal(Session session) {
        PrincipalCollection principalCollection =
                (PrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
        if(principalCollection!=null){
        	 return (String)principalCollection.getPrimaryPrincipal();
        }
        return "";
    }

    public void kickOutSession(String userName) throws Exception{
        Map<String,String> session = this.sessionPrincipal();
        if(session.containsKey(userName)){
            Session s = sessionDAO.readSession(session.get(userName));
            if (s != null){
                s.setAttribute(Constants.SESSION_FORCE_LOGOUT_KEY,Boolean.TRUE);
            }
        }
    }
}
