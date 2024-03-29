package com.spring.demo;

import com.spring.demo.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.concurrent.TimeUnit;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableSwagger2
@EnableConfigurationProperties({
		FileStorageProperties.class
})
@EnableAutoConfiguration
@ComponentScan
public class DemoApplication extends SpringBootServletInitializer implements WebMvcConfigurer {

	public Docket api(){

		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.spring.demo"))
				.paths(regex("/.*")).build().apiInfo(getApiInfo());
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	private ApiInfo getApiInfo(){

		return new ApiInfoBuilder().title("Admin Backend Api")
				.description("Admin Backend Api Service for Reselling site")
				.contact(new Contact("Asantha Thilina","https://github.com/asanthamax","asanthathilina@gmail.com"))
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.version("1.0.0")
				.build();
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DemoApplication.class);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry){

		registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/")
				.setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	}
}
