package com.techflow.openfda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.techflow.openfda.drug.client.OpenFdaGatewayImpl;
import com.techflow.openfda.drugs.OpenFdaUseCaseFactory;
import com.techflow.openfda.drugs.SimpleOpenFdaSpringUseCaseFactory;

/**
 * Application entry point. Run {@link OpenFdaApplication#main(String[])} to start the server.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class OpenFdaApplication
{
	/**
	 * Create the use case factory.
	 */
	@Bean
	public OpenFdaUseCaseFactory useCaseFactory(OpenFdaGateway fdaGateway)
	{
		return new SimpleOpenFdaSpringUseCaseFactory(fdaGateway);
	}

	/**
	 * Create the Open FDA gateway for API calls.
	 */
	@Bean
	public OpenFdaGateway openFdaGateway()
	{
		return new OpenFdaGatewayImpl();
	}

	/**
	 * Starts the server on port 8080.
	 */
	public static void main(String[] args) throws Exception
	{
		SpringApplication.run(OpenFdaApplication.class, args);
	}
}
