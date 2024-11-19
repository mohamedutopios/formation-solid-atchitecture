package org.example.o;

public class Demo {
    public static void main(String[] args) {
        BookManager bookManager = new BookManager();
        MemberManager memberManager = new MemberManager();
        BorrowManager borrowManager = new BorrowManager();
        bookManager.addBook(new FictionBook("The Hobbit"));
        memberManager.addMember("Alice");
        borrowManager.borrowBook("The Hobbit", "Alice",
                bookManager.getBooks().stream().map(Book::getTitle).toList(),
                memberManager.getMembers());

        bookManager.displayBooks();
        memberManager.displayMembers();
        borrowManager.displayBorrowedBooks();
    }
}
