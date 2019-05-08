package com.kuaixiu.sjBusiness.entity;import com.common.base.entity.BaseEntity;/** * . * * @CreateDate: 2019-05-08 下午12:48:51 * @version: V 1.0 */public class SjOrder extends BaseEntity {    /**     * 序列化Id     */    private static final long serialVersionUID = 1L;    /**     *     */    private Long id;    /**     * 订单编号     */    private String orderNo;    /**     * 订单类型    1商机单  2派单     */    private Integer type;    /**     * 订单状态  待审核100，带指派200，待施工300，待竣工400，已完成500，未通过600     */    private Integer state;    /**     * 单位名字     */    private String companyName;    /**     * 省id     */    private String provinceId;    /**     * 市id     */    private String cityId;    /**     * 区域id     */    private String areaId;    /**     * 街道id     */    private String streetId;    /**     * 详细地址     */    private String addressDetail;    /**     * 联系人     */    private String person;    /**     * 联系电话     */    private String phone;    /**     * 产品需求id     */    private String projectId;    /**     * 组网     */    private Integer group;    /**     * 单点     */    private Integer single;    /**     * 待处理人     */    private String stayPerson;    /**     * 审批人     */    private String approvalPerson;    /**     * 审批备注     */    private String approvalNote;    /**     * 审批时间     */    private java.util.Date approvalTime;    /**     * 指派人     */    private String assignPerson;    /**     * 指派时间     */    private java.util.Date assignTime;    /**     * 施工人     */    private String buildPerson;    /**     * 施工电话     */    private String buildPhone;    /**     * 施工单位     */    private String buildCompany;    /**     * 施工完成时间     */    private java.util.Date endTime;    /**     * 竣工人     */    private String completedPerson;    /**     * 竣工电话     */    private String completedPhone;    /**     * 竣工时间     */    private java.util.Date completedTime;    /**     *     */    private java.util.Date createTime;    /**     * 创建人     */    private String createUserid;    public Long getId() {        return this.id;    }    public void setId(Long id) {        this.id = id;    }    public String getOrderNo() {        return this.orderNo;    }    public void setOrderNo(String orderNo) {        this.orderNo = orderNo;    }    public Integer getType() {        return this.type;    }    public void setType(Integer type) {        this.type = type;    }    public Integer getState() {        return this.state;    }    public void setState(Integer state) {        this.state = state;    }    public String getCompanyName() {        return this.companyName;    }    public void setCompanyName(String companyName) {        this.companyName = companyName;    }    public String getProvinceId() {        return this.provinceId;    }    public void setProvinceId(String provinceId) {        this.provinceId = provinceId;    }    public String getCityId() {        return this.cityId;    }    public void setCityId(String cityId) {        this.cityId = cityId;    }    public String getAreaId() {        return this.areaId;    }    public void setAreaId(String areaId) {        this.areaId = areaId;    }    public String getStreetId() {        return this.streetId;    }    public void setStreetId(String streetId) {        this.streetId = streetId;    }    public String getAddressDetail() {        return this.addressDetail;    }    public void setAddressDetail(String addressDetail) {        this.addressDetail = addressDetail;    }    public String getPerson() {        return this.person;    }    public void setPerson(String person) {        this.person = person;    }    public String getPhone() {        return this.phone;    }    public void setPhone(String phone) {        this.phone = phone;    }    public String getProjectId() {        return this.projectId;    }    public void setProjectId(String projectId) {        this.projectId = projectId;    }    public Integer getGroup() {        return this.group;    }    public void setGroup(Integer group) {        this.group = group;    }    public Integer getSingle() {        return this.single;    }    public void setSingle(Integer single) {        this.single = single;    }    public String getStayPerson() {        return this.stayPerson;    }    public void setStayPerson(String stayPerson) {        this.stayPerson = stayPerson;    }    public String getApprovalPerson() {        return this.approvalPerson;    }    public void setApprovalPerson(String approvalPerson) {        this.approvalPerson = approvalPerson;    }    public String getApprovalNote() {        return this.approvalNote;    }    public void setApprovalNote(String approvalNote) {        this.approvalNote = approvalNote;    }    public java.util.Date getApprovalTime() {        return this.approvalTime;    }    public void setApprovalTime(java.util.Date approvalTime) {        this.approvalTime = approvalTime;    }    public String getAssignPerson() {        return this.assignPerson;    }    public void setAssignPerson(String assignPerson) {        this.assignPerson = assignPerson;    }    public java.util.Date getAssignTime() {        return this.assignTime;    }    public void setAssignTime(java.util.Date assignTime) {        this.assignTime = assignTime;    }    public String getBuildPerson() {        return this.buildPerson;    }    public void setBuildPerson(String buildPerson) {        this.buildPerson = buildPerson;    }    public String getBuildPhone() {        return this.buildPhone;    }    public void setBuildPhone(String buildPhone) {        this.buildPhone = buildPhone;    }    public String getBuildCompany() {        return this.buildCompany;    }    public void setBuildCompany(String buildCompany) {        this.buildCompany = buildCompany;    }    public java.util.Date getEndTime() {        return this.endTime;    }    public void setEndTime(java.util.Date endTime) {        this.endTime = endTime;    }    public String getCompletedPerson() {        return this.completedPerson;    }    public void setCompletedPerson(String completedPerson) {        this.completedPerson = completedPerson;    }    public String getCompletedPhone() {        return this.completedPhone;    }    public void setCompletedPhone(String completedPhone) {        this.completedPhone = completedPhone;    }    public java.util.Date getCompletedTime() {        return this.completedTime;    }    public void setCompletedTime(java.util.Date completedTime) {        this.completedTime = completedTime;    }    public java.util.Date getCreateTime() {        return this.createTime;    }    public void setCreateTime(java.util.Date createTime) {        this.createTime = createTime;    }    public String getCreateUserid() {        return this.createUserid;    }    public void setCreateUserid(String createUserid) {        this.createUserid = createUserid;    }}