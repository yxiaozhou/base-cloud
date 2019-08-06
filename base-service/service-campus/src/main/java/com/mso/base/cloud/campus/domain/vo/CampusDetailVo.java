package com.mso.base.cloud.campus.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 校区详情 vo
 *
 * @author Dana
 * @create 2019-07-08 10:03
 * @update 2019-07-08 10:03
 */
@Data
public class CampusDetailVo {

    /**
     * 校区id
     */
    private Integer id;

    /**
     * 校区名称
     */
    private String name;

    /**
     * 校区图片url
     */
    private String imageUrl;

    /**
     * 校区地址
     */
    private String address;

    /**
     * 营业时间
     */
    private String businessHours;

    /**
     * 省份id
     */
    private Integer provinceId;

    /**
     * 省份名称
     */
    private String provinceName;

    /**
     * 城市ID
     */
    private Integer cityId;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 区域id
     */
    private Integer areaId;

    /**
     * 区域名称
     */
    private String areaName;


    /**
     * 上架时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 0-未上架 1-上架 2-自定义上架
     */
    private Integer state;

}
