package com.mso.base.cloud.campus.domain.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "s_campus")
public class SCampus {
    /**
     * 校区id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 校区名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 校区图片url
     */
    @Column(name = "image_url")
    private String imageUrl;

    /**
     * 校区地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 营业时间
     */
    @Column(name = "business_hours")
    private String businessHours;

    /**
     * 商家id
     */
    @Column(name = "store_id")
    private String storeId;

    /**
     * 省份id
     */
    @Column(name = "province_id")
    private Integer provinceId;

    /**
     * 省份名称
     */
    @Column(name = "province_name")
    private String provinceName;

    /**
     * 城市ID
     */
    @Column(name = "city_id")
    private Integer cityId;

    /**
     * 城市名称
     */
    @Column(name = "city_name")
    private String cityName;

    /**
     * 区域id
     */
    @Column(name = "area_id")
    private Integer areaId;

    /**
     * 区域名称
     */
    @Column(name = "area_name")
    private String areaName;

    /**
     * 排序优先级：1-99 越小优先级越高
     */
    @Column(name = "sort")
    private Integer sort;

    /**
     * 是否删除 0-否 1-是
     */
    @Column(name = "is_delete")
    private Boolean isDelete;

    /**
     * 保留字段 0-下架 1-上架
     */
    @Column(name = "state")
    private Integer state;

    /**
     * 创建人id
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 修改人id
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 上架时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time", insertable = false, updatable = false)
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time", insertable = false, updatable = false)
    private Date updateTime;
}
