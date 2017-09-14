package com.hisun.base.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * 
 *<p>类名称：TombstoneEntity</p>
 *<p>类描述:用于表示当前是一个具有墓碑标识的实体。</p>
 *<p>公司：湖南海数互联信息技术有限公司</p>
 *@创建人：Rocky
 *@创建时间：2014-10-16 上午11:38:34
 *@创建人联系方式：24212477@qq.com
 *@version
 */
@MappedSuperclass
public class TombstoneEntity extends BaseEntity{
	
	public static final int TOMBSTONE_FALSE=0;
	public static final int TOMBSTONE_TRUE=1;

	@Column(name="tombstone",nullable=false)
	protected int tombstone=TOMBSTONE_FALSE;


	public int getTombstone() {
		return tombstone;
	}
	
	public void setTombstone(int tombstone) {
		this.tombstone = tombstone;
	}
	
	
}
