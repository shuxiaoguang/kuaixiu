package com.shangji.business.entity;import com.common.base.entity.BaseEntity;/** * . * * @CreateDate: 2019-05-06 上午10:43:53 * @version: V 1.0 */public class OrderCompanyPicture extends BaseEntity {        /**     * 序列化Id     */    private static final long serialVersionUID = 1L;    /**     *      */    private Long id ;    /**     * 订单id     */    private Long orderId ;    /**     * 公司门头图片     */    private String companyPictureUrl ;    public Long getId(){        return this.id;    }    public void setId(Long id){        this.id=id;    }    public Long getOrderId(){        return this.orderId;    }    public void setOrderId(Long orderId){        this.orderId=orderId;    }    public String getCompanyPictureUrl(){        return this.companyPictureUrl;    }    public void setCompanyPictureUrl(String companyPictureUrl){        this.companyPictureUrl=companyPictureUrl;    }}