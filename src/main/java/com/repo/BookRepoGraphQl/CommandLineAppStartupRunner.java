package com.repo.BookRepoGraphQl;

import com.repo.BookRepoGraphQl.model.Author;
import com.repo.BookRepoGraphQl.model.Book;
import com.repo.BookRepoGraphQl.repository.AuthorRepository;
import com.repo.BookRepoGraphQl.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void run(String ...args) throws Exception {

        Author author1 = new Author("Anna", "Thomas");
        authorRepository.save(author1);
        Book book1 = new Book("Lod of Rings","782829",1000, author1);
        bookRepository.save(book1);

        Author author2 = new Author("Vishal", "Thomas");
        authorRepository.save(author2);
        Book book2 = new Book("Lod of Rings2","782844",2000, author2);
        bookRepository.save(book2);

        Author author3 = new Author("Joseph", "Thomas");
        authorRepository.save(author3);
        Book book3 = new Book("Lod of Rings3","8899979",3000, author3);
        bookRepository.save(book3);


        bookRepository.save(Arrays.asList(book1, book2, book3));

    }
}
