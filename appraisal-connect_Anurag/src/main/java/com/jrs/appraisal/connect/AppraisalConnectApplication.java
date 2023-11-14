package com.jrs.appraisal.connect;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition (
		info = @Info(
				title = "Appraisal Connect Application",
				description = "This is an official app."
		)
)
public class AppraisalConnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppraisalConnectApplication.class, args);
	}


}
