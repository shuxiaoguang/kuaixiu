package com.kuaixiu.sjUser.entity;import com.common.base.entity.BaseEntity;/** * . * * @CreateDate: 2019-05-09 下午06:30:39 * @version: V 1.0 */public class SjWorker extends BaseEntity {        /**     * 序列化Id     */    private static final long serialVersionUID = 1L;    /**     *      */    private Long id ;    /**     *      */    private Integer loginId ;    /**     * 单位登录号     */    private String companyLoginId ;    /**     * 是否删除   1是   0否     */    private Integer isDel ;    /**     * 进行中数量    接单数量加一   完成数量减一     */    private Integer buildingNum ;    /** 参数 员工名字*/    private String workerName;    /** 参数 员工账号*/    private String workerUserId;    public String getWorkerUserId() {        return workerUserId;    }    public void setWorkerUserId(String workerUserId) {        this.workerUserId = workerUserId;    }    public String getWorkerName() {        return workerName;    }    public void setWorkerName(String workerName) {        this.workerName = workerName;    }    public Long getId(){        return this.id;    }    public void setId(Long id){        this.id=id;    }    public Integer getLoginId(){        return this.loginId;    }    public void setLoginId(Integer loginId){        this.loginId=loginId;    }    public String getCompanyLoginId(){        return this.companyLoginId;    }    public void setCompanyLoginId(String companyLoginId){        this.companyLoginId=companyLoginId;    }    public Integer getIsDel(){        return this.isDel;    }    public void setIsDel(Integer isDel){        this.isDel=isDel;    }    public Integer getBuildingNum(){        return this.buildingNum;    }    public void setBuildingNum(Integer buildingNum){        this.buildingNum=buildingNum;    }}