package org.example.d.book;

import java.util.List;

public interface BookRepository {
    void addBook(Book book);
    List<Book> getBooks();
}
