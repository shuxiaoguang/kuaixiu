package com.shangji.user.entity;import com.common.base.entity.BaseEntity;/** * . * * @CreateDate: 2019-05-06 上午10:51:22 * @version: V 1.0 */public class ConstructionCompany extends BaseEntity {        /**     * 序列化Id     */    private static final long serialVersionUID = 1L;    /**     *      */    private Long id ;    /**     * 登录id     */    private Long loginId ;    /**     * 省     */    private String province ;    /**     * 市     */    private String city ;    /**     * 县     */    private String county ;    /**     * 区域     */    private String area ;    /**     * 街道     */    private String street ;    /**     * 对接人     */    private String person ;    /**     * 对接电话     */    private String phone ;    /**     * 施工项目     */    private String project ;    public Long getId(){        return this.id;    }    public void setId(Long id){        this.id=id;    }    public Long getLoginId(){        return this.loginId;    }    public void setLoginId(Long loginId){        this.loginId=loginId;    }    public String getProvince(){        return this.province;    }    public void setProvince(String province){        this.province=province;    }    public String getCity(){        return this.city;    }    public void setCity(String city){        this.city=city;    }    public String getCounty(){        return this.county;    }    public void setCounty(String county){        this.county=county;    }    public String getArea(){        return this.area;    }    public void setArea(String area){        this.area=area;    }    public String getStreet(){        return this.street;    }    public void setStreet(String street){        this.street=street;    }    public String getPerson(){        return this.person;    }    public void setPerson(String person){        this.person=person;    }    public String getPhone(){        return this.phone;    }    public void setPhone(String phone){        this.phone=phone;    }    public String getProject(){        return this.project;    }    public void setProject(String project){        this.project=project;    }}