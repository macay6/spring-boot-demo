package com.macay.springbootswagger3knife4j.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @ClassName: Swagger3Config
 * @Description:
 * @Author: Macay
 * @Date: 2021/11/20 2:10 下午
 */
@Configuration
@EnableOpenApi
@EnableKnife4j
public class Swagger3Config {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                //为当前包下controller生成API文档
                .apis(RequestHandlerSelectors.basePackage("com.macay.springbootswagger3knife4j.controller"))
                //为有@Api注解的Controller生成API文档
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //为有@ApiOperation注解的方法生成API文档
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        //生成接口信息，包括标题、联系人，联系方式等
        return new ApiInfoBuilder()
                //设置文档标题(API名称)
                .title("接口文档")
                //文档描述
                .description("这是描述")
                // 设置联系人信息
                .contact(new Contact("root", "demo.com", "easy@163.com"))
                //版本号
                .version("1.0")
                .build();
    }
}
