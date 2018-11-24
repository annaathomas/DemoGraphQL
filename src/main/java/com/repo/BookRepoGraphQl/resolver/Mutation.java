package com.repo.BookRepoGraphQl.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.repo.BookRepoGraphQl.model.Author;
import com.repo.BookRepoGraphQl.model.Book;
import com.repo.BookRepoGraphQl.repository.AuthorRepository;
import com.repo.BookRepoGraphQl.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public Book updateBookPageCount(Integer pageCount, Long id) {
        Book book = bookRepository.findOne(id);
        book.setPageCount(pageCount);
        return bookRepository.save(book);
    }

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorRepository.save(author);
        return author;
    }

    public Book newBook(String title, String isbn, Integer pageCount, String authorFName, String authorLName) {
        Author author = new Author(authorFName, authorLName);
        Book book = new Book();
        book.setAuthor(author);
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);
        bookRepository.save(book);
        return book;
    }

    public boolean deleteBook(Long id) {
        bookRepository.delete(id);
        return true;
    }
}
