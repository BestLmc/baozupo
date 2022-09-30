package com.baozupo.admin.config;//package com.bestlmc.lihuamao.admin.config;
//
//import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * @Description: TODO(这里用一句话描述这个类的作用)
// * @Author bestlmc
// * @Date 2021/7/8 18:22
// */
//@Configuration
//@EnableSwagger2
//@EnableSwaggerBootstrapUI
//public class SwaggerConfiguration {
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.bestlmc.lihuamao.admin.controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("狸花猫接口文档")
//                .description("swagger-bootstrap-ui")
//                .termsOfServiceUrl("http://localhost:8001/")
//                .contact("bestlmc@foxmail.com")
//                .version("1.0")
//                .build();
//    }
//}