package com.repo.BookRepoGraphQl.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.repo.BookRepoGraphQl.DataHolder;
import com.repo.BookRepoGraphQl.model.Author;
import com.repo.BookRepoGraphQl.model.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class Query implements GraphQLQueryResolver {

    @Autowired
    private DataHolder dataHolder;

    public Iterable<Book> findAllBooks() {
        List<Book> books=  dataHolder.getBooks();
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
