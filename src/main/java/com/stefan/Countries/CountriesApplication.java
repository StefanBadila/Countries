package com.stefan.Countries;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class CountriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountriesApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(CountryRepository repository) {
		return args -> {
			// Citim fișierul JSON
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Country>> typeReference = new TypeReference<List<Country>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/countries.json");

			try {
				List<Country> countries = mapper.readValue(inputStream, typeReference);
				repository.saveAll(countries);
				System.out.println("Countries saved");
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		};
	}
}
