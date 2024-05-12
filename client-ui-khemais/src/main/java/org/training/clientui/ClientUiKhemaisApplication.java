package org.training.clientui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("org.training.clientui")
@EnableDiscoveryClient
public class ClientUiKhemaisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientUiKhemaisApplication.class, args);
	}

}
