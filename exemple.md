Voici une démonstration en Java avec une classe unique qui ne respecte aucun des principes SOLID. Ensuite, nous corrigerons chaque principe étape par étape.

---

### Étape 1 : Code initial sans respect de SOLID

La classe unique `LibraryManager` gère à la fois les livres, les membres et les emprunts.

```java
import java.util.*;

class LibraryManager {
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

public class Main {
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
```

---

### Étape 2 : Correction du "S" (Single Responsibility Principle)

Chaque classe doit avoir une responsabilité unique. Nous divisons `LibraryManager` en plusieurs classes.

```java
import java.util.*;

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

class MemberManager {
    private List<String> members = new ArrayList<>();

    public void addMember(String member) {
        members.add(member);
    }

    public List<String> getMembers() {
        return members;
    }

    public void displayMembers() {
        System.out.println("Members: " + members);
    }
}

class BorrowManager {
    private Map<String, String> borrowedBooks = new HashMap<>();

    public void borrowBook(String book, String member, List<String> books, List<String> members) {
        if (books.contains(book) && members.contains(member)) {
            borrowedBooks.put(book, member);
            System.out.println(member + " has borrowed " + book);
        } else {
            System.out.println("Either book or member does not exist.");
        }
    }

    public void displayBorrowedBooks() {
        System.out.println("Borrowed Books: " + borrowedBooks);
    }
}

public class Main {
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
```

---

### Étape 3 : Correction du "O" (Open/Closed Principle)

Nous rendons le système extensible sans modifier les classes existantes. Les livres deviennent une entité avec différents types.

```java
class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

class FictionBook extends Book {
    public FictionBook(String title) {
        super(title);
    }
}

class NonFictionBook extends Book {
    public NonFictionBook(String title) {
        super(title);
    }
}

class BookManager {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void displayBooks() {
        books.forEach(book -> System.out.println("Book: " + book.getTitle()));
    }
}

public class Main {
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
```

---

### Étape 4 : Correction du "L" (Liskov Substitution Principle)

Nous utilisons une interface commune pour les membres.

```java
interface Member {
    String getName();
}

class RegularMember implements Member {
    private String name;

    public RegularMember(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

class PremiumMember implements Member {
    private String name;

    public PremiumMember(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

class MemberManager {
    private List<Member> members = new ArrayList<>();

    public void addMember(Member member) {
        members.add(member);
    }

    public List<Member> getMembers() {
        return members;
    }

    public void displayMembers() {
        members.forEach(member -> System.out.println("Member: " + member.getName()));
    }
}

public class Main {
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
```

---

### Étape 5 : Correction du "I" (Interface Segregation Principle)

On divise les interfaces pour éviter que les classes n’implémentent des méthodes inutiles.

```java
interface Displayable {
    void display();
}

class BookManager implements Displayable {
    // (Same as before)

    @Override
    public void display() {
        displayBooks();
    }
}

class MemberManager implements Displayable {
    // (Same as before)

    @Override
    public void display() {
        displayMembers();
    }
}

class BorrowManager implements Displayable {
    // (Same as before)

    @Override
    public void display() {
        displayBorrowedBooks();
    }
}
```

---

### Étape 6 : Correction du "D" (Dependency Inversion Principle)

Les classes dépendent d'abstractions, pas d'implémentations.

```java
interface BookRepository {
    void addBook(Book book);
    List<Book> getBooks();
}

class BookManager implements BookRepository {
    // Implementation remains the same.
}

interface MemberRepository {
    void addMember(Member member);
    List<Member> getMembers();
}

class MemberManager implements MemberRepository {
    // Implementation remains the same.
}

class BorrowManager {
    private final BookRepository bookRepo;
    private final MemberRepository memberRepo;

    public BorrowManager(BookRepository bookRepo, MemberRepository memberRepo) {
        this.bookRepo = bookRepo;
        this.memberRepo = memberRepo;
    }

    public void borrowBook(String book, String member) {
        if (bookRepo.getBooks().stream().anyMatch(b -> b.getTitle().equals(book)) &&
            memberRepo.getMembers().stream().anyMatch(m -> m.getName().equals(member))) {
            System.out.println(member + " has borrowed " + book);
        } else {
            System.out.println("Either book or member does not exist.");
        }
    }
}
```

---

Avec cette approche progressive, nous avons refactoré le code pour respecter les principes SOLID. Chaque étape est autonome et améliore un aspect précis du design.