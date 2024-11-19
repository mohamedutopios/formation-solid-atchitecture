package org.example.l;

import org.example.l.book.BookManager;
import org.example.l.book.FictionBook;
import org.example.l.book.Book;


public class Demo {
    public static void main(String[] args) {
        BookManager bookManager = new BookManager();
        MemberManager memberManager = new MemberManager();
        BorrowManager borrowManager = new BorrowManager();

        bookManager.addBook(new FictionBook("The Hobbit"));
        memberManager.addMember(new RegularMember("Alice"));
        borrowManager.borrowBook("The Hobbit", "Alice",
                bookManager.getBooks().stream().map(Book::getTitle).toList(),
                memberManager.getMembers().stream().map(Member::getName).toList());

        bookManager.displayBooks();
        memberManager.displayMembers();
        borrowManager.displayBorrowedBooks();
    }
}
