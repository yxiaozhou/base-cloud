package com.mso.base.cloud.campus.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 查询校区列表 dto
 *
 * @author Dana
 * @create 2019-07-08 17:11
 * @update 2019-07-08 17:11
 */
@Data
public class GetCampusListDto {

    /**
     * 分页参数，第几页
     */
    @JsonProperty(value = "page")
    private Integer page;

    /**
     * 分页参数，每页显示数量
     */
    @JsonProperty(value = "size")
    private Integer size;

    /**
     * 校区名称
     */
    @JsonProperty("name")
    private String name;

    /**
     * 校区状态
     */
    @JsonProperty("state")
    private Integer state;

    /**
     * 品牌商家id
     */
    @NotBlank(message = "品牌商家id不能为空")
    @JsonProperty("storeId")
    private String storeId;
}
