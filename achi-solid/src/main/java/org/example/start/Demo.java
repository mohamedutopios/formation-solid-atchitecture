package org.example.start;

public class Demo {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        manager.addBook("The Hobbit");
        manager.addMember("Alice");
        manager.borrowBook("The Hobbit", "Alice");
        manager.displayBooks();
        manager.displayMembers();
        manager.displayBorrowedBooks();
    }
}
