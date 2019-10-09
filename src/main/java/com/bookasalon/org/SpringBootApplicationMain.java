package com.bookasalon.org;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import static org.springframework.boot.SpringApplication.*;

@SpringBootApplication
public class SpringBootApplicationMain {
	public static void main(String[] args) {
		run(SpringBootApplicationMain.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/login").allowedOrigins("http://localhost:3000");
				registry.addMapping("/register").allowedOrigins("http://localhost:3000");
			}
		};
	}
}
