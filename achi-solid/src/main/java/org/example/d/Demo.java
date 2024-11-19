package org.example.d;

import org.example.d.book.BookRepository;
import org.example.d.book.FictionBook;
import org.example.d.book.NonFictionBook;
import org.example.d.member.MemberManager;
import org.example.d.member.MemberRepository;
import org.example.d.book.BookManager;
import org.example.d.member.PremiumMember;
import org.example.d.member.RegularMember;

public class Demo {
    public static void main(String[] args) {
        // Initialisation des gestionnaires
        BookRepository bookRepo = new BookManager();
        MemberRepository memberRepo = new MemberManager();
        BorrowManager borrowManager = new BorrowManager(bookRepo, memberRepo);

        // Ajout de livres
        bookRepo.addBook(new FictionBook("The Hobbit"));
        bookRepo.addBook(new NonFictionBook("Sapiens: A Brief History of Humankind"));

        // Ajout de membres
        memberRepo.addMember(new RegularMember("Alice"));
        memberRepo.addMember(new PremiumMember("Bob"));

        // Gestion des emprunts
        borrowManager.borrowBook("The Hobbit", "Alice"); // Succès
        borrowManager.borrowBook("Sapiens: A Brief History of Humankind", "Bob"); // Succès
        borrowManager.borrowBook("The Hobbit", "Bob"); // Déjà emprunté
        borrowManager.borrowBook("Unknown Book", "Alice"); // Livre inexistant

        // Affichage des informations
        Displayable[] displayables = {(Displayable) bookRepo, (Displayable) memberRepo, borrowManager };
        for (Displayable displayable : displayables) {
            displayable.display();
            System.out.println(); // Séparation pour la lisibilité
        }
    }
}
