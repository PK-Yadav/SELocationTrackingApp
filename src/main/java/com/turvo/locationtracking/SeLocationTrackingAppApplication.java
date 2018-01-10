package com.turvo.locationtracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * This is main springboot class, responsible to start application.
 *
 * @author pappuy
 * @version 1.0
 */
@SpringBootApplication
public class SeLocationTrackingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeLocationTrackingAppApplication.class, args);
	}
}
