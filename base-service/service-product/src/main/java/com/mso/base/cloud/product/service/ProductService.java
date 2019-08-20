package com.mso.base.cloud.product.service;

import com.mso.base.cloud.product.domain.dto.AddProductDto;
import com.mso.base.cloud.product.domain.po.Product;
import com.mso.base.cloud.product.mybatis.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品服务
 */
@Slf4j
@Service
public class ProductService {

    @Autowired
    public ProductMapper productMapper;

    public Integer addProduct(AddProductDto dto) {
        Product p = new Product();
        p.setCount(dto.getCount());
        p.setName(dto.getName());
        productMapper.insert(p);
        return 0;
    }
}
