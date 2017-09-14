package com.hisun.base.service;

import com.hisun.base.dao.util.OrderBy;
import com.hisun.base.dao.util.CommonConditionQuery;
import com.hisun.base.dao.util.CommonOrderBy;
import com.hisun.base.dao.util.ConditionQuery;

import java.util.List;

/**
 * 
 *<p>类名称：BaseService</p>
 *<p>类描述: 主要定义了一些常用的业务服务接口方法，包括实体对象的增加、修改、删除、列表查询、条件查询等。
 *各具体业务模块业务服务接口通过继承此基类后，不再需要编写常用的业务服务接口方法。</p>
 *<p>公司：湖南海数互联信息技术有限公司</p>
 *@创建人：Rocky
 *@创建时间：2014-10-17 下午2:46:09
 *@创建人联系方式：24212477@qq.com
 *@version
 */
public interface BaseService <E extends java.io.Serializable, PK extends java.io.Serializable>{
    
	
	public PK save(E entity);
    public void saveOrUpdate(E entity);
    public void deleteByPK(PK pk);
    public void delete(E entity);
    public void deleteList(List<E> entityList);
    public void deleteBatch(CommonConditionQuery condition);
    public void update(E entity);
    public void updateList(List<E> entityList);
    public E getPK(PK pk);
    public E getByPK(PK pk);
    public E loadByPK(PK pk);
    public boolean exists(PK pk);
    public List<E> list();
    public List<E> list(boolean cacheable);
    public <T> T count();
    public <T> T count(boolean cacheable);

    
    public <T> T count(ConditionQuery query);
    public <T> T count(ConditionQuery query, boolean cacheable);
    public List<E> list(ConditionQuery query, OrderBy orderBy);
    public List<E> list(ConditionQuery query, OrderBy orderBy, boolean cacheable);
    public List<E> list(ConditionQuery query, OrderBy orderBy,
                        final int pageNum, final int pageSize);
    public List<E> list(ConditionQuery query, OrderBy orderBy,
                        final int pageNum, final int pageSize, boolean cacheable);
    
    public <T> T count(CommonConditionQuery query);
    public <T> T count(CommonConditionQuery query, boolean cacheable);
    public List<E> list(CommonConditionQuery query, CommonOrderBy orderBy);
    public List<E> list(CommonConditionQuery query, CommonOrderBy orderBy, boolean cacheable);
    public List<E> list(CommonConditionQuery query, CommonOrderBy orderBy,
                        final int pageNum, final int pageSize);
    public List<E> list(CommonConditionQuery query, CommonOrderBy orderBy,
                        final int pageNum, final int pageSize, boolean cacheable);
    
    public <T> List<T> list(String hql, List<Object> paramList, int pageNum, int pageSize);
    public int count(String hql, List<?> paramList);
    public int addTombstones(CommonConditionQuery query);
    public int removeTombstones(CommonConditionQuery query);
    
    public void addTombstonePK(PK pk);
    public void addTombstone(E entity);
    public void removeTombstone(E entity);
    
    /**
     * 更新多个字段，目前只支持单主键
     * @Description
     * @param entity
     * @param columnNames
     */
    public int update(E entity, String[] columnNames);
}
