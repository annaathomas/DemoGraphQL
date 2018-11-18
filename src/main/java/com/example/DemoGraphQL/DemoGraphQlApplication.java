package com.example.DemoGraphQL;

import com.example.DemoGraphQL.resolver.BookResolver;
import com.example.DemoGraphQL.resolver.Mutation;
import com.example.DemoGraphQL.resolver.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoGraphQlApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoGraphQlApplication.class, args);
	}

	@Bean
	public BookResolver authorResolver() {
		return new BookResolver();
	}

	@Bean
	public Query query() {
		return new Query();
	}

	@Bean
	public Mutation mutation() {
		return new Mutation();
	}
}
