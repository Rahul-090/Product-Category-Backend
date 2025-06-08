package com.flipstyle.product;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.ExceptionHandler;

@OpenAPIDefinition(
			info = @Info(
					title = "Product Service REST API documentation",
					description = "Product category REST API",
					version = "V1",
					contact = @Contact(
							name = "Rahul Sharma",
							email = "rs1692992@gmail.com"
					)
			),
		externalDocs = @ExternalDocumentation(
				description = "Product category REST API",
				url = "example.com"
		)

)
@SpringBootApplication

public class ProductApplication {

	private static final Logger log = LoggerFactory.getLogger(ProductApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);

		log.info("Product Service started successfully! ");

	}

}
