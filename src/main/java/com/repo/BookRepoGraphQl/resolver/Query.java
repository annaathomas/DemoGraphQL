package com.repo.BookRepoGraphQl.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.repo.BookRepoGraphQl.model.Author;
import com.repo.BookRepoGraphQl.model.Book;
import com.repo.BookRepoGraphQl.repository.AuthorRepository;
import com.repo.BookRepoGraphQl.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public List<Book> findAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    public Book findBookByTitle(String title) {
        Book book = bookRepository.findByTitle(title);
        return book;
    }

    public List<Author> findAllAuthors() {
        return (List<Author>) authorRepository.findAll();
    }

    public long countBooks() {
        return findAllBooks().size();
    }
    public long countAuthors() {
        return findAllAuthors().size();
    }
}
