package com.kuaixiu.nbTelecomSJ.entity;import com.common.base.entity.BaseEntity;/** * . * * @CreateDate: 2019-02-22 下午06:32:37 * @version: V 1.0 */public class NBBusiness extends BaseEntity {        /**     * 序列化Id     */    private static final long serialVersionUID = 1L;    /**     * 商机录入ID     */    private Integer businessId ;    /**     * 经理ID     */    private Integer managerId ;    /**     * 经营单元ID     */    private Integer countyId ;    /**     * 支局ID     */    private Integer officeId ;    /**     * 包区ID     */    private Integer areaId ;    /**     * 客户姓名     */    private String coutomerName ;    /**     * 客户手机号     */    private String telephone ;    /**     * 地址     */    private String address ;    /**     * 地址属性  楼宇：1 ， 园区：2 ，市场：3 ，沿街：4     */    private Integer addressType ;    /**     * 通信需求 宽带体验：1，其他需求：2，无需求：3     */    private Integer demand ;    /**     * 备注     */    private String remarks ;    /**     * get:商机录入ID     */    public Integer getBusinessId(){        return this.businessId;    }    /**     * set：商机录入ID     */    public void setBusinessId(Integer businessId){        this.businessId=businessId;    }    /**     * get:经理ID     */    public Integer getManagerId(){        return this.managerId;    }    /**     * set：经理ID     */    public void setManagerId(Integer managerId){        this.managerId=managerId;    }    /**     * get:经营单元ID     */    public Integer getCountyId(){        return this.countyId;    }    /**     * set：经营单元ID     */    public void setCountyId(Integer countyId){        this.countyId=countyId;    }    /**     * get:支局ID     */    public Integer getOfficeId(){        return this.officeId;    }    /**     * set：支局ID     */    public void setOfficeId(Integer officeId){        this.officeId=officeId;    }    /**     * get:包区ID     */    public Integer getAreaId(){        return this.areaId;    }    /**     * set：包区ID     */    public void setAreaId(Integer areaId){        this.areaId=areaId;    }    /**     * get:客户姓名     */    public String getCoutomerName(){        return this.coutomerName;    }    /**     * set：客户姓名     */    public void setCoutomerName(String coutomerName){        this.coutomerName=coutomerName;    }    /**     * get:客户手机号     */    public String getTelephone(){        return this.telephone;    }    /**     * set：客户手机号     */    public void setTelephone(String telephone){        this.telephone=telephone;    }    /**     * get:地址     */    public String getAddress(){        return this.address;    }    /**     * set：地址     */    public void setAddress(String address){        this.address=address;    }    /**     * get:地址属性  楼宇：1 ， 园区：2 ，市场：3 ，沿街：4     */    public Integer getAddressType(){        return this.addressType;    }    /**     * set：地址属性  楼宇：1 ， 园区：2 ，市场：3 ，沿街：4     */    public void setAddressType(Integer addressType){        this.addressType=addressType;    }    /**     * get:通信需求 宽带体验：1，其他需求：2，无需求：3     */    public Integer getDemand(){        return this.demand;    }    /**     * set：通信需求 宽带体验：1，其他需求：2，无需求：3     */    public void setDemand(Integer demand){        this.demand=demand;    }    /**     * get:备注     */    public String getRemarks(){        return this.remarks;    }    /**     * set：备注     */    public void setRemarks(String remarks){        this.remarks=remarks;    }}