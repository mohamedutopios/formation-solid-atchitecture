Voici une refactorisation basée sur le **Principe de Ségrégation des Interfaces (ISP)**, appliquée à la classe `LibraryComponent`. L'objectif est de séparer les responsabilités en interfaces spécifiques et de réduire les dépendances inutiles entre les fonctionnalités.

---

### Code Non-SOLID

Voici le code initial où toutes les responsabilités sont regroupées dans une seule classe :

```java
class LibraryComponent {
    private List<String> books = new ArrayList<>();
    private List<String> members = new ArrayList<>();
    private Map<String, String> borrowings = new HashMap<>(); // Emprunts : membre -> livre

    public void addBook(String title) {
        books.add(title);
        System.out.println("Book added: " + title);
    }

    public void addMember(String name) {
        members.add(name);
        System.out.println("Member added: " + name);
    }

    public void borrowBook(String member, String book) {
        if (!members.contains(member)) {
            System.out.println("Member does not exist.");
            return;
        }
        if (!books.contains(book)) {
            System.out.println("Book is not available.");
            return;
        }
        borrowings.put(member, book);
        System.out.println(member + " borrowed " + book);
    }
}
```

#### Problèmes
1. **Responsabilités Multiples** :
   - Gestion des livres, des membres et des emprunts dans une seule classe.
   - Toutes les dépendances sont obligatoires, même si certaines ne sont pas utilisées par des composants spécifiques.

2. **Couplage Excessif** :
   - Si la logique d'emprunt change, elle peut affecter les livres ou les membres.

3. **Testabilité Limité** :
   - Tester les emprunts nécessite de simuler à la fois des livres et des membres.

---

### Refactorisation SOLID (Respect du ISP)

#### Étape 1 : Diviser les Interfaces

Chaque responsabilité est isolée dans une interface dédiée :

```java
// Interface pour la gestion des livres
interface BookManager {
    void addBook(String title);
    boolean isBookAvailable(String title);
}

// Interface pour la gestion des membres
interface MemberManager {
    void addMember(String name);
    boolean isMemberExists(String name);
}

// Interface pour la gestion des emprunts
interface BorrowingManager {
    void borrowBook(String member, String book);
}
```

#### Étape 2 : Implémenter les Interfaces

Chaque interface est implémentée par une classe dédiée.

##### Gestion des Livres

```java
class BookManagerImpl implements BookManager {
    private List<String> books = new ArrayList<>();

    @Override
    public void addBook(String title) {
        books.add(title);
        System.out.println("Book added: " + title);
    }

    @Override
    public boolean isBookAvailable(String title) {
        return books.contains(title);
    }
}
```

##### Gestion des Membres

```java
class MemberManagerImpl implements MemberManager {
    private List<String> members = new ArrayList<>();

    @Override
    public void addMember(String name) {
        members.add(name);
        System.out.println("Member added: " + name);
    }

    @Override
    public boolean isMemberExists(String name) {
        return members.contains(name);
    }
}
```

##### Gestion des Emprunts

```java
class BorrowingManagerImpl implements BorrowingManager {
    private Map<String, String> borrowings = new HashMap<>();
    private MemberManager memberManager;
    private BookManager bookManager;

    public BorrowingManagerImpl(MemberManager memberManager, BookManager bookManager) {
        this.memberManager = memberManager;
        this.bookManager = bookManager;
    }

    @Override
    public void borrowBook(String member, String book) {
        if (!memberManager.isMemberExists(member)) {
            System.out.println("Member does not exist.");
            return;
        }
        if (!bookManager.isBookAvailable(book)) {
            System.out.println("Book is not available.");
            return;
        }
        borrowings.put(member, book);
        System.out.println(member + " borrowed " + book);
    }
}
```

---

### Étape 3 : Utilisation

Chaque classe peut maintenant être utilisée de manière indépendante ou combinée selon les besoins.

#### Exemple

```java
public class Main {
    public static void main(String[] args) {
        // Créer les gestionnaires de livres et de membres
        BookManager bookManager = new BookManagerImpl();
        MemberManager memberManager = new MemberManagerImpl();

        // Ajouter des livres et des membres
        bookManager.addBook("The Great Gatsby");
        memberManager.addMember("Alice");

        // Créer le gestionnaire d'emprunts
        BorrowingManager borrowingManager = new BorrowingManagerImpl(memberManager, bookManager);

        // Emprunter un livre
        borrowingManager.borrowBook("Alice", "The Great Gatsby");
    }
}
```

---

### Avantages de la Refactorisation

1. **Responsabilités Séparées** :
   - Chaque classe gère une seule responsabilité : les livres, les membres, ou les emprunts.

2. **Dépendances Réduites** :
   - Les dépendances sont injectées uniquement là où elles sont nécessaires (ex. : `BorrowingManagerImpl` dépend de `BookManager` et `MemberManager`).

3. **Testabilité Améliorée** :
   - Chaque classe peut être testée indépendamment :
     - Tester les livres sans membres ni emprunts.
     - Tester les emprunts avec des mocks pour les livres et les membres.

4. **Extensibilité** :
   - Ajouter une nouvelle fonctionnalité (ex. : gestion des dates de retour) ne nécessite pas de modifier les autres classes.

---

### Résumé

Le **Principe de Ségrégation des Interfaces (ISP)** nous permet de diviser une interface ou une classe trop large en plusieurs interfaces spécifiques. Dans cet exemple :
- Les interfaces `BookManager`, `MemberManager`, et `BorrowingManager` isolent les responsabilités.
- Les composants dépendent uniquement des interfaces nécessaires à leur rôle, ce qui réduit les dépendances inutiles.
- Le code devient modulaire, maintenable, et extensible.