package org.example.i;

import org.example.i.book.BookManager;
import org.example.i.book.Book;
import org.example.i.book.FictionBook;
import org.example.i.book.NonFictionBook;
import org.example.i.member.MemberManager;
import org.example.i.member.PremiumMember;
import org.example.i.member.RegularMember;
import org.example.i.member.Member;

public class Demo {
    public static void main(String[] args) {
        // Initialisation des gestionnaires
        BookManager bookManager = new BookManager();
        MemberManager memberManager = new MemberManager();
        BorrowManager borrowManager = new BorrowManager();

        // Ajout des livres avec leurs types spécifiques
        bookManager.addBook(new FictionBook("The Hobbit"));
        bookManager.addBook(new NonFictionBook("Sapiens: A Brief History of Humankind"));

        // Ajout des membres
        memberManager.addMember(new PremiumMember("John Doe"));
        memberManager.addMember(new RegularMember("Alice"));

        // Gestion des emprunts
        borrowManager.borrowBook("The Hobbit", "Alice",
                bookManager.getBooks().stream().map(Book::getTitle).toList(),
                memberManager.getMembers().stream().map(Member::getName).toList());

        // Affichage des informations
        Displayable[] displayables = { bookManager, memberManager, borrowManager };
        for (Displayable displayable : displayables) {
            displayable.display();
        }
    }
}
