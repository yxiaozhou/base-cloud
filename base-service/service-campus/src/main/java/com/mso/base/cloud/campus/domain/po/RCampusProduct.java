package com.mso.base.cloud.campus.domain.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "r_campus_product")
public class RCampusProduct {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 校区id
     */
    @Column(name = "campus_id")
    private Integer campusId;

    /**
     * 商品id
     */
    @Column(name = "product_id")
    private String productId;

    /**
     * 销售量
     */
    @Column(name = "quantity_num")
    private Integer quantityNum;

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
