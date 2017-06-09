package com.chakra.root.common.configuration;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors
						.basePackage("com.chakra.root.hrm.controller"))
				.paths(regex("/api.*")).build().apiInfo(metaData());

	}

	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo("Chakra Applications",
				"Chakra Applications for Business Solution", "1.0", "Terms of service",
				new Contact("Kannan", "https://chakra.suite/about/","Kannan@chakra.suite"),
				"Apache License Version 2.0",
				"https://www.apache.org/licenses/LICENSE-2.0");
		return apiInfo;
	}
}