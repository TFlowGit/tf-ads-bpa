package com.techflow.openfda;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;
import io.swagger.annotations.Api;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import com.google.common.base.Predicate;

@Configuration
@EnableSwagger2
@EnableAutoConfiguration
public class SwaggerConfig
{
	@Bean
	public Docket swaggerSpringMvcPlugin()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				// .groupName("business-api")
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
				// Ignores controllers annotated with @CustomIgnore
				// .apis(not(withClassAnnotation(CustomIgnore.class)) //Selection by RequestHandler
				.paths(paths()) // and by paths
				.build()
				.apiInfo(new ApiInfoBuilder().title("API Documentation").build());
		// .securitySchemes(securitySchemes())
		// .securityContext(securityContext());
	}

	// Here is an example where we select any api that matches one of these paths
	private Predicate<String> paths()
	{
		return or(regex("/api.*"));
	}
}
