package com.mso.base.cloud.product.service.feign;

import com.mso.base.cloud.common.domain.ResultVo;
import com.mso.base.cloud.product.service.feign.histryx.CampusFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-campus",fallback = CampusFallback.class)
public interface CampusFeign {

    @GetMapping("/campus/detail1")
    public ResultVo getCampusDetail(@RequestParam("id") String id);

}
