package com.kuaixiu.sjBusiness.entity;import com.common.base.entity.BaseEntity;/** * . * * @CreateDate: 2019-05-06 上午10:39:49 * @version: V 1.0 */public class SjProject extends BaseEntity {        /**     * 序列化Id     */    private static final long serialVersionUID = 1L;    /**     *      */    private Integer id ;    /**     * 产品需求（施工项目）     */    private String project ;    public Integer getId(){        return this.id;    }    public void setId(Integer id){        this.id=id;    }    public String getProject(){        return this.project;    }    public void setProject(String project){        this.project=project;    }}