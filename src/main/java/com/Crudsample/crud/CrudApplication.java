package com.Crudsample.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(CrudApplication.class, args);
	}

}