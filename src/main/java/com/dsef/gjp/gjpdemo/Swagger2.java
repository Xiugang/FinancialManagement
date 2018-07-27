package com.dsef.gjp.gjpdemo;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author D.S.E.F
 * @date 2018/7/25
 */
@Configuration
@EnableSwagger2
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
public class Swagger2 {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dsef.gjp.gjpdemo"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("账务管理Swagger版")
                .description("朱某某是个大傻帽")
                .termsOfServiceUrl("http://www.zhuyuyu.com")
                .contact("D.S.E.F.")
                .version("2.0")
                .build();
    }
}
