package edu.study.moviecatalogservice;

/**
 * This class is a client that registers/subscribes in a registry server 
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class MovieCatalogServiceApplication {

	/**
	 * Since we need the RestTemplate object to be singleton 
	 * so we put @Bean which by default in Spring a singleton object 
	 * 
	 * @loadBalanced is used with spring cloud and EurekaServer 
	 * it makes the restTemplate to make a service discovery in EurekaServer
	 * Meaning we ask the restTemplate, don't go to the microService directly
	 * because the URL is not the real one it's just a clue/key to determine
	 * what service you need to discover 
	 */
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	} 
	
	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}
