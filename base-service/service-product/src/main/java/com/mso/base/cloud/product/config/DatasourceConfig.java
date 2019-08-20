package com.mso.base.cloud.product.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceConfig {

    @Autowired
    public DB0Config db0Config;
    @Autowired
    public DB1Config db1Config;
}
