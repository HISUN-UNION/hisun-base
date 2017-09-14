package com.hisun.base.dao.util;

import com.hisun.util.JacksonUtil;

import java.io.Serializable;

/**
 * 
 *<p>类名称：CommonOrder</p>
 *<p>类描述: </p>
 *<p>公司：湖南海数互联信息技术有限公司</p>
 *@创建人：Rocky
 *@创建时间：2014-11-19 上午11:26:28
 *@创建人联系方式：24212477@qq.com
 *@version
 */
@SuppressWarnings("serial")
public class CommonOrder implements Serializable{

	public static final String ASC="asc";
	public static final String DESC="desc";
	
	private String logic;
	private String orderColumn;
	
	private CommonOrder(){
		
	}
	
	public String getOrderColumn() {
		return orderColumn;
	}


	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}
	
	public String getLogic() {
		return logic;
	}

	private void setLogic(String logic) {
		this.logic = logic;
	}

	private static CommonOrder build(String logic ,String orderColumn){
		CommonOrder order = new CommonOrder();
		order.setOrderColumn(orderColumn);
		order.setLogic(logic);
		return order;
	}
	
	public static CommonOrder asc(String orderColumn){
		return build(ASC,orderColumn);
	}
	
	public static CommonOrder desc(String orderColumn){
		return build(DESC,orderColumn);
	}
	
	@Override
	public String toString(){
		return JacksonUtil.nonDefaultMapper().toJson(this);
	}

}
