package com.kuaixiu.order.entity;import java.math.BigDecimal;import java.util.ArrayList;import java.util.Date;import java.util.HashMap;import java.util.List;import java.util.Map;import com.common.base.entity.BaseEntity;import com.kuaixiu.engineer.entity.Engineer;import com.kuaixiu.order.constant.OrderConstant;import com.kuaixiu.shop.entity.Shop;import org.apache.commons.lang3.StringUtils;/** * . * * @CreateDate: 2016-08-26 下午10:44:08 * @version: V 1.0 */public class Order extends BaseEntity {    /**     * 序列化Id     */    private static final long serialVersionUID = 1L;    /**     *     */    private String id;    /**     * 订单号     */    private String orderNo;    /**     * 用户id     */    private String customerId;    /**     * 用户名称     */    private String customerName;    /**     * 连锁商账号     */    private String providerCode;    /**     * 连锁商名称     */    private String providerName;    /**     * 维修门店账号     */    private String shopCode;    /**     * 维修门店名称     */    private String shopName;    /**     * 维修门店负责人手机号 -- 查询使用     */    private String shopManagerMobile;    /**     * 维修门店联系电话 -- 查询使用     */    private String shopTel;    /**     * 品牌id     */    private String brandId;    /**     * 品牌名称     */    private String brandName;    /**     * 机型id     */    private String modelId;    /**     * 机型名称     */    private String modelName;    /**     * 机型颜色     */    private String color;    /**     * 维修方式   0 : 上门维修  1：到店维修 2 : 返店维修  3： 寄修  4：点对点二维码     */    private Integer repairType;    private String projectName ;    /**     * 下单时订单金额 （预测价格）     */    private java.math.BigDecimal orderPrice;    /**     * 实际订单金额 （预测报价与实际价格不一致时以实际价格为准）     */    private java.math.BigDecimal realPrice;    //是否管理员修改过金额  0:否 1：是    private Integer isUpdatePrice;    private BigDecimal realPriceSubCoupon;    /**     * 是否使用优惠券 0 否 1 是     */    private Integer isUseCoupon;    /**     * 优惠券ID     */    private String couponId;    /**     * 优惠码     */    private String couponCode;    /**     * 优惠码名称     */    private String couponName;    /**     * 优惠券类型     */    private Integer couponType;    /**     * 优惠码金额     */    private BigDecimal couponPrice;    /**     * 是否退款 0 无需退款 1 等待退款  2 退款失败 3 退款成功     */    private Integer isDrawback;    /**     * 退款金额     */    private java.math.BigDecimal drawbackPrice;    /**     * 退库时间     */    private java.util.Date drawbackTime;    /**     * 订单状态:     *  2  待派单           3  待门店收件      5  门店已收件     11 待预约     *  12 已预约           20 定位故障         30 待用户付款     *  35 正在维修        40 待客户收件     50 已完成             60 已取消     */		    private Integer orderStatus;    /**     * 取消订单类型 0 未取消， 1 用户自行取消，  2 工程师取消， 3 管理员取消     */    private Integer cancelType;    /**     * 取消前订单状态     */    private Integer cancelStatus;    /**     * 约定时间     */    private String agreedTime;    /**     * 是否支付保证金  废弃不使用     */    private Integer isDeposit;    /**     * 支付方式 0 微信支付     */    private Integer depositType;    /**     * 保证金     */    private java.math.BigDecimal depositPrice;    /**     * 保证金支付时间     */    private java.util.Date depositTime;    /**     * 支付方式 0 微信支付 1 支付宝支付     */    private Integer payType;    /**     * 支付状态 0 未支付 1 已支付     */    private Integer payStatus;    /**     * 支付时间     */    private java.util.Date payTime;    /**     * 支付金额     */    private java.math.BigDecimal payPrice;    /**     * 是否派单 0 否， 1是     */    private Integer isDispatch;    /**     * 派单时间     */    private java.util.Date dispatchTime;    /**     * 工程师ID     */    private String engineerId;    /**     * 工程师工号     */    private String engineerNumber;    /**     * 工程师名称     */    private String engineerName;    /**     * 工程师电话     */    private String engineerMobile;    /**     * 是否查询贴膜优惠券   1 不查  null或2 查     */    private Integer isPatch;    /**     * 开始检修时间     */    private java.util.Date startCheckTime;    /**     * 完成检修时间     */    private java.util.Date endCheckTime;    /**     * 开始维修时间     */    private java.util.Date startRepairTime;    /**     * 完成维修时间     */    private java.util.Date endRepairTime;    /**     * 手机号     */    private String mobile;    /**     * 邮箱     */    private String email;    /**     * 经度     */    private java.math.BigDecimal longitude;    /**     * 纬度     */    private java.math.BigDecimal latitude;    /**     * 省ID     */    private String province;    /**     * 市ID     */    private String city;    /**     * 区ID     */    private String county;    /**     * 街ID     */    private String street;    /**     * 地区名称 省、市、区、街     */    private String areas;    /**     * 详细地址     */    private String address;    /**     * 用户备注     */    private String postscript;    //工程师预约备注    private String engNote;    /**     * 管理员备注     */    private String note;    /**     * 是否手机订单 0 否， 1 是     */    private Integer isMobile;    /**     * 排序     */    private Integer sort;    /**     * 是否已评价     */    private Integer isComment;    /**     * 结算状态（-1不需要 0：未结算对账；1：待结算；2：结算单生成）     */    private Integer balanceStatus;    /**     *     */    private java.util.Date balanceTime;    /**     * 结算单号     */    private String balanceNo;    /**     * 处理并发 0：未锁定 1：已锁定     */    private Integer isLock;    /**     * 是否删除 0：否；1：是     */    private Integer isDel;    /**     *     */    private java.util.Date inTime;    /**     *     */    private java.util.Date updateTime;    /**     *     */    private String updateUserid;    /**     *      */    private String fromSystem;    /**     *      */    private String fromSystemName;    /**     * 订单完成时间     */    private java.util.Date endTime;    private String strEndTime;    private List<OrderDetail> orderDetails;        private Shop shop;    /**     * 创建订单的店员     */    private String clerkId;    /**     * 订单是否在店员首页显示      */    private Integer isShow;    /**     * 距离订单生成后时间  默认为0   1表示超过半小时   2表示超过两小时     */    private Integer sendAgreedNews;        /**     * 订单取消原因     */    private String cancelReason;      /**     * 用于前端筛选订单状态     */    private List<Integer> selectOrderStatus;    /**     * 该订单对应门店下的工程师列表信息     */    private List<Engineer> engineerList;    /**     * 查询完成维修开始时间，用于查询传参     */    private String queryRepairStartTime;    /**     * 查询完成维修结束时间，用于查询传参     */    private String queryRepairEndTime;    	public Integer getIsShow() {		return isShow;	}	public void setIsShow(Integer isShow) {		this.isShow = isShow;	}	public String getClerkId() {		return clerkId;	}	public void setClerkId(String clerkId) {		this.clerkId = clerkId;	}	/**     * get:     */    public String getId() {        return this.id;    }    /**     * set：     */    public void setId(String id) {        this.id = id;    }    /**     * get:订单号     */    public String getOrderNo() {        return this.orderNo;    }    /**     * set：订单号     */    public void setOrderNo(String orderNo) {        this.orderNo = orderNo;    }    /**     * get:用户id     */    public String getCustomerId() {        return this.customerId;    }    /**     * set：用户id     */    public void setCustomerId(String customerId) {        this.customerId = customerId;    }    /**     * get:用户名称     */    public String getCustomerName() {        return this.customerName;    }    /**     * set：用户名称     */    public void setCustomerName(String customerName) {        this.customerName = customerName;    }    /**     * get:连锁商账号     */    public String getProviderCode() {        return this.providerCode;    }    /**     * set：连锁商账号     */    public void setProviderCode(String providerCode) {        this.providerCode = providerCode;    }    /**     * get:连锁商名称     */    public String getProviderName() {        return this.providerName;    }    /**     * set：连锁商名称     */    public void setProviderName(String providerName) {        this.providerName = providerName;    }    /**     * get:维修门店账号     */    public String getShopCode() {        return this.shopCode;    }    /**     * set：维修门店账号     */    public void setShopCode(String shopCode) {        this.shopCode = shopCode;    }    /**     * get:维修门店名称     */    public String getShopName() {        return this.shopName;    }    /**     * set：维修门店名称     */    public void setShopName(String shopName) {        this.shopName = shopName;    }    public String getShopManagerMobile() {        return shopManagerMobile;    }    public void setShopManagerMobile(String shopManagerMobile) {        this.shopManagerMobile = shopManagerMobile;    }    public String getShopTel() {        return shopTel;    }    public void setShopTel(String shopTel) {        this.shopTel = shopTel;    }    public String getQueryRepairStartTime() {        if(StringUtils.isNotBlank(queryRepairStartTime) && queryRepairStartTime.length() == 10){            return queryRepairStartTime + " 00:00:00";        }        return queryRepairStartTime;    }    public void setQueryRepairStartTime(String queryRepairStartTime) {        this.queryRepairStartTime = queryRepairStartTime;    }    public String getQueryRepairEndTime() {        if(StringUtils.isNotBlank(queryRepairEndTime) && queryRepairEndTime.length() == 10){            return queryRepairEndTime + " 23:59:59";        }        return queryRepairEndTime;    }    public void setQueryRepairEndTime(String queryRepairEndTime) {        this.queryRepairEndTime = queryRepairEndTime;    }    /**     * get:品牌id     */    public String getBrandId() {        return this.brandId;    }    /**     * set：品牌id     */    public void setBrandId(String brandId) {        this.brandId = brandId;    }    /**     * get:品牌名称     */    public String getBrandName() {        return this.brandName;    }    /**     * set：品牌名称     */    public void setBrandName(String brandName) {        this.brandName = brandName;    }    /**     * get:机型id     */    public String getModelId() {        return this.modelId;    }    /**     * set：机型id     */    public void setModelId(String modelId) {        this.modelId = modelId;    }    /**     * get:机型名称     */    public String getModelName() {        return this.modelName;    }    /**     * set：机型名称     */    public void setModelName(String modelName) {        this.modelName = modelName;    }    public String getColor() {        return color;    }    public void setColor(String color) {        this.color = color;    }    /**     * get:维修方式   0 : 上门维修  1：到店维修 2 : 返店维修  3 : 寄修     */    public Integer getRepairType() {        return this.repairType;    }    /**     * set：维修方式   0 : 上门维修  1：到店维修 2 : 返店维修 3 : 寄修     */    public void setRepairType(Integer repairType) {        this.repairType = repairType;    }    /**     * get:下单时订单金额 （预测价格）     */    public java.math.BigDecimal getOrderPrice() {        return this.orderPrice;    }    /**     * set：下单时订单金额 （预测价格）     */    public void setOrderPrice(java.math.BigDecimal orderPrice) {        this.orderPrice = orderPrice;    }    /**     * get:实际订单金额 （预测报价与实际价格不一致时以实际价格为准）     */    public java.math.BigDecimal getRealPrice() {        return this.realPrice;    }        /**     * get:扣除优惠券后订单金额 （实际价格减去优惠券金额）     */    public java.math.BigDecimal getRealPriceSubCoupon() {    	if(this.realPrice != null && this.couponPrice != null){    		return realPrice.compareTo(this.couponPrice) > 0 ? realPrice.subtract(this.couponPrice) : BigDecimal.ZERO;    	}        return this.realPrice;    }    /**     * set：实际订单金额 （预测报价与实际价格不一致时以实际价格为准）     */    public void setRealPrice(java.math.BigDecimal realPrice) {        this.realPrice = realPrice;    }    public Integer getIsUpdatePrice() {        return isUpdatePrice;    }    public void setIsUpdatePrice(Integer isUpdatePrice) {        this.isUpdatePrice = isUpdatePrice;    }    public Integer getIsUseCoupon() {		return isUseCoupon;	}	public void setIsUseCoupon(Integer isUseCoupon) {		this.isUseCoupon = isUseCoupon;	}	public String getCouponId() {		return couponId;	}	public void setCouponId(String couponId) {		this.couponId = couponId;	}	public String getCouponCode() {		return couponCode;	}	public void setCouponCode(String couponCode) {		this.couponCode = couponCode;	}	public String getCouponName() {		return couponName;	}	public void setCouponName(String couponName) {		this.couponName = couponName;	}	public Integer getCouponType() {		return couponType;	}	public void setCouponType(Integer couponType) {		this.couponType = couponType;	}	public BigDecimal getCouponPrice() {		return couponPrice;	}	public void setCouponPrice(BigDecimal couponPrice) {		this.couponPrice = couponPrice;	}	public Integer getIsDrawback() {        return isDrawback;    }    public void setIsDrawback(Integer isDrawback) {        this.isDrawback = isDrawback;    }    /**     * get:退款金额     */    public java.math.BigDecimal getDrawbackPrice() {        return this.drawbackPrice;    }    /**     * set：退款金额     */    public void setDrawbackPrice(java.math.BigDecimal drawbackPrice) {        this.drawbackPrice = drawbackPrice;    }    /**     * get:退库时间     */    public java.util.Date getDrawbackTime() {        return this.drawbackTime;    }    /**     * set：退库时间     */    public void setDrawbackTime(java.util.Date drawbackTime) {        this.drawbackTime = drawbackTime;    }    /**     * 订单状态:     *  2  待派单           3  待门店收件      5  门店已收件     11 待预约     *  12 已预约           20 定位故障         30 待用户付款     *  35 正在维修        40 待客户收件     50 已完成             60 已取消     */			    public Integer getOrderStatus() {        return this.orderStatus;    }    /**     * 订单状态:     *  2  待派单           3  待门店收件      5  门店已收件     11 待预约     *  12 已预约           20 定位故障         30 待用户付款     *  35 正在维修        40 待客户收件     50 已完成             60 已取消     */		    public String getOrderStatusName() {        if(this.orderStatus == null){            return null;        }        String name = "";        switch (orderStatus) {            case OrderConstant.ORDER_STATUS_DEPOSITED:                name = "待派单";                break;            case OrderConstant.ORDER_STATUS_WAIT_SHOP_SEND_RECEIVE:                name = "待门店收件";                break;                case OrderConstant.ORDER_STATUS_SHOP_ALERADY_RECEIVE:                name = "门店已收件";                break;                    case OrderConstant.ORDER_STATUS_DISPATCHED:                name = "待预约";                break;            case OrderConstant.ORDER_STATUS_RECEIVED:                name = "已预约";                break;            case OrderConstant.ORDER_STATUS_START_CHECK:                name = "定位故障";                break;            case OrderConstant.ORDER_STATUS_END_REPAIR:                name = "待用户付款";                break;              case OrderConstant.ORDER_STATUS_REPAIRING:                name = "正在维修";                break;                  case OrderConstant.ORDER_STATUS_WAIT_CUSTOMER_RECEIVE:                name = "待客户收件";                break;              case OrderConstant.ORDER_STATUS_FINISHED:            	if(isComment==1){            		name="已完成";            	}else{            		name="待评价";            	}                break;            case OrderConstant.ORDER_STATUS_CANCEL:            	if(cancelType == 1){name="用户取消";}                if(cancelType == 2){name="工程师取消";}                if(cancelType == 3){name="管理员取消";}                if(cancelType == 4){name="客服取消";}                break;            default:                name = "生成订单";                break;        }        return name;    }        /**     * 订单状态:     *  2  待派单           3  待门店收件      5  门店已收件     11 待预约     *  12 已预约           20 定位故障         30 待用户付款     *  35 正在维修        40 待客户收件     50 已完成             60 已取消     */			    public void setOrderStatus(Integer orderStatus) {        this.orderStatus = orderStatus;    }    /**     * 取消订单类型 0 未取消， 1 用户自行取消，  2 工程师取消， 3 管理员取消     *     * @return     * @author: lijx     * @CreateDate: 2016-10-9 下午10:11:41     */    public Integer getCancelType() {        return cancelType;    }    /**     * 取消订单类型 0 未取消， 1 用户自行取消，  2 工程师取消， 3 管理员取消     *     * @param cancelType     * @author: lijx     * @CreateDate: 2016-10-9 下午10:11:47     */    public void setCancelType(Integer cancelType) {        this.cancelType = cancelType;    }    /**     * 取消前订单状态     *     * @return     * @author: lijx     * @CreateDate: 2016-10-9 下午10:28:03     */    public Integer getCancelStatus() {        return cancelStatus;    }    /**     * 取消前订单状态     *     * @param cancelStatus     * @author: lijx     * @CreateDate: 2016-10-9 下午10:28:09     */    public void setCancelStatus(Integer cancelStatus) {        this.cancelStatus = cancelStatus;    }        public String getAgreedTime() {		return agreedTime;	}	public void setAgreedTime(String agreedTime) {		this.agreedTime = agreedTime;	}	/**     * get:是否支付保证金     */    public Integer getIsDeposit() {        return this.isDeposit;    }    /**     * set：是否支付保证金     */    public void setIsDeposit(Integer isDeposit) {        this.isDeposit = isDeposit;    }    /**     * get:支付方式 0 微信支付     */    public Integer getDepositType() {        return this.depositType;    }    /**     * set：支付方式 0 微信支付     */    public void setDepositType(Integer depositType) {        this.depositType = depositType;    }    /**     * get:保证金     */    public java.math.BigDecimal getDepositPrice() {        return this.depositPrice;    }    /**     * set：保证金     */    public void setDepositPrice(java.math.BigDecimal depositPrice) {        this.depositPrice = depositPrice;    }    /**     * get:保证金支付时间     */    public java.util.Date getDepositTime() {        return this.depositTime;    }    /**     * set：保证金支付时间     */    public void setDepositTime(java.util.Date depositTime) {        this.depositTime = depositTime;    }    /**     * get:支付方式 0 微信支付     */    public Integer getPayType() {        return this.payType;    }    /**     * set：支付方式 0 微信支付     */    public void setPayType(Integer payType) {        this.payType = payType;    }    /**     * get:支付状态 0 未支付 1 已支付     */    public Integer getPayStatus() {        return this.payStatus;    }    /**     * set：支付状态 0 未支付 1 已支付     */    public void setPayStatus(Integer payStatus) {        this.payStatus = payStatus;    }    /**     * get:支付时间     */    public java.util.Date getPayTime() {        return this.payTime;    }    /**     * set：支付时间     */    public void setPayTime(java.util.Date payTime) {        this.payTime = payTime;    }    /**     * get:支付金额     */    public java.math.BigDecimal getPayPrice() {        return this.payPrice;    }    /**     * set：支付金额     */    public void setPayPrice(java.math.BigDecimal payPrice) {        this.payPrice = payPrice;    }    /**     * get:是否派单 0 否， 1是     */    public Integer getIsDispatch() {        return this.isDispatch;    }    /**     * set：是否派单 0 否， 1是, 2 派单给门店商     */    public void setIsDispatch(Integer isDispatch) {        this.isDispatch = isDispatch;    }    /**     * get:等待时间（毫秒）     */    public long getWaitTime() {        if(this.dispatchTime != null){            return new Date().getTime() - this.dispatchTime.getTime();        }        return 0;    }        /**     * get:派单时间     */    public java.util.Date getDispatchTime() {        return this.dispatchTime;    }    /**     * set：派单时间     */    public void setDispatchTime(java.util.Date dispatchTime) {        this.dispatchTime = dispatchTime;    }    /**     * get:工程师ID     */    public String getEngineerId() {        return this.engineerId;    }    /**     * set：工程师ID     */    public void setEngineerId(String engineerId) {        this.engineerId = engineerId;    }    /**     * get:工程师工号     */    public String getEngineerNumber() {        return this.engineerNumber;    }    /**     * set：工程师工号     */    public void setEngineerNumber(String engineerNumber) {        this.engineerNumber = engineerNumber;    }    /**     * get:工程师名称     */    public String getEngineerName() {        return this.engineerName;    }    /**     * set：工程师名称     */    public void setEngineerName(String engineerName) {        this.engineerName = engineerName;    }    /**     * get:工程师电话     */    public String getEngineerMobile() {        return this.engineerMobile;    }    /**     * set：工程师电话     */    public void setEngineerMobile(String engineerMobile) {        this.engineerMobile = engineerMobile;    }    public Integer getIsPatch() {        return isPatch;    }    public void setIsPatch(Integer isPatch) {        this.isPatch = isPatch;    }    public java.util.Date getStartCheckTime() {        return startCheckTime;    }    public void setStartCheckTime(java.util.Date startCheckTime) {        this.startCheckTime = startCheckTime;    }    public java.util.Date getEndCheckTime() {        return endCheckTime;    }    public void setEndCheckTime(java.util.Date endCheckTime) {        this.endCheckTime = endCheckTime;    }    /**     * get:开始维修时间     */    public java.util.Date getStartRepairTime() {        return this.startRepairTime;    }    /**     * set：开始维修时间     */    public void setStartRepairTime(java.util.Date startRepairTime) {        this.startRepairTime = startRepairTime;    }    /**     * get:完成维修时间     */    public java.util.Date getEndRepairTime() {        return this.endRepairTime;    }    /**     * set：完成维修时间     */    public void setEndRepairTime(java.util.Date endRepairTime) {        this.endRepairTime = endRepairTime;    }    /**     * get:手机号     */    public String getMobile() {        return this.mobile;    }    /**     * set：手机号     */    public void setMobile(String mobile) {        this.mobile = mobile;    }    /**     * get:邮箱     */    public String getEmail() {        return this.email;    }    /**     * set：邮箱     */    public void setEmail(String email) {        this.email = email;    }    /**     * get:经度     */    public java.math.BigDecimal getLongitude() {        return this.longitude;    }    /**     * set：经度     */    public void setLongitude(java.math.BigDecimal longitude) {        this.longitude = longitude;    }    /**     * get:纬度     */    public java.math.BigDecimal getLatitude() {        return this.latitude;    }    /**     * set：纬度     */    public void setLatitude(java.math.BigDecimal latitude) {        this.latitude = latitude;    }    /**     * get:省ID     */    public String getProvince() {        return this.province;    }    /**     * set：省ID     */    public void setProvince(String province) {        this.province = province;    }    /**     * get:市ID     */    public String getCity() {        return this.city;    }    /**     * set：市ID     */    public void setCity(String city) {        this.city = city;    }    /**     * get:区ID     */    public String getCounty() {        return this.county;    }    /**     * set：区ID     */    public void setCounty(String county) {        this.county = county;    }    /**     * get:街ID     */    public String getStreet() {        return this.street;    }    /**     * set：街ID     */    public void setStreet(String street) {        this.street = street;    }    /**     * get:地区名称 省、市、区、街     */    public String getAreas() {        return this.areas;    }    /**     * set：地区名称 省、市、区、街     */    public void setAreas(String areas) {        this.areas = areas;    }    /**     * get:全部地址     */    public String getFullAddress() {        return this.areas + " " + this.address;    }    /**     * get:详细地址     */    public String getAddress() {        return this.address;    }    /**     * set：详细地址     */    public void setAddress(String address) {        this.address = address;    }    /**     * get:用户备注     */    public String getPostscript() {        return this.postscript;    }    /**     * set：用户备注     */    public void setPostscript(String postscript) {        this.postscript = postscript;    }    /**     * get:管理员备注     */    public String getNote() {        return this.note;    }    /**     * set：管理员备注     */    public void setNote(String note) {        this.note = note;    }    /**     * get:是否手机订单 0 否， 1 是     */    public Integer getIsMobile() {        return this.isMobile;    }    /**     * set：是否手机订单 0 否， 1 是     */    public void setIsMobile(Integer isMobile) {        this.isMobile = isMobile;    }    /**     * get:排序     */    public Integer getSort() {        return this.sort;    }    /**     * set：排序     */    public void setSort(Integer sort) {        this.sort = sort;    }    public Integer getIsComment() {        return isComment;    }    public void setIsComment(Integer isComment) {        this.isComment = isComment;    }    /**     * get:结算状态（-1不需要 0：未结算对账；1：待结算；2：结算单生成）     */    public Integer getBalanceStatus() {        return this.balanceStatus;    }    /**     * set：结算状态（-1不需要 0：未结算对账；1：待结算；2：结算单生成）     */    public void setBalanceStatus(Integer balanceStatus) {        this.balanceStatus = balanceStatus;    }    /**     * get:     */    public java.util.Date getBalanceTime() {        return this.balanceTime;    }    /**     * set：     */    public void setBalanceTime(java.util.Date balanceTime) {        this.balanceTime = balanceTime;    }    /**     * get:结算单号     */    public String getBalanceNo() {        return this.balanceNo;    }    /**     * set：结算单号     */    public void setBalanceNo(String balanceNo) {        this.balanceNo = balanceNo;    }    /**     * get:处理并发 0：未锁定 1：已锁定     */    public Integer getIsLock() {        return this.isLock;    }    /**     * set：处理并发 0：未锁定 1：已锁定     */    public void setIsLock(Integer isLock) {        this.isLock = isLock;    }    /**     * get:是否删除 0：否；1：是     */    public Integer getIsDel() {        return this.isDel;    }    /**     * set：是否删除 0：否；1：是     */    public void setIsDel(Integer isDel) {        this.isDel = isDel;    }    /**     * get:     */    public java.util.Date getInTime() {        return this.inTime;    }    /**     * set：     */    public void setInTime(java.util.Date inTime) {        this.inTime = inTime;    }    /**     * get:     */    public java.util.Date getUpdateTime() {        return this.updateTime;    }    /**     * set：     */    public void setUpdateTime(java.util.Date updateTime) {        this.updateTime = updateTime;    }    /**     * get:     */    public String getUpdateUserid() {        return this.updateUserid;    }    /**     * set：     */    public void setUpdateUserid(String updateUserid) {        this.updateUserid = updateUserid;    }    /**     * get:订单完成时间     */    public java.util.Date getEndTime() {        return this.endTime;    }    /**     * set：订单完成时间     */    public void setEndTime(java.util.Date endTime) {        this.endTime = endTime;    }    public String getStrEndTime() {        return strEndTime;    }    public void setStrEndTime(String strEndTime) {        this.strEndTime = strEndTime;    }    public List<OrderDetail> getOrderDetails() {        return orderDetails;    }    public void setOrderDetails(List<OrderDetail> orderDetails) {        this.orderDetails = orderDetails;    }	public Shop getShop() {		return shop;	}	public void setShop(Shop shop) {		this.shop = shop;	}	public String getFromSystem() {		return fromSystem;	}	public void setFromSystem(String fromSystem) {		this.fromSystem = fromSystem;	}	public String getFromSystemName() {		return fromSystemName;	}	public void setFromSystemName(String fromSystemName) {		this.fromSystemName = fromSystemName;	}	public Integer getSendAgreedNews() {		return sendAgreedNews;	}	public void setSendAgreedNews(Integer sendAgreedNews) {		this.sendAgreedNews = sendAgreedNews;	}	public String getCancelReason() {		return cancelReason;	}	public void setCancelReason(String cancelReason) {		this.cancelReason = cancelReason;	}	public List<Engineer> getEngineerList() {		return engineerList;	}	public void setEngineerList(List<Engineer> engineerList) {		this.engineerList = engineerList;	}    public String getProjectName() {        return projectName;    }    public void setProjectName(String projectName) {        this.projectName = projectName;    }    public String getEngNote() {        return engNote;    }    public void setEngNote(String engNote) {        this.engNote = engNote;    }}