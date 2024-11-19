package org.example.s;

import java.util.ArrayList;
import java.util.List;

class BookManager {
    private List<String> books = new ArrayList<>();

    public void addBook(String book) {
        books.add(book);
    }

    public List<String> getBooks() {
        return books;
    }

    public void displayBooks() {
        System.out.println("Books: " + books);
    }

}