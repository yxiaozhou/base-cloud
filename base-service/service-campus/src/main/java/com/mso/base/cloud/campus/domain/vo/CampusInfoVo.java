package com.mso.base.cloud.campus.domain.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 店铺中校区详情vo
 * @author: hao
 * @version V1.0
 * @Package com.mshuoke.babyclass.operation.domain.vo
 * @Description:
 * @date:   2019年5月31日 上午10:47:39
 */
@Data
public class CampusInfoVo implements Serializable {

    private static final long serialVersionUID = 1320377839498275403L;

    /**
     * id
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 图标
     */
    private String imageUrl;

    /**
     * 地址
     */
    private String address;

    /**
     * 营业时间
     */
    private String businessHours;

}
