package com.system.api.entity;import com.common.base.entity.BaseEntity;/** * . * * @CreateDate: 2016-09-05 下午08:40:20 * @version: V 1.0 */public class ApiConfig extends BaseEntity {        /**     * 序列化Id     */    private static final long serialVersionUID = 1L;    /**     * 接口代码     */    private String code ;    /**     * 服务名称     */    private String service ;    /**     * 接口方法     */    private String method ;    /**     * 包名     */    private String pkg ;    /**     * 接口类型     */    private Integer type ;    /**     * 接口描述     */    private String description ;    /**     * 状态 0=可用,1=禁用     */    private Integer state ;    /**     * 备注     */    private String note ;    /**     *      */    private java.util.Date createTime ;    /**     *      */    private java.util.Date updateTime ;    /**     * get:接口代码     */    public String getCode(){        return this.code;    }    /**     * set：接口代码     */    public void setCode(String code){        this.code=code;    }    /**     * get:服务名称     */    public String getService(){        return this.service;    }    /**     * set：服务名称     */    public void setService(String service){        this.service=service;    }    /**     * get:接口方法     */    public String getMethod(){        return this.method;    }    /**     * set：接口方法     */    public void setMethod(String method){        this.method=method;    }    /**     * get:包名     */    public String getPkg(){        return this.pkg;    }    /**     * set：包名     */    public void setPkg(String pkg){        this.pkg=pkg;    }    /**     * get:接口类型     */    public Integer getType(){        return this.type;    }    /**     * set：接口类型     */    public void setType(Integer type){        this.type=type;    }    /**     * get:接口描述     */    public String getDescription(){        return this.description;    }    /**     * set：接口描述     */    public void setDescription(String description){        this.description=description;    }    /**     * get:状态 0=可用,1=禁用     */    public Integer getState(){        return this.state;    }    /**     * set：状态 0=可用,1=禁用     */    public void setState(Integer state){        this.state=state;    }    /**     * get:备注     */    public String getNote(){        return this.note;    }    /**     * set：备注     */    public void setNote(String note){        this.note=note;    }    /**     * get:     */    public java.util.Date getCreateTime(){        return this.createTime;    }    /**     * set：     */    public void setCreateTime(java.util.Date createTime){        this.createTime=createTime;    }    /**     * get:     */    public java.util.Date getUpdateTime(){        return this.updateTime;    }    /**     * set：     */    public void setUpdateTime(java.util.Date updateTime){        this.updateTime=updateTime;    }}