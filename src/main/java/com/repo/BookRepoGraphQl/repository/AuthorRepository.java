package com.repo.BookRepoGraphQl.repository;

import com.repo.BookRepoGraphQl.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository  extends CrudRepository<Author, Long> {
}
