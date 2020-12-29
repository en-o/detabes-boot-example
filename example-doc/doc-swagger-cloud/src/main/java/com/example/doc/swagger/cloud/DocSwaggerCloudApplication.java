package com.example.doc.swagger.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author tnnn
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DocSwaggerCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocSwaggerCloudApplication.class, args);
	}

}
