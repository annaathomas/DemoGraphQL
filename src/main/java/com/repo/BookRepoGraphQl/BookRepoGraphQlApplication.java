package com.repo.BookRepoGraphQl;

import com.repo.BookRepoGraphQl.resolver.BookResolver;
import com.repo.BookRepoGraphQl.resolver.Mutation;
import com.repo.BookRepoGraphQl.resolver.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookRepoGraphQlApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookRepoGraphQlApplication.class, args);
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
