package com.kuaixiu.sjBusiness.entity;import com.common.base.entity.BaseEntity;/** * . * * @CreateDate: 2019-05-08 上午10:52:42 * @version: V 1.0 */public class OrderContractPicture extends BaseEntity {        /**     * 序列化Id     */    private static final long serialVersionUID = 1L;    /**     *      */    private Long id ;    /**     * 订单no     */    private String orderNo ;    /**     * 订单合同图片     */    private String contractPictureUrl ;    public Long getId(){        return this.id;    }    public void setId(Long id){        this.id=id;    }    public String getOrderNo(){        return this.orderNo;    }    public void setOrderNo(String orderNo){        this.orderNo=orderNo;    }    public String getContractPictureUrl(){        return this.contractPictureUrl;    }    public void setContractPictureUrl(String contractPictureUrl){        this.contractPictureUrl=contractPictureUrl;    }}