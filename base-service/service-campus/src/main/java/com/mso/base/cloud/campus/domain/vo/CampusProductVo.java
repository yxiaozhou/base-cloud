package com.mso.base.cloud.campus.domain.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 校区商品列表vo
 * @author: hao
 * @version V1.0
 * @Package com.mshuoke.babyclass.alipaymini.domain.vo
 * @Description:
 * @date:   2019年5月31日 上午11:30:39
 */
@Data
public class CampusProductVo {

    /**
     * id
     */
    private String productId;

    /**
     * 名称
     */
    private String name;

    /**
     * 图标
     */
    private String coverImage;

    /**
     * 简介
     */
    private String intro;

    /**
     * 原价
     */
    private BigDecimal originalPrice;

    /**
     * 现价
     */
    private BigDecimal currentPrice;

}
