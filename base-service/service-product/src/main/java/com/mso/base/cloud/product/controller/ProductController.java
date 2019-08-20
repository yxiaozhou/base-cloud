package com.mso.base.cloud.product.controller;

import com.mso.base.cloud.common.controller.BaseController;
import com.mso.base.cloud.common.domain.ResultVo;
import com.mso.base.cloud.product.domain.dto.AddProductDto;
import com.mso.base.cloud.product.service.ProductService;
import com.mso.base.cloud.product.service.feign.CampusFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private ProductService productService;

    @GetMapping
    public String get(){
        return campusFeign.getCampusDetail("1").toString();
    }

    @PostMapping
    public ResultVo add(@RequestBody  AddProductDto dto){
        return ResultVo.wrapData(productService.addProduct(dto));
    }

}
