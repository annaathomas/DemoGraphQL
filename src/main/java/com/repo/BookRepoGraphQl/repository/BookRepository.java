package com.repo.BookRepoGraphQl.repository;

import com.repo.BookRepoGraphQl.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository  extends CrudRepository<Book, Long> {
    public Book findByTitle(String title);
}
