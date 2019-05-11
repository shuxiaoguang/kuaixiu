package com.kuaixiu.sjUser.dao;

import com.common.base.dao.BaseDao;
import org.apache.ibatis.annotations.Param;

/**
 * CustomerDetail Mapper
 *
 * @param <T>
 * @CreateDate: 2019-05-06 上午10:48:12
 * @version: V 1.0
 */
public interface CustomerDetailMapper<T> extends BaseDao<T> {

    T queryByLoginId(@Param("loginId")String phone);
}


