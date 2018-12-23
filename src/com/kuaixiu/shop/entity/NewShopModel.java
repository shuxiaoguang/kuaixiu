package com.kuaixiu.shop.entity;

import java.util.Calendar;

import com.common.base.entity.BaseEntity;
import com.common.util.DateUtil;

/**
* @author: anson
* @CreateDate: 2017年6月15日 下午12:02:23
* @version: V 1.0
* 
*/
public class NewShopModel extends BaseEntity {

	private static final long serialVersionUID = 1L;

	 private String id ;
	    /**
	     * 机型名称
	     */
	    private String shopCode ;
	    /**
	     * 品牌id
	     */
	    private String brandId ;
	    /**
	     * 品牌名称
	     */
	    private String brandName;
	    /**
	     * 
	     */
	    private String modelId ;
	    /**
	     * 排序
	     */
	    private Integer sort ;
	    /**
	     * 
	     */
	    private java.util.Date createTime ;
	    /**
	     * 
	     */
	    private String createUserid ;
	    /**
	     * 
	     */
	    private java.util.Date updateTime ;
	    /**
	     * 
	     */
	    private String updateUserid ;

	    /**
	     * get:
	     */
	    public String getId(){
	        return this.id;
	    }

	    /**
	     * set：
	     */
	    public void setId(String id){
	        this.id=id;
	    }
	    /**
	     * get:机型名称
	     */
	    public String getShopCode(){
	        return this.shopCode;
	    }

	    /**
	     * set：机型名称
	     */
	    public void setShopCode(String shopCode){
	        this.shopCode=shopCode;
	    }
	    /**
	     * get:品牌id
	     */
	    public String getBrandId(){
	        return this.brandId;
	    }

	    /**
	     * set：品牌id
	     */
	    public void setBrandId(String brandId){
	        this.brandId=brandId;
	    }
	    
	    public String getBrandName() {
			return brandName;
		}

		public void setBrandName(String brandName) {
			this.brandName = brandName;
		}

		/**
	     * get:
	     */
	    public String getModelId(){
	        return this.modelId;
	    }

	    /**
	     * set：
	     */
	    public void setModelId(String modelId){
	        this.modelId=modelId;
	    }
	    /**
	     * get:排序
	     */
	    public Integer getSort(){
	        return this.sort;
	    }

	    /**
	     * set：排序
	     */
	    public void setSort(Integer sort){
	        this.sort=sort;
	    }
	    /**
	     * get:
	     */
	    public java.util.Date getCreateTime(){
	        return this.createTime;
	    }

	    /**
	     * set：
	     */
	    public void setCreateTime(java.util.Date createTime){
	        this.createTime=createTime;
	    }
	    /**
	     * get:
	     */
	    public String getCreateUserid(){
	        return this.createUserid;
	    }

	    /**
	     * set：
	     */
	    public void setCreateUserid(String createUserid){
	        this.createUserid=createUserid;
	    }
	    /**
	     * get:
	     */
	    public java.util.Date getUpdateTime(){
	        return this.updateTime;
	    }

	    /**
	     * set：
	     */
	    public void setUpdateTime(java.util.Date updateTime){
	        this.updateTime=updateTime;
	    }
	    /**
	     * get:
	     */
	    public String getUpdateUserid(){
	        return this.updateUserid;
	    }

	    /**
	     * set：
	     */
	    public void setUpdateUserid(String updateUserid){
	        this.updateUserid=updateUserid;
	    }

	  
}
