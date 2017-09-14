package com.hisun.base.dao.util;

import com.google.common.collect.Lists;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;

import java.util.List;

/**
 * @author Rocky
 * @date 2014-4-25
 */
public class ConditionQuery {

    private List<Criterion> criterions = Lists.newLinkedList();
    
    public ConditionQuery(){
    	
    }
    
    public void add(Criterion criterion) {
        criterions.add(criterion);
    }
    
    public void build(Criteria criteria) {
        for(Criterion criterion : criterions) {
            criteria.add(criterion);
        }
    }
}
