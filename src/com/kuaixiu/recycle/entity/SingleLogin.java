package com.kuaixiu.recycle.entity;

import com.common.base.entity.BaseEntity;

import java.util.Date;

/**
 * 单点登录欢GO信息
 */
public class SingleLogin extends BaseEntity{
    private static final long serialVersionUID = -4373607065346445707L;
    /** 手机号*/
    private String mobile;

    /** 单点登录ticket*/
    private String ticket;

    /** 请求流水号id*/
    private String transactionId;

    /** 重定向地址*/
    private String url;

    /** 记录生成时间*/
    private Date inTime;

    /** 记录更新时间*/
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hs_single_login.mobile
     *
     * @return the value of hs_single_login.mobile
     *
     * @mbg.generated
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hs_single_login.mobile
     *
     * @param mobile the value for hs_single_login.mobile
     *
     * @mbg.generated
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hs_single_login.ticket
     *
     * @return the value of hs_single_login.ticket
     *
     * @mbg.generated
     */
    public String getTicket() {
        return ticket;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hs_single_login.ticket
     *
     * @param ticket the value for hs_single_login.ticket
     *
     * @mbg.generated
     */
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hs_single_login.transaction_id
     *
     * @return the value of hs_single_login.transaction_id
     *
     * @mbg.generated
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hs_single_login.transaction_id
     *
     * @param transactionId the value for hs_single_login.transaction_id
     *
     * @mbg.generated
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hs_single_login.url
     *
     * @return the value of hs_single_login.url
     *
     * @mbg.generated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hs_single_login.url
     *
     * @param url the value for hs_single_login.url
     *
     * @mbg.generated
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hs_single_login.in_time
     *
     * @return the value of hs_single_login.in_time
     *
     * @mbg.generated
     */
    public Date getInTime() {
        return inTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hs_single_login.in_time
     *
     * @param inTime the value for hs_single_login.in_time
     *
     * @mbg.generated
     */
    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hs_single_login.update_time
     *
     * @return the value of hs_single_login.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hs_single_login.update_time
     *
     * @param updateTime the value for hs_single_login.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}