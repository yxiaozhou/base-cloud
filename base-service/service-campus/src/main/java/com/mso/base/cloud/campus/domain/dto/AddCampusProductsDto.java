package com.mso.base.cloud.campus.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 配置校区商品 Dto
 *
 * @author Dana
 * @create 2019-07-09 14:36
 * @update 2019-07-09 14:36
 */
@Data
public class AddCampusProductsDto {

    /**
     * 校区id
     */
    @JsonProperty("campusId")
    @NotNull(message = "校区id不能为空")
    private Integer campusId;

    /**
     * 商品id
     */
    @JsonProperty("productIds")
    //@NotEmpty(message = "商品id不能为空")
    private List<String> productIds;

}
