package com.example.DemoGraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.DemoGraphQL.DataHolder;
import com.example.DemoGraphQL.model.Author;
import com.example.DemoGraphQL.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


public class Query implements GraphQLQueryResolver {

    @Autowired
    private DataHolder dataHolder;

    public Iterable<Book> findAllBooks() {
        List<Book> books=  dataHolder.getBooks();
        System.out.println(books);
        return books;

    }

    public Book findBookByTitle(String title) {
        Book book =  dataHolder.getBookByTitle(title);
        return book;

    }

    public Iterable<Author> findAllAuthors() {
        return dataHolder.getAuthorts();
    }

    public long countBooks() {
        return dataHolder.getBooks().size();
    }
    public long countAuthors() {
        return dataHolder.getAuthorts().size();
    }
}
