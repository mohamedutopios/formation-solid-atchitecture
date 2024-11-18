### Appliquer le **Single Responsibility Principle (SRP)** à l’échelle des composants

L'application du SRP à l'échelle des composants consiste à s'assurer que chaque **composant** d'une application a une seule responsabilité métier bien définie. Cela permet de limiter les impacts des modifications et d'assurer une modularité et une testabilité optimales.

#### Exemple : Gestion d'une Bibliothèque

Imaginons une application composée de trois responsabilités principales :
1. Gestion des livres.
2. Gestion des membres.
3. Gestion des emprunts.

---

### 1. **Architecture Non-SOLID**

Dans une architecture non SOLID, toutes ces responsabilités pourraient être regroupées dans un seul composant `LibraryComponent`, entraînant des problèmes de couplage et de maintenance.

#### Code Non-SOLID

```java
class LibraryComponent {
    // Gestion des livres
    public void addBook(String title, String author) {
        System.out.println("Book added: " + title + " by " + author);
    }

    public void listBooks() {
        System.out.println("Listing all books...");
    }

    // Gestion des membres
    public void addMember(String name) {
        System.out.println("Member added: " + name);
    }

    public void listMembers() {
        System.out.println("Listing all members...");
    }

    // Gestion des emprunts
    public void borrowBook(String memberName, String bookTitle) {
        System.out.println(memberName + " borrowed " + bookTitle);
    }

    public void returnBook(String memberName, String bookTitle) {
        System.out.println(memberName + " returned " + bookTitle);
    }
}
```

---

### Problèmes Concrets dans cette Architecture

1. **Responsabilités multiples** :
   - Gestion des livres, membres et emprunts sont mélangées dans une seule classe.
   - Un changement dans l'une des responsabilités pourrait affecter les autres.

2. **Difficulté de maintenance** :
   - Si la logique métier liée aux emprunts évolue, vous devrez potentiellement répercuter des modifications dans d'autres méthodes.

3. **Testabilité limitée** :
   - Les tests unitaires ne peuvent pas se concentrer sur une seule responsabilité sans être affectés par les autres.

---

### 2. **Architecture Respectant le SRP**

Pour appliquer le SRP, nous séparons les responsabilités dans des **composants distincts** :
1. **BookComponent** pour gérer les livres.
2. **MemberComponent** pour gérer les membres.
3. **BorrowingComponent** pour gérer les emprunts.

#### Code Refactorisé

##### Gestion des livres

```java
class BookComponent {
    public void addBook(String title, String author) {
        System.out.println("Book added: " + title + " by " + author);
    }

    public void listBooks() {
        System.out.println("Listing all books...");
    }
}
```

##### Gestion des membres

```java
class MemberComponent {
    public void addMember(String name) {
        System.out.println("Member added: " + name);
    }

    public void listMembers() {
        System.out.println("Listing all members...");
    }
}
```

##### Gestion des emprunts

```java
class BorrowingComponent {
    public void borrowBook(String memberName, String bookTitle) {
        System.out.println(memberName + " borrowed " + bookTitle);
    }

    public void returnBook(String memberName, String bookTitle) {
        System.out.println(memberName + " returned " + bookTitle);
    }
}
```

##### Coordination via un composant central (optionnel)

Pour orchestrer ces composants, on peut introduire un **LibraryCoordinator**.

```java
class LibraryCoordinator {
    private BookComponent bookComponent;
    private MemberComponent memberComponent;
    private BorrowingComponent borrowingComponent;

    public LibraryCoordinator() {
        this.bookComponent = new BookComponent();
        this.memberComponent = new MemberComponent();
        this.borrowingComponent = new BorrowingComponent();
    }

    public void addBook(String title, String author) {
        bookComponent.addBook(title, author);
    }

    public void addMember(String name) {
        memberComponent.addMember(name);
    }

    public void borrowBook(String memberName, String bookTitle) {
        borrowingComponent.borrowBook(memberName, bookTitle);
    }
}
```

---

### 3. **Avantages de l’Application du SRP**

1. **Modularité accrue** :
   - Chaque composant gère une seule responsabilité, facilitant les modifications et les extensions.

2. **Testabilité améliorée** :
   - Les tests unitaires peuvent être ciblés sur un seul composant sans affecter les autres.

3. **Maintenance facilitée** :
   - Une modification dans la gestion des livres n'aura aucun impact sur la gestion des membres ou des emprunts.

---

### 4. **Exemple d’Utilisation**

```java
public class Main {
    public static void main(String[] args) {
        LibraryCoordinator library = new LibraryCoordinator();

        // Gestion des livres
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald");

        // Gestion des membres
        library.addMember("Alice");

        // Gestion des emprunts
        library.borrowBook("Alice", "The Great Gatsby");
    }
}
```

---

### Résumé

En appliquant le **Single Responsibility Principle** à l'échelle des composants :
- **Chaque composant a une seule raison de changer** (un domaine métier spécifique).
- **Les responsabilités sont bien isolées**, ce qui améliore la modularité, la maintenabilité, et la testabilité.
- **Une coordination est possible** via un composant central (facultatif), sans violer le principe.
