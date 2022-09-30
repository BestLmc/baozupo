package com.baozupo.admin.config;//package com.bestlmc.lihuamao.admin.config;
//
//import io.swagger.annotations.ApiOperation;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
///**
// * @Description: TODO(这里用一句话描述这个类的作用)
// * @Author bestlmc
// * @Date 2021/6/18 1:00
// */
//@Configuration
//public class Swagger3Config {
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.OAS_30)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("狸花猫接口文档")
//                .description("更多请咨询服务开发者Bestlmc")
//                .contact(new Contact("bestlmc", "http://www.bestlmc.xyz/", "bestlmc@foxmail.com"))
//                .version("1.0")
//                .build();
//    }
//}
