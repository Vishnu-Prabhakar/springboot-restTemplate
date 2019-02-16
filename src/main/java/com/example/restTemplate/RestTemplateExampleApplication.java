package com.example.restTemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class RestTemplateExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestTemplateExampleApplication.class, args);
	}

	@RequestMapping(value = "/consume", produces = { "application/JSON" })
	@ResponseBody
	public Quote getBasketMissionByVersion() {

		RestTemplate restTemplate = new RestTemplate();
		Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		return quote;
	}

}
