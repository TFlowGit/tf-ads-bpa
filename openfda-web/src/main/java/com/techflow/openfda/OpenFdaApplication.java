package com.techflow.openfda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.techflow.openfda.drugs.OpenFdaUseCaseFactory;
import com.techflow.openfda.drugs.SimpleOpenFdaSpringUseCaseFactory;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class OpenFdaApplication
{
	public static void main(String[] args) throws Exception
	{
		SpringApplication.run(OpenFdaApplication.class, args);
	}

	@Bean
	public OpenFdaUseCaseFactory useCaseFactory(OpenFdaGateway fdaGateway)
	{
		return new SimpleOpenFdaSpringUseCaseFactory(fdaGateway);
	}

	@Bean
	public OpenFdaGateway fdaGateway()
	{
		return new OpenFdaGatewayImpl();
	}
}
