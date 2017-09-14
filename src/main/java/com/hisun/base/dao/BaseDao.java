/**
 * 
 */
package com.hisun.base.dao;

import com.hisun.base.dao.util.OrderBy;
import com.hisun.base.dao.util.CommonConditionQuery;
import com.hisun.base.dao.util.CommonOrderBy;
import com.hisun.base.dao.util.ConditionQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import java.util.List;
import java.util.Map;

/**
 * 
 *<p>类名称：BaseDao</p>
 *<p>类描述: 主要定义了一些常用的数据访问接口方法，包括实体对象的增加、修改、删除、列表查询、条件查询等。
 *各具体业务模块数据访问接口通过继承此基类后，不再需要编写常用的数据访问接口方法。</p>
 *<p>公司：湖南海数互联信息技术有限公司</p>
 *@创建人：Rocky
 *@创建时间：2014-10-17 下午2:46:09
 *@创建人联系方式：24212477@qq.com
 *@version
 */
public interface BaseDao<E extends java.io.Serializable, PK extends java.io.Serializable> {

    public PK save(E entity);
    public void saveOrUpdate(E entity);
    public void deleteByPK(PK pk);
    public void delete(E entity);
    public void deleteBatch(CommonConditionQuery condition);
    public void update(E entity);
    public void evict(E entity);
    public E getPK(PK pk);
    public E getByPK(PK pk);
    public E loadByPK(PK pk);
    public boolean exists(PK pk);
    
    public void evict();
    public List<E> list();
    public List<E> list(boolean cacheable);
    public <T> T count();
    public <T> T count(boolean cacheable);
    public void flush();
    public void clear();
    
    public int executeBulk(final String hql, CommonConditionQuery query);
    public int executeNativeBulk(final String nativeSQL, CommonConditionQuery query);
    public int executeNativeBulk(final String nativeSQL, List<Object> paramList);
    
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
    public <T> T count(String hql, CommonConditionQuery query);
    public <T> T countByHql(String hql, CommonConditionQuery query);
    public <T> T count(String hql, CommonConditionQuery query, boolean cacheable);
    public List<E> list(CommonConditionQuery query, CommonOrderBy orderBy);
    public List<E> list(CommonConditionQuery query, CommonOrderBy orderBy, boolean cacheable);
    public List<E> list(String hql, CommonConditionQuery query, CommonOrderBy orderBy);
    public List<E> list(String hql, CommonConditionQuery query, CommonOrderBy orderBy, boolean cacheable);
    public List<E> list(CommonConditionQuery query, CommonOrderBy orderBy,
                        final int pageNum, final int pageSize);
    public List<E> list(CommonConditionQuery query, CommonOrderBy orderBy,
                        final int pageNum, final int pageSize, boolean cacheable);
    public List<E> list(String hql, CommonConditionQuery query, CommonOrderBy orderBy,
                        final int pageNum, final int pageSize);
    public List<E> list(String hql, CommonConditionQuery query, CommonOrderBy orderBy,
                        final int pageNum, final int pageSize, boolean cacheable);
    
    public <T> List<T> find(String hql, CommonConditionQuery query, CommonOrderBy orderBy);
    public <T> List<T> find(String hql, CommonConditionQuery query, CommonOrderBy orderBy,
                            final int pageNum, final int pageSize);
    
    
    public <T> T nativeCount(String sql, CommonConditionQuery query);
    public Long nativeCount(String sql, Map<String, Object> arg);
    public <T> List<T> nativeList(String sql, CommonConditionQuery query, CommonOrderBy orderBy);
    public <T> List<T> nativeList(String sql, CommonConditionQuery query, CommonOrderBy orderBy,
                                  final int pageNum, final int pageSize);
    public <T> List<T> nativeList(String sql, Map<String, Object> arg, final int pageNum, final int pageSize);
    
    public <T> List<T> nativeList(Class<T> c, String sql, Map<String, Object> arg, final int pageNum, final int pageSize);
    
    public <T> List<T> nativeList(Class<T> c, String sql, CommonConditionQuery condition, CommonOrderBy orderBy,
                                  final int pageNum, final int pageSize);
    public <T> List<T> nativeList(Class<T> c, String sql, Map<String, Object> paramMap);
    public int addTombstones(CommonConditionQuery query);
    public int removeTombstones(CommonConditionQuery query);
    
    public <T> List<T> list(String hql, List<Object> paramList, int pageNum, int pageSize);
    public <T> List<T> list(String hql, Map<String, Object> paramMap, int pageNum, int pageSize);
    
    public <T> List<T> list(String hql, List<Object> paramList);
    
    public <T> List<T> list(List<Criterion> criterionList, List<Order> orderList, int pageNum, int pageSize);
    
    public int count(String hql, List<Object> paramList);
    public int count(String hql, Map<String, Object> paramMap);
    
    public int count(List<Criterion> criterionList);
    /**
     * 更新多个字段，目前只支持单主键
     * @Description
     * @param entity
     * @param columnNames
     */
    public int update(E entity, String... columnNames);
    
    /**
     * 用SQL更新
     * @Description
     * @param sql
     * @param paramMap
     * @return
     */
    public int update(String sql, Map<String, Object> paramMap);
    
    /**
     * 返回MAP的统计数量
     * @Description
     * @param hql
     * @param paramMap
     * @return
     */
    public List<Map> countReturnMapByHql(String hql, Map<String, Object> paramMap);
    
    /**
     * 返回MAP的统计数量
     * @Description
     * @param hql
     * @param paramMap
     * @return
     */
    public List<Map> countReturnMapBySql(String sql, Map<String, Object> paramMap);
    
    public int countBySql(String sql, Map<String, Object> paramMap);

    /*public List<Map> listReturnMapBySql(String sql,Map<String,Object> paramMap);
    */
    public Session getSession();
}
