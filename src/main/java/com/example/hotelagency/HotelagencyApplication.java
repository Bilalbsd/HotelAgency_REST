package com.example.hotelagency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@SpringBootApplication
public class HotelagencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelagencyApplication.class, args);
	}

}
