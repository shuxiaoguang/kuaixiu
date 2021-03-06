package com.kuaixiu.recycle.service;

import com.common.base.service.BaseService;
import com.kuaixiu.recycle.dao.RecycleCustomerMapper;
import com.kuaixiu.recycle.entity.RecycleCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author: anson
* @CreateDate: 2017年11月17日 上午10:18:53
* @version: V 1.0
* 
*/
@Service("recycleCustomerService")
public class RecycleCustomerService extends BaseService<RecycleCustomer>{

	@Autowired
	private RecycleCustomerMapper<RecycleCustomer> mapper;
	
	@Override
	public RecycleCustomerMapper<RecycleCustomer> getDao() {

		return mapper;
	}
	
}
