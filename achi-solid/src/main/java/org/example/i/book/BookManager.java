package org.example.i.book;

import org.example.i.Displayable;

import java.util.ArrayList;
import java.util.List;

public class BookManager implements Displayable {
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
