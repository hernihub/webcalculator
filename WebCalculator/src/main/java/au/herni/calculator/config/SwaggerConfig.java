package au.herni.calculator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static au.herni.calculator.controllers.cons.App_Endpoints_Resources.API_VERSION;

/**
 * Swagger configuration for REST API documentation
 * @author Hernán Camilo
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
    @Bean
    public Docket api() { 
    	return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("au.herni.calculator"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());                                   
    }
    
    private ApiInfo metaData() {
    	return new ApiInfoBuilder()
                .title("Swagger API")
                .description("Spring Boot REST API for the Web Calculator")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .termsOfServiceUrl("")
                .version(API_VERSION)
                .contact(new Contact("Hernán Camilo Quevedo Barrero","","hernan_quevedo@yahoo.com"))
                .build();
    }
}