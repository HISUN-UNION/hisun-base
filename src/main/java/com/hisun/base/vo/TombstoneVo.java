package com.hisun.base.vo;

import com.hisun.base.entity.TombstoneEntity;

/**
 * 
 *<p>类名称：TombstoneVo</p>
 *<p>类描述: </p>
 *<p>公司：湖南海数互联信息技术有限公司</p>
 *@创建人：Rocky
 *@创建时间：2014-12-19 下午3:18:42
 *@创建人联系方式：24212477@qq.com
 *@version
 */
public class TombstoneVo extends BaseVo{

	protected int tombstone= TombstoneEntity.TOMBSTONE_FALSE;
	protected String tombstoneStr="正常";
	
	public int getTombstone() {
		return tombstone;
	}
	public void setTombstone(int tombstone) {
		this.tombstone = tombstone;
		if(this.tombstone==TombstoneEntity.TOMBSTONE_FALSE){
			tombstoneStr="正常";
		}else{
			tombstoneStr="已删除";
		}
	}
	public String getTombstoneStr() {
		return tombstoneStr;
	}
	public void setTombstoneStr(String tombstoneStr) {
		this.tombstoneStr = tombstoneStr;
	}
	
}
