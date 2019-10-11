package com.bookasalon.org;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import static org.springframework.boot.SpringApplication.run;

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
                registry.addMapping("/login");
                registry.addMapping("/register");
				registry.addMapping("/");
			}
		};
	}
}
