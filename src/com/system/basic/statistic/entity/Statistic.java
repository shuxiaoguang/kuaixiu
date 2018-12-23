package com.system.basic.statistic.entity;import com.common.base.entity.BaseEntity;import com.common.util.DateUtil;/** * . * * @CreateDate: 2016-09-24 上午01:21:24 * @version: V 1.0 */public class Statistic extends BaseEntity {        /**     * 序列化Id     */    private static final long serialVersionUID = 1L;    /**     *      */    private Integer id ;    /**     * 统计指标     */    private String target ;    /**     * 统计类型     */    private String typeKey ;    /**     * 统计类型名称     */    private String typeName ;    /**     * 附加参数     */    private String options ;    /**     * int类型统计值     */    private Long intValue ;    /**     * double类型统计值     */    private java.math.BigDecimal doubleValue ;    /**     * 统计的日期     */    private java.util.Date dayTime ;    /**     * 小时     */    private Integer hourTime ;    /**     * 参数1     */    private String para1 ;    /**     * 参数2     */    private String para2 ;    /**     * 参数3     */    private String para3 ;    /**     * 参数4     */    private String para4 ;    /**     * 统计时间     */    private java.util.Date intime ;    /**     * get:     */    public Integer getId(){        return this.id;    }    /**     * set：     */    public void setId(Integer id){        this.id=id;    }    /**     * get:统计指标     */    public String getTarget(){        return this.target;    }    /**     * set：统计指标     */    public void setTarget(String target){        this.target=target;    }    /**     * get:统计类型     */    public String getTypeKey(){        return this.typeKey;    }    /**     * set：统计类型     */    public void setTypeKey(String typeKey){        this.typeKey=typeKey;    }    /**     * get:统计类型名称     */    public String getTypeName(){        return this.typeName;    }    /**     * set：统计类型名称     */    public void setTypeName(String typeName){        this.typeName=typeName;    }    /**     * get:附加参数     */    public String getOptions(){        return this.options;    }    /**     * set：附加参数     */    public void setOptions(String options){        this.options=options;    }    /**     * get:int类型统计值     */    public Long getIntValue(){        return this.intValue;    }    /**     * set：int类型统计值     */    public void setIntValue(Long intValue){        this.intValue=intValue;    }    /**     * get:double类型统计值     */    public java.math.BigDecimal getDoubleValue(){        return this.doubleValue;    }    /**     * set：double类型统计值     */    public void setDoubleValue(java.math.BigDecimal doubleValue){        this.doubleValue=doubleValue;    }    /**     * get:统计的日期     */    public java.util.Date getDayTime(){        return this.dayTime;    }    /**     * get:统计的日期  yyyy-MM-dd     */    public String getDayTimeFmt(){        if(this.dayTime != null){            return DateUtil.getDateYYYYMMDD(dayTime);        }        return null;    }        /**     * set：统计的日期     */    public void setDayTime(java.util.Date dayTime){        this.dayTime=dayTime;    }    /**     * get:小时     */    public Integer getHourTime(){        return this.hourTime;    }    /**     * set：小时     */    public void setHourTime(Integer hourTime){        this.hourTime=hourTime;    }    /**     * get:参数1     */    public String getPara1(){        return this.para1;    }    /**     * set：参数1     */    public void setPara1(String para1){        this.para1=para1;    }    /**     * get:参数2     */    public String getPara2(){        return this.para2;    }    /**     * set：参数2     */    public void setPara2(String para2){        this.para2=para2;    }    /**     * get:参数3     */    public String getPara3(){        return this.para3;    }    /**     * set：参数3     */    public void setPara3(String para3){        this.para3=para3;    }    /**     * get:参数4     */    public String getPara4(){        return this.para4;    }    /**     * set：参数4     */    public void setPara4(String para4){        this.para4=para4;    }    /**     * get:统计时间     */    public java.util.Date getIntime(){        return this.intime;    }    /**     * set：统计时间     */    public void setIntime(java.util.Date intime){        this.intime=intime;    }}