package org.example.d;

import org.example.d.book.BookRepository;
import org.example.d.member.MemberRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BorrowManager implements Displayable {

    private final BookRepository bookRepo;
    private final MemberRepository memberRepo;
    private final Map<String, String> borrowedBooks = new HashMap<>();

    public BorrowManager(BookRepository bookRepo, MemberRepository memberRepo) {
        this.bookRepo = bookRepo;
        this.memberRepo = memberRepo;
    }

    public void borrowBook(String book, String member) {
        if (!bookRepo.getBooks().stream().anyMatch(b -> b.getTitle().equals(book))) {
            System.out.println("Book '" + book + "' does not exist.");
            return;
        }
        if (!memberRepo.getMembers().stream().anyMatch(m -> m.getName().equals(member))) {
            System.out.println("Member '" + member + "' does not exist.");
            return;
        }
        if (borrowedBooks.containsKey(book)) {
            System.out.println("Book '" + book + "' is already borrowed by " + borrowedBooks.get(book));
            return;
        }
        borrowedBooks.put(book, member);
        System.out.println("Member '" + member + "' has successfully borrowed '" + book + "'.");
    }

    public void displayBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books are currently borrowed.");
        } else {
            System.out.println("Borrowed Books:");
            borrowedBooks.forEach((book, member) ->
                    System.out.println("- Book: '" + book + "' borrowed by Member: '" + member + "'"));
        }
    }

    @Override
    public void display() {
        displayBorrowedBooks();
    }
}
