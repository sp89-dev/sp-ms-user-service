package sp.ms.feign.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

// Enable Feign Client using @EnableFeignClients
// Note that @EnableFeignClients annotation enables component scanning for interfaces that declare they are Feign clients.
@SpringBootApplication
@EnableFeignClients
public class UserServiceFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceFeignApplication.class, args);
	}

}
