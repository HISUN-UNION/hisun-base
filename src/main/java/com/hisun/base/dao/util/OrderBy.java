/**
 * 
 */
package com.hisun.base.dao.util;

import com.google.common.collect.Lists;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

import java.util.List;

/**
 * @author Rocky
 * @date 2014-4-25
 */
public class OrderBy {
	
	private List<Order> orders = Lists.newLinkedList();

	public OrderBy(){}
	
	public void add(Order order){
		this.orders.add(order);
	}
	
    public void build(Criteria criteria) {
        for(Order order : orders) {
            criteria.addOrder(order);
        }
    }

}
