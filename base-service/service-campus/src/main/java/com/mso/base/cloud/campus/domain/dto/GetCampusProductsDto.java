package com.mso.base.cloud.campus.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 查询校区待选商品列表 dto
 *
 * @author Dana
 * @create 2019-07-09 17:23
 * @update 2019-07-09 17:23
 */
@Data
public class GetCampusProductsDto {

    /**
     * 分页参数
     */
    /*@NotNull(message = "page不能为空")
    @JsonProperty("page")
    private Integer page;*/

    /**
     * 分页参数
     */
    /*@NotNull(message = "size不能为空")
    @JsonProperty("size")
    private Integer size;*/

    /**
     * 商品类型
     */
    //@JsonProperty("type")
    //private Integer type;

    /**
     * 商品名称
     */
    //@JsonProperty("name")
    //private String name;

    /**
     * 校区id
     */
    @NotNull(message = "校区id不能为空")
    @JsonProperty("campusId")
    private Integer campusId;

    /**
     * 品牌id
     */
    @NotBlank(message = "storeId不能为空")
    @JsonProperty("storeId")
    private String storeId;

}
