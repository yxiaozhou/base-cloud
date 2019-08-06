package com.mso.base.cloud.product.controller;

import com.mso.base.cloud.common.controller.BaseController;
import com.mso.base.cloud.product.service.feign.CampusFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品
 *
 * @author yeshimin
 * @create 2019-07-08
 */
@RestController
@RequestMapping("/products")
public class ProductController extends BaseController {

    @Autowired
    private CampusFeign campusFeign;

    @GetMapping
    public String get(){
        return campusFeign.getCampusDetail("1").toString();
    }

}
