package com.baozupo.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auther: bestlmc
 * @Date: 2022/9/27 20:42
 * @Description: AdminApplication
 * @Version 1.0.0
 */
@SpringBootApplication
//@EnableOpenApi
@ComponentScan(basePackages = {
        "com.baozupo.admin.restapi",
        "com.baozupo.biz.service",
        "com.baozupo.biz.mapper",
        "com.baozupo.biz.domain",
        "com.baozupo.common.config",
        "com.baozupo.admin.annotion.*",
        "com.baozupo.admin.aspect",
        "com.baozupo.admin.config"})
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class,args);
    }
}
