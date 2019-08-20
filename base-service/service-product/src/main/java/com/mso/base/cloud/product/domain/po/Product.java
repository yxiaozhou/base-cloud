package com.mso.base.cloud.product.domain.po;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "product")
public class Product {
    @Id
    private Integer id;

    private String name;

    private Integer count;
}
