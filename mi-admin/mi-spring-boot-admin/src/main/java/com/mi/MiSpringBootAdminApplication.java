package com.mi;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableAdminServer //开启Spring Boot Admin 服务
@EnableDiscoveryClient
@SpringBootApplication
public class MiSpringBootAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiSpringBootAdminApplication.class, args);
	}

}
