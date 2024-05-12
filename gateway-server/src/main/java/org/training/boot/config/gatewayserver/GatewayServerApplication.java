package org.training.boot.config.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServerApplication {

	public static void main(String[] args) {
		//SpringApplication.run(GatewayServerApplication.class, args);

		new SpringApplicationBuilder(GatewayServerApplication.class)
				.web(WebApplicationType.REACTIVE)
				.run(args);
	}

}
