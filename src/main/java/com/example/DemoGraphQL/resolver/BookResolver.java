package com.example.DemoGraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.DemoGraphQL.DataHolder;
import com.example.DemoGraphQL.model.Author;
import com.example.DemoGraphQL.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class BookResolver implements GraphQLResolver<Book> {
    @Autowired
    private DataHolder dataHolder;

    public Author getAuthor(Book book) {
        return dataHolder.authIsAuthMap.get(book.getAuthor().getId());
    }

}
