package com.kuaixiu.sjBusiness.entity;import com.common.base.entity.BaseEntity;/** * . * * @CreateDate: 2019-07-02 上午10:33:28 * @version: V 1.0 */public class SjReworkOrderPicture extends BaseEntity {        /**     * 序列化Id     */    private static final long serialVersionUID = 1L;    /**     *      */    private String id ;    /**     * 报障订单no     */    private String reworkNo ;    /**     * 顾客签字图片     */    private String signPictureUrl ;    public String getId(){        return this.id;    }    public void setId(String id){        this.id=id;    }    public String getReworkNo(){        return this.reworkNo;    }    public void setReworkNo(String reworkNo){        this.reworkNo=reworkNo;    }    public String getSignPictureUrl(){        return this.signPictureUrl;    }    public void setSignPictureUrl(String signPictureUrl){        this.signPictureUrl=signPictureUrl;    }}