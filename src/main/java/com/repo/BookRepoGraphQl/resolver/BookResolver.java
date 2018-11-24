package com.repo.BookRepoGraphQl.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.repo.BookRepoGraphQl.DataHolder;
import com.repo.BookRepoGraphQl.model.Author;
import com.repo.BookRepoGraphQl.model.Book;
import com.repo.BookRepoGraphQl.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BookResolver implements GraphQLResolver<Book> {
    @Autowired
    private AuthorRepository authorRepository;

    public Author getAuthor(Book book) {
        return authorRepository.findOne(book.getAuthor().getId());
    }

}
