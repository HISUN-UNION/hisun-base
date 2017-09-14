package com.hisun.base.dao.util;

import com.hisun.util.JacksonUtil;

import java.io.Serializable;

/**
 * 
 *<p>类名称：CommonRestrictions</p>
 *<p>类描述: </p>
 *<p>公司：湖南海数互联信息技术有限公司</p>
 *@创建人：Rocky
 *@创建时间：2014-11-19 上午11:25:49
 *@创建人联系方式：24212477@qq.com
 *@version
 */

public class CommonRestrictions implements Serializable{
	
	public static final String AND="and";
	public static final String OR="or";
	
	
    private String logic = null;
	private String condition = null;
    private String name = null;
    private Object value = null;
    
    private CommonRestrictions(){
    	
    }

	public String getLogic() {
		return logic;
	}

	private void setLogic(String logic) {
		this.logic = logic;
	}

	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
    
    public  void  add (String condition,String name ,Object value){
    	this.condition =   condition;
    	this.name = name;
    	this.value = value;
    }
    
    private static CommonRestrictions build(String logic,String condition,String name ,Object value){
    	CommonRestrictions commonRestrictions = new CommonRestrictions();
    	commonRestrictions.setLogic(logic);
    	commonRestrictions.setCondition(condition);
    	commonRestrictions.setName(name);
    	commonRestrictions.setValue(value);
    	return commonRestrictions;
    }
    
    public static CommonRestrictions  and (String condition,String name ,Object value){
    	return build(AND, condition, name, value);
    }
    
    
    
    public static CommonRestrictions  or (String condition,String name ,Object value){
    	return build(OR, condition, name, value);
    }
    
    @Override
	public String toString(){
		return JacksonUtil.nonDefaultMapper().toJson(this);
	}

}
