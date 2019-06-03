package com.kuaixiu.recycleCoupon.entity;import com.common.base.entity.BaseEntity;import com.common.util.DateUtil;/** * . * * @CreateDate: 2019-05-30 上午11:26:38 * @version: V 1.0 */public class HsActivityCoupon extends BaseEntity {        /**     * 序列化Id     */    private static final long serialVersionUID = 1L;    /**     *      */    private String id ;    /**     * 活动标识     */    private String activityLabel ;    /**     * 来源     */    private Integer source ;    /**     * 是否默认   是 1    否  0     */    private Integer isDefault ;    /**     * 是否删除  是  1     否 0      */    private Integer isDel ;    /**     *      */    private String headUrl ;    /**     *      */    private Integer headHeight ;    /**     *      */    private Integer headWide ;    /**     *      */    private Integer marginHeight ;    /**     *      */    private Integer marginWide ;    /**     *      */    private String centerUrl ;    /**     *      */    private String centercolorValue ;    /**     *      */    private Integer centerHeight ;    /**     *      */    private Integer centerWide ;    /**     *      */    private String activityRole ;    /**     *      */    private java.util.Date createTime ;    private String strCreateTime;    /**     *      */    private String createUserid ;    /**     *      */    private java.util.Date updateTime ;    /**     *      */    private String updateUserid ;    public String getId(){        return this.id;    }    public void setId(String id){        this.id=id;    }    public String getActivityLabel(){        return this.activityLabel;    }    public void setActivityLabel(String activityLabel){        this.activityLabel=activityLabel;    }    public Integer getSource(){        return this.source;    }    public void setSource(Integer source){        this.source=source;    }    public Integer getIsDefault(){        return this.isDefault;    }    public void setIsDefault(Integer isDefault){        this.isDefault=isDefault;    }    public Integer getIsDel(){        return this.isDel;    }    public void setIsDel(Integer isDel){        this.isDel=isDel;    }    public String getHeadUrl(){        return this.headUrl;    }    public void setHeadUrl(String headUrl){        this.headUrl=headUrl;    }    public Integer getHeadHeight(){        return this.headHeight;    }    public void setHeadHeight(Integer headHeight){        this.headHeight=headHeight;    }    public Integer getHeadWide(){        return this.headWide;    }    public void setHeadWide(Integer headWide){        this.headWide=headWide;    }    public Integer getMarginHeight(){        return this.marginHeight;    }    public void setMarginHeight(Integer marginHeight){        this.marginHeight=marginHeight;    }    public Integer getMarginWide(){        return this.marginWide;    }    public void setMarginWide(Integer marginWide){        this.marginWide=marginWide;    }    public String getCenterUrl(){        return this.centerUrl;    }    public void setCenterUrl(String centerUrl){        this.centerUrl=centerUrl;    }    public String getCentercolorValue(){        return this.centercolorValue;    }    public void setCentercolorValue(String centercolorValue){        this.centercolorValue=centercolorValue;    }    public Integer getCenterHeight(){        return this.centerHeight;    }    public void setCenterHeight(Integer centerHeight){        this.centerHeight=centerHeight;    }    public Integer getCenterWide(){        return this.centerWide;    }    public void setCenterWide(Integer centerWide){        this.centerWide=centerWide;    }    public String getActivityRole(){        return this.activityRole;    }    public void setActivityRole(String activityRole){        this.activityRole=activityRole;    }    public java.util.Date getCreateTime(){        return this.createTime;    }    public String getStrCreateTime() {        return DateUtil.getDateyyyyMMddHHmmss(this.createTime);    }    public void setStrCreateTime(String strCreateTime) {        this.strCreateTime = strCreateTime;    }    public void setCreateTime(java.util.Date createTime){        this.createTime=createTime;    }    public String getCreateUserid(){        return this.createUserid;    }    public void setCreateUserid(String createUserid){        this.createUserid=createUserid;    }    public java.util.Date getUpdateTime(){        return this.updateTime;    }    public void setUpdateTime(java.util.Date updateTime){        this.updateTime=updateTime;    }    public String getUpdateUserid(){        return this.updateUserid;    }    public void setUpdateUserid(String updateUserid){        this.updateUserid=updateUserid;    }}