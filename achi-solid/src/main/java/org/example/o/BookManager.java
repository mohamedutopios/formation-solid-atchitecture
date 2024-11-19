package org.example.o;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void displayBooks() {
        books.forEach(book -> System.out.println("Book: " + book.getTitle()));
    }
}
