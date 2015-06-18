package com.techflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan
@EnableAutoConfiguration(exclude = WebMvcAutoConfiguration.class)
@ImportResource("classpath:springmvc-resteasy.xml")
public class OpenfdaApplication
{
	public static void main(String[] args) throws Exception
	{
		SpringApplication.run(OpenfdaApplication.class, args);
	}
}
