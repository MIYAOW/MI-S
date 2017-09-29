package com.mi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

@ServletComponentScan
@Configuration
@EnableAutoConfiguration
public class MiPlatformCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiPlatformCenterApplication.class, args);
	}
}
