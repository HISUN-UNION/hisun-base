package com.hisun.base.dao.util;

import com.google.common.collect.Lists;
import com.hisun.util.JacksonUtil;

import java.io.Serializable;
import java.util.List;


/**
 * 
 *<p>类名称：CommonOrderBy</p>
 *<p>类描述: </p>
 *<p>公司：湖南海数互联信息技术有限公司</p>
 *@创建人：Rocky
 *@创建时间：2014-11-6 下午4:08:08
 *@创建人联系方式：24212477@qq.com
 *@version
 */

public class CommonOrderBy implements Serializable{

	
	private List<CommonOrder> orders = Lists.newLinkedList();
	
	
	public CommonOrderBy(){
		orders = Lists.newLinkedList();
	}
	
	
	
	public List<CommonOrder> getOrders() {
		return orders;
	}



	public void setOrders(List<CommonOrder> orders) {
		this.orders = orders;
	}



	public void add(CommonOrder order){
		this.orders.add(order);
	}
	
	@Override
	public String toString(){
		return JacksonUtil.nonDefaultMapper().toJson(this);
	}

}
