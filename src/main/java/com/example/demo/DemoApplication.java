package com.example.demo;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {
	final Logger log = LoggerFactory.getLogger("Logger");
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		log.info("/hello");
		return String.format("Hello %s!", name);
	}

	@GetMapping("/hey/{name}")
	public String hey(@PathVariable(value = "name") String name) {
		log.info("/hey");
		return String.format("Hey %s!", name);
	}
}
