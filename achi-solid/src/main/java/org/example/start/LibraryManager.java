package org.example.start;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryManager {
    private List<String> books = new ArrayList<>();
    private List<String> members = new ArrayList<>();
    private Map<String, String> borrowedBooks = new HashMap<>();

    public void addBook(String book) {
        books.add(book);
    }

    public void addMember(String member) {
        members.add(member);
    }

    public void borrowBook(String book, String member) {
        if (books.contains(book) && members.contains(member)) {
            borrowedBooks.put(book, member);
            System.out.println(member + " has borrowed " + book);
        } else {
            System.out.println("Either book or member does not exist.");
        }
    }

    public void displayBooks() {
        System.out.println("Books: " + books);
    }

    public void displayMembers() {
        System.out.println("Members: " + members);
    }

    public void displayBorrowedBooks() {
        System.out.println("Borrowed Books: " + borrowedBooks);
    }
}
