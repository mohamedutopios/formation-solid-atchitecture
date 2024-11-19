package org.example.d.book;

import org.example.d.Displayable;

import java.util.ArrayList;
import java.util.List;

public class BookManager implements Displayable, BookRepository {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void displayBooks() {
        System.out.println("Books:");
        books.forEach(book -> System.out.println("- " + book));
    }

    @Override
    public void display() {
        displayBooks();
    }
}
