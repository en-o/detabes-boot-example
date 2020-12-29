package com.detabes.cloud.doc.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author tn
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DocSwaggerCloudAggregateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocSwaggerCloudAggregateApplication.class, args);
	}

}
