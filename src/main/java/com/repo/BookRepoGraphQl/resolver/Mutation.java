package com.repo.BookRepoGraphQl.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.repo.BookRepoGraphQl.DataHolder;
import com.repo.BookRepoGraphQl.model.Author;
import com.repo.BookRepoGraphQl.model.Book;
import org.springframework.beans.factory.annotation.Autowired;


public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private DataHolder dataHolder;

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        dataHolder.saveAuthor(author);
        return author;
    }

    public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
        Book book = new Book();
        book.setAuthor(new Author(authorId));
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);
        dataHolder.saveBook(book);
        return book;
    }

    public Book updateBookPageCount(Integer pageCount, Long id) {
        Book book = dataHolder.updateBookWithPg(id, pageCount);
        return book;
    }
    public boolean deleteBook(Long id) {
        dataHolder.deleteBook(id);
        return true;
    }
}
