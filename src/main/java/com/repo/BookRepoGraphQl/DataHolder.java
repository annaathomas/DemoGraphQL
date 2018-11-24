package com.repo.BookRepoGraphQl;

import com.repo.BookRepoGraphQl.model.Author;
import com.repo.BookRepoGraphQl.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DataHolder {

    private long idCou=22;
    private long booIdCou=12;

    private  List<Book> books;
    private  List<Author> authors;
    public  Map<Long, Author> authIsAuthMap = new HashMap();

     {
        books = new ArrayList<>();
        authors = new ArrayList<>();
        Author author1 = new Author(20l,"Anna", "Thomas");
        Book book1 = new Book("Lod of Rings","782829",1000, author1);
        book1.setId(10l);

        Author author2 = new Author(21l,"Vishal", "Thomas");
        Book book2 = new Book("Lod of Rings2","782844",2000, author2);
         book2.setId(11l);

        Author author3 = new Author(22l,"Joseph", "Thomas");
        Book book3 = new Book("Lod of Rings3","8899979",3000, author3);
         book3.setId(12l);

        authIsAuthMap.put(20l, author1);
        authIsAuthMap.put(21l, author2);
        authIsAuthMap.put(22l, author3);

        books.add(book1);
        books.add(book2);
        books.add(book3);

        authors.add(author1);
        authors.add(author2);
        authors.add(author3);

    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Author> getAuthorts() {
        return authors;
    }

    public  void saveBook(Book book) {
         book.setId(++booIdCou);
        books.add(book);
    }

    public  void saveAuthor(Author author) {
         author.setId(idCou++);
        authors.add(author);
    }


    public void deleteBook(Long id) {
        int i=0;
        for (Book book:books) {
            if (book.getId().equals(id)) {
                books.remove(i);
                i++;
            }

        }
    }

    public Book updateBookWithPg(Long id, Integer pageCount) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                book.setPageCount(pageCount);
                return book;
            }
        }
        return null;
    }

    public Book getBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return  null;
    }
}
