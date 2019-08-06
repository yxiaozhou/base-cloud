package com.mso.base.cloud.campus.domain.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CampusVo {
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
    private List<String> imageUrl;

    /**
     * 校区地址
     */
    private String address;

    /**
     * 营业时间
     */
    private String businessHours;

    /**
     * 商家id
     */
    private String storeId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
