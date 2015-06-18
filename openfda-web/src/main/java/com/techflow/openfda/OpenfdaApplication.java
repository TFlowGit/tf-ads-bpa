package com.techflow.openfda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.techflow.openfda.drugs.OpenFdaUseCaseFactory;
import com.techflow.openfda.drugs.OpenFsaSpringUseCaseFactory;

@Configuration
@ComponentScan
@EnableAutoConfiguration
// @EnableAutoConfiguration(exclude = WebMvcAutoConfiguration.class)
// @ImportResource("classpath:springmvc-resteasy.xml")
public class OpenfdaApplication // implements WebApplicationInitializer
{
	// @Override
	// public void onStartup(ServletContext servletContext) throws ServletException
	// {
	// servletContext.setInitParameter("resteasy.servlet.mapping.prefix", "/api");
	// }

	public static void main(String[] args) throws Exception
	{
		SpringApplication.run(OpenfdaApplication.class, args);
	}

	@Bean
	public OpenFdaUseCaseFactory useCaseFactory(FdaGateway fdaGateway)
	{
		return new OpenFsaSpringUseCaseFactory(fdaGateway);
	}

	@Bean
	public FdaGateway fdaGateway()
	{
		return new MockFdaGateway();
	}
}
