/**
 *
 */
package com.hisun.base.dao.util;

import com.google.common.collect.Lists;
import com.hisun.util.JacksonUtil;

import java.io.Serializable;
import java.util.List;


/**
 * <p>类名称：CommonConditionQuery</p>
 * <p>类描述: </p>
 * <p>公司：湖南海数互联信息技术有限公司</p>
 *
 * @创建人：Rocky
 * @创建时间：2014-11-19 上午11:26:18
 * @创建人联系方式：24212477@qq.com
 */

@SuppressWarnings("serial")
public class CommonConditionQuery implements Serializable {

    private List<CommonRestrictions> restrictions = Lists.newLinkedList();
    private boolean isOnlySetQueryParams = false;


    public CommonConditionQuery() {
        restrictions = Lists.newLinkedList();
    }

    public CommonConditionQuery(boolean isOnlySetQueryParams) {
        this.isOnlySetQueryParams = isOnlySetQueryParams;
        restrictions = Lists.newLinkedList();
    }

    public List<CommonRestrictions> getRestrictions() {
        return restrictions;
    }


    public void setRestrictions(List<CommonRestrictions> restrictions) {
        this.restrictions = restrictions;
    }


    public void add(CommonRestrictions restrictions) {
        this.restrictions.add(restrictions);
    }

    @Override
    public String toString() {
        return JacksonUtil.nonDefaultMapper().toJson(this);
    }

    public boolean isOnlySetQueryParams() {
        return isOnlySetQueryParams;
    }

    public void setOnlySetQueryParams(boolean isOnlySetQueryParams) {
        this.isOnlySetQueryParams = isOnlySetQueryParams;
    }
}
