package com.mogikanensoftware.scheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:task-config-context.xml")
public class XmlConfiguredTasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(XmlConfiguredTasksApplication.class, args);
	}
}
