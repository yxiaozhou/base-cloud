package com.mso.base.cloud.campus.domain.vo;

import lombok.Data;

/**
 *  已选商品列表vo
 *
 * @author Dana
 * @create 2019-07-09 17:11
 * @update 2019-07-09 17:11
 */
@Data
public class CampusProductListVo {

    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 当前校区销量
     */
    private Integer quantityNum;

    /**
     * 总销量
     */
    private Integer orderNum;

    /**
     * 商品类型
     */
    private Integer type;

}
