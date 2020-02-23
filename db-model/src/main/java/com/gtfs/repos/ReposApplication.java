package com.gtfs.repos;

import com.gtfs.repos.service.DataLoader;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
@Configuration
@EnableSwagger2WebMvc
@Import(SpringDataRestConfiguration.class)
public class ReposApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReposApplication.class, args);
	}

	@Autowired
	DataLoader dataLoader;

	@Bean
	public CommandLineRunner loadData() {
		return args -> {
			System.out.println("Initiated Data Loading ...");
			dataLoader.loadData();
			System.out.println("Completed Data Loading ...");
		};
	}

	@Bean
	public Docket createSwaggerDocument(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
}

