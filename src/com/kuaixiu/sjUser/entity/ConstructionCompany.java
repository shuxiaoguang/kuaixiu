package com.kuaixiu.sjUser.entity;import com.common.base.entity.BaseEntity;/** * . * * @CreateDate: 2019-05-09 下午03:44:00 * @version: V 1.0 */public class ConstructionCompany extends BaseEntity {        /**     * 序列化Id     */    private static final long serialVersionUID = 1L;    /**     *      */    private Long id ;    /**     * 登录id     */    private String loginId ;    /**     * 省     */    private String province ;    /**     * 市     */    private String city ;    /**     * 区域     */    private String area ;    /**     * 街道     */    private String addressDetail ;    /**     * 对接人     */    private String person ;    /**     * 对接电话     */    private String phone ;    /**     * 施工项目     */    private String project ;    /**     * 单位人数     */    private Long personNum ;    /**     * 完成订单数     */    private Long endOrderNum ;    private String companyName;    private String address;    private String projectNames;    public String getCompanyName() {        return companyName;    }    public void setCompanyName(String companyName) {        this.companyName = companyName;    }    public String getAddress() {        return address;    }    public void setAddress(String address) {        this.address = address;    }    public String getProjectNames() {        return projectNames;    }    public void setProjectNames(String projectNames) {        this.projectNames = projectNames;    }    public Long getId(){        return this.id;    }    public void setId(Long id){        this.id=id;    }    public String getLoginId(){        return this.loginId;    }    public void setLoginId(String loginId){        this.loginId=loginId;    }    public String getProvince(){        return this.province;    }    public void setProvince(String province){        this.province=province;    }    public String getCity(){        return this.city;    }    public void setCity(String city){        this.city=city;    }    public String getArea(){        return this.area;    }    public void setArea(String area){        this.area=area;    }    public String getAddressDetail() {        return addressDetail;    }    public void setAddressDetail(String addressDetail) {        this.addressDetail = addressDetail;    }    public String getPerson(){        return this.person;    }    public void setPerson(String person){        this.person=person;    }    public String getPhone(){        return this.phone;    }    public void setPhone(String phone){        this.phone=phone;    }    public String getProject(){        return this.project;    }    public void setProject(String project){        this.project=project;    }    public Long getPersonNum(){        return this.personNum;    }    public void setPersonNum(Long personNum){        this.personNum=personNum;    }    public Long getEndOrderNum(){        return this.endOrderNum;    }    public void setEndOrderNum(Long endOrderNum){        this.endOrderNum=endOrderNum;    }}