package com.hisun.base.auth;

/**
 * 
 * <p>Title: TODO</p>
 * <p>Description: 常量定义</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 湖南海数互联信息技术有限公司</p>
 * @author Jason
 * @email jason4j@qq.com
 * @date 2015年3月25日 下午5:02:49 
 * @version
 */
public class Constants {
    public static final String CURRENT_USER = "user";
    public static final String SESSION_FORCE_LOGOUT_KEY = "session.force.logout";
    
    public static final String RESOURCE_QUERY_CODE = "queryCode";
	public static final String MENU_RESOURCE_ID = "menuResourceId";
    public static final String RESOURCE_ID = "id";
	public static final String ADMIN_USERNAME = "admin";
	public static final String ADMIN_PERMISSION = "all:admin";

	public static final Integer TYPE_PLATF = Integer.valueOf(0);//平台
	public static final Integer TYPE_TENANT = Integer.valueOf(1);//租户

	public static final String HEAD_PHOTO_PATH = "/platform/user/photo/";
	public static final String SOP_TENANT_ID = "_SOP_TENANT_ID";
	public static final String SOP_TENANT_USER_ID = "_SOP_TENANT_USER_ID";

	public static final String NO_PASSWORD = "NO_PASSWORD";
	public static final String NO_CAPTCHA = "NO_CAPTCHA";


	public static final String PDF_TYPE = "PDF"; //导出格式为PDF

	public static final String WORD_TYPE = "WORD";//导出格式为WORD

	public static final String HTML_TYPE = "HTML";//导出格式为html

	public static final String EXCEL_TYPE = "EXCEL";//导出格式为EXCEL

}
