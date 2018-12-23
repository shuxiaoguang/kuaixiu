package com.system.basic.address.entity;import com.common.base.entity.BaseEntity;/** * . * * @CreateDate: 2016-09-03 下午09:40:07 * @version: V 1.0 */public class Address extends BaseEntity {        /**     * 序列化Id     */    private static final long serialVersionUID = 1L;    /**     *      */    private String id ;    /**     * 地址编号     */    private String areaId ;    /**     * 名称     */    private String area ;    /**     * 等级 1省2市3县4街道     */    private Integer level ;    /**     * 上级地址ID     */    private String pid ;    /**     * 省一级地址编码     */    private String provinceId ;    /**     * 排序     */    private Integer sort ;    /**     * 创建时间     */    private java.util.Date intime ;    /**     * get:     */    public String getId(){        return this.id;    }    /**     * set：     */    public void setId(String id){        this.id=id;    }    /**     * get:地址编号     */    public String getAreaId(){        return this.areaId;    }    /**     * set：地址编号     */    public void setAreaId(String areaId){        this.areaId=areaId;    }    /**     * get:名称     */    public String getArea(){        return this.area;    }    /**     * set：名称     */    public void setArea(String area){        this.area=area;    }    /**     * get:等级 1省2市3县4街道     */    public Integer getLevel(){        return this.level;    }    /**     * set：等级 1省2市3县4街道     */    public void setLevel(Integer level){        this.level=level;    }    /**     * get:上级地址ID     */    public String getPid(){        return this.pid;    }    /**     * set：上级地址ID     */    public void setPid(String pid){        this.pid=pid;    }    /**     * get:省一级地址编码     */    public String getProvinceId(){        return this.provinceId;    }    /**     * set：省一级地址编码     */    public void setProvinceId(String provinceId){        this.provinceId=provinceId;    }    /**     * get:排序     */    public Integer getSort(){        return this.sort;    }    /**     * set：排序     */    public void setSort(Integer sort){        this.sort=sort;    }    /**     * get:创建时间     */    public java.util.Date getIntime(){        return this.intime;    }    /**     * set：创建时间     */    public void setIntime(java.util.Date intime){        this.intime=intime;    }}