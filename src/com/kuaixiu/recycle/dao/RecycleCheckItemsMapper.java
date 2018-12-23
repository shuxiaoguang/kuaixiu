package com.kuaixiu.recycle.dao;

import com.common.base.dao.BaseDao;

public interface RecycleCheckItemsMapper<T> extends BaseDao<T>{
   
	/**
	 * 
	
	 * Description:通过微信openId修改 
	
	 * @param t
	 * @return
	 */
	int updateByWechatId(T t);
}