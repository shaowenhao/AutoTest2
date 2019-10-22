package com.source.code.springboot.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication 
@ComponentScan("com.source.code.springboot.hello.server") 
// Inorder to include the SwaggerConfig which under com.course.config 
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
