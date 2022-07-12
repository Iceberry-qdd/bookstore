package com.iceberry.starterDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

/**
 * Swagger配置类
 */
@Configuration
@EnableOpenApi
public class SwaggerConfiguration implements WebMvcConfigurer {

    /**
     * 配置Swagger主接口
     * @return Swagger主接口
     */
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.iceberry.starterDemo"))
                .paths(PathSelectors.any())
                .build();
    }

    Contact contact = new Contact("Iceberry", "Iceberry.com", "qddwork@outlook.com");

    /**
     * 配置Api信息
     * @return Api信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfo("BookStore", "The book store application's api doc.", "1.0", "iceberry.com", contact, "MIT", "https://mit-license.org/", new ArrayList<>());
    }
}
