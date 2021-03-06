package com.hisun.base.auth.session;

import com.hisun.base.auth.Constants;
import org.apache.log4j.Logger;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.ExpiredSessionException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

import java.util.Collection;
import java.util.Iterator;

/**
 * 会话管理器
 * 
 * @author Jason
 * 
 */
public class SimpleWebSessionManager extends DefaultWebSessionManager {

	private CacheManager cacheManager;

	private final static Logger logger = Logger
			.getLogger(SimpleWebSessionManager.class);

	public SimpleWebSessionManager() {
		super();
	}

	public void validateSessions() {
		if (logger.isInfoEnabled())
			logger.info("Validating all active sessions...");
		int invalidCount = 0;
		Collection<?> activeSessions = getActiveSessions();
		if (activeSessions != null && !activeSessions.isEmpty()) {
			for (Iterator<?> iterator = activeSessions.iterator(); iterator.hasNext();) {
				Session session = (Session) iterator.next();
				try {
					SessionKey key = new DefaultSessionKey(session.getId());
					validate(session, key);
				} catch (InvalidSessionException e) {
					if (cacheManager != null) {
						SimpleSession s = (SimpleSession) session;
						if (s.getAttribute(Constants.CURRENT_USER) != null) {
							try{
								cacheManager.getCache(null).remove(s.getAttribute(Constants.CURRENT_USER));
							}catch (NullPointerException e1){
								logger.debug("会话为空!",e1);
							}
						}
					}
					if (logger.isDebugEnabled()) {
						boolean expired = e instanceof ExpiredSessionException;
						String msg = (new StringBuilder()).append(
								"Invalidated session with id [").append(
								session.getId()).append("]").append(
								expired ? " (expired)" : " (stopped)")
								.toString();
						//logger.debug(msg);
					}
					invalidCount++;
				}
			}

		}
		if (logger.isInfoEnabled()) {
			String msg = "Finished session validation.";
			if (invalidCount > 0)
				msg = (new StringBuilder()).append(msg).append("  [").append(
						invalidCount).append("] sessions were stopped.")
						.toString();
			else
				msg = (new StringBuilder()).append(msg).append(
						"  No sessions were stopped.").toString();
			//logger.info(msg);
		}
	}

	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

}
