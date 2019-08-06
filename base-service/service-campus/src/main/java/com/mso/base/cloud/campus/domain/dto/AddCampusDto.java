package com.mso.base.cloud.campus.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 新增校区 dto
 *
 * @author Dana
 * @create 2019-07-08 10:03
 * @update 2019-07-08 10:03
 */
@Data
public class AddCampusDto {

    /**
     * 校区名称
     */
    @JsonProperty("name")
    @NotBlank(message = "校区名称不能为空")
    private String name;

    /**
     * 校区图片url
     */
    @JsonProperty("imageUrl")
    @NotBlank(message = "校区图片url不能为空")
    private String imageUrl;

    /**
     * 校区地址
     */
    @JsonProperty("address")
    @NotBlank(message = "校区地址不能为空")
    private String address;

    /**
     * 营业时间
     */
    @JsonProperty("businessHours")
    @NotBlank(message = "营业时间不能为空")
    private String businessHours;

    /**
     * 品牌商家id
     */
    @JsonProperty("storeId")
    @NotBlank(message = "品牌商家id不能为空")
    private String storeId;

    /**
     * 省份id
     */
    @JsonProperty("provinceId")
    @NotNull(message = "省份id不能为空")
    private Integer provinceId;

    /**
     * 省份名称
     */
    @JsonProperty("provinceName")
    @NotBlank(message = "省份名称不能为空")
    private String provinceName;

    /**
     * 城市ID
     */
    @JsonProperty("cityId")
    @NotNull(message = "城市ID不能为空")
    private Integer cityId;

    /**
     * 城市名称
     */
    @JsonProperty("cityName")
    @NotBlank(message = "城市名称不能为空")
    private String cityName;

    /**
     * 区域id
     */
    @JsonProperty("areaId")
    @NotNull(message = "区域id不能为空")
    private Integer areaId;

    /**
     * 区域名称
     */
    @JsonProperty("areaName")
    @NotBlank(message = "区域名称不能为空")
    private String areaName;

    /**
     * 创建人id
     */
    private String createBy;

    /**
     * 修改人id
     */
    private String updateBy;

    /**
     * 上架时间
     */
    @JsonProperty("startTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 0-未上架 1-上架 2-自定义上架
     */
    @JsonProperty("state")
    @NotNull(message = "上架状态不能为空")
    private Integer state;

}
