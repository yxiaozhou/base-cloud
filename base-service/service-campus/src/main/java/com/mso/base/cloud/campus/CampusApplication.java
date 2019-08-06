package com.mso.base.cloud.campus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@EnableCaching
@MapperScan("com.mso.base.cloud.campus.mybatis.mapper")
public class CampusApplication {
    public static void main(String[] args) {
        SpringApplication.run(CampusApplication.class);
    }
//
//    @Value("${server.port}")
//    String port;
//
//    @RequestMapping("/api/hi")
//    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
//        return "hi " + name + " ,i am from port:" + port;
//    }
}
