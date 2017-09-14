package com.hisun.base.druid.pool;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>Title: DecryptDruidSource.java </p>
 * <p>Package net.wish30.base.druid.pool </p>
 * <p>Description: 自定义DruidSource支持加密数据库用户名</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 湖南海数互联信息技术有限公司</p>
 * @author Jason
 * @email jason4j@qq.com
 * @date 2015年11月10日 下午2:20:25 
 * @version 
 */
public class DecryptDruidSource extends DruidDataSource{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void setUsername(String username) {
		try {
			if (StringUtils.length(username) == 88) {
				username = ConfigTools.decrypt(username);
			}
		} catch (Exception e) {
			throw new RuntimeException("解析数据库用户名异常!",e);
		}
		super.setUsername(username);
	}
	
}
