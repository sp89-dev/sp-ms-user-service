package sp.ms.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@SpringBootApplication
// @ComponentScan("sp.ms.userservice.Service")
// @EnableJpaRepositories("sp.ms.userservice.Repository")
// @EntityScan("sp.ms.userservice.Entity")
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	//1st way to create a bean of RestTemplate
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	//2nd way to create a bean of RestTemplate
	// Spring 5.0, the RestTemplate class is in maintenance mode.The Spring team recommended using org. springframework.web.reactive.client.WebClient that has a modern API and supports sync, async, and streaming scenarios.
	@Bean
    public WebClient webClient(){
        return WebClient.builder().build();
    }
}
