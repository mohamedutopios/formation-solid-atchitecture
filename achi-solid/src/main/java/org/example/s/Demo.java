package org.example.s;

public class Demo {
    public static void main(String[] args) {
        BookManager bookManager = new BookManager();
        MemberManager memberManager = new MemberManager();
        BorrowManager borrowManager = new BorrowManager();

        bookManager.addBook("The Hobbit");
        memberManager.addMember("Alice");
        borrowManager.borrowBook("The Hobbit", "Alice", bookManager.getBooks(), memberManager.getMembers());

        bookManager.displayBooks();
        memberManager.displayMembers();
        borrowManager.displayBorrowedBooks();
    }
}
