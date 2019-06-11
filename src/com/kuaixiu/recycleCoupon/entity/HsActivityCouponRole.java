package com.kuaixiu.recycleCoupon.entity;import com.common.base.entity.BaseEntity;import java.util.Date;/** * . * * @CreateDate: 2019-05-30 上午11:27:08 * @version: V 1.0 */public class HsActivityCouponRole extends BaseEntity {        /**     * 序列化Id     */    private static final long serialVersionUID = 1L;    /**     *      */    private String id ;    /**     * 加价券标识名字     */    private String nameLabel;    /**     * 优惠券名称     */    private String couponName ;    /**     * 加价类型 1：百分比 2:：固定加价     */    private Integer pricingType ;    /**     * 优惠券金额     */    private java.math.BigDecimal couponPrice ;    /**     * 满减金额上限额度     */    private java.math.BigDecimal upperLimit ;    /**     * 满减金额     */    private java.math.BigDecimal subtractionPrice ;    /**     * 加价规则描述     */    private String ruleDescription ;    /**     * 备注     */    private String note ;    /**     * 加价金额上限     */    private java.math.BigDecimal addPriceUpper ;    private Date createTime;    //活动标识，非dba字段    private String activityLabel;    public String getActivityLabel() {        return activityLabel;    }    public void setActivityLabel(String activityLabel) {        this.activityLabel = activityLabel;    }    public String getId(){        return this.id;    }    public void setId(String id){        this.id=id;    }    public String getNameLabel() {        return nameLabel;    }    public void setNameLabel(String nameLabel) {        this.nameLabel = nameLabel;    }    public String getCouponName(){        return this.couponName;    }    public void setCouponName(String couponName){        this.couponName=couponName;    }    public Integer getPricingType(){        return this.pricingType;    }    public void setPricingType(Integer pricingType){        this.pricingType=pricingType;    }    public java.math.BigDecimal getCouponPrice(){        return this.couponPrice;    }    public void setCouponPrice(java.math.BigDecimal couponPrice){        this.couponPrice=couponPrice;    }    public java.math.BigDecimal getUpperLimit(){        return this.upperLimit;    }    public void setUpperLimit(java.math.BigDecimal upperLimit){        this.upperLimit=upperLimit;    }    public java.math.BigDecimal getSubtractionPrice(){        return this.subtractionPrice;    }    public void setSubtractionPrice(java.math.BigDecimal subtractionPrice){        this.subtractionPrice=subtractionPrice;    }    public String getRuleDescription(){        return this.ruleDescription;    }    public void setRuleDescription(String ruleDescription){        this.ruleDescription=ruleDescription;    }    public String getNote(){        return this.note;    }    public void setNote(String note){        this.note=note;    }    public java.math.BigDecimal getAddPriceUpper(){        return this.addPriceUpper;    }    public void setAddPriceUpper(java.math.BigDecimal addPriceUpper){        this.addPriceUpper=addPriceUpper;    }    @Override    public Date getCreateTime() {        return createTime;    }    @Override    public void setCreateTime(Date createTime) {        this.createTime = createTime;    }}