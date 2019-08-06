package com.mso.base.cloud.product.service.feign.histryx;

import com.mso.base.cloud.common.domain.ResultVo;
import com.mso.base.cloud.product.service.feign.CampusFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CampusFallback implements  CampusFeign {

    @Override
    public ResultVo getCampusDetail(String id) {
        log.info("获取校区失败了");
        return ResultVo.wrapCode(9999);
    }
}
