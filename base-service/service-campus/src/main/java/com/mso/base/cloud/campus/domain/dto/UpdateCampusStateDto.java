package com.mso.base.cloud.campus.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 修改校区状态 dto
 *
 * @author Dana
 * @create 2019-07-08 10:03
 * @update 2019-07-08 10:03
 */
@Data
public class UpdateCampusStateDto {

    /**
     * 校区id
     */
    @JsonProperty("id")
    @NotNull(message = "校区id不能为空")
    private Integer id;

    /**
     * 0-未上架 1-上架
     */
    @JsonProperty("state")
    @NotNull(message = "上架状态不能为空")
    private Integer state;

    /**
     * 创建人id
     */
    private String createBy;

    /**
     * 修改人id
     */
    private String updateBy;

}
