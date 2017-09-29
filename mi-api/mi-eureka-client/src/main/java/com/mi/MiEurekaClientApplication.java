package com.mi;

import com.didispace.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2Doc //启动配置 DD 自制Swagger2
public class MiEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiEurekaClientApplication.class, args);
	}
}
