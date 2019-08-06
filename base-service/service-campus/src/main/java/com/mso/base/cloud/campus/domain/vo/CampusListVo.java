package com.mso.base.cloud.campus.domain.vo;

import lombok.Data;

/**
 *  校区列表 vo
 *
 * @author Dana
 * @create 2019-07-08 17:33
 * @update 2019-07-08 17:33
 */
@Data
public class CampusListVo {

    /**
     * 校区id
     */
    private Integer id;

    /**
     * 校区名称
     */
    private String name;

    /**
     * 校区地址
     */
    private String address;

    /**
     * 营业时间
     */
    private String businessHours;

    /**
     * 短课包数量
     */
    private Integer productNum;

    /**
     * 预约课数量
     */
    private Integer subscribeNum;

    /**
     * 状态
     */
    private Integer state;

}
