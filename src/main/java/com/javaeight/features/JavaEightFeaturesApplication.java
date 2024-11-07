package com.javaeight.features;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.javaeight.features"})
public class JavaEightFeaturesApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaEightFeaturesApplication.class, args);
	}

}
