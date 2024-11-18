### Application du **Principe de Substitution de Liskov (LSP)**

Le **Principe de Substitution de Liskov (LSP)** stipule que les sous-classes doivent pouvoir être utilisées à la place de leurs classes parent sans modifier le comportement attendu. Cela signifie que toute sous-classe doit respecter les contrats définis par la classe de base.

---

### Exemple : Gestion de Livres avec Emprunts

#### Contexte
Nous avons une classe de base `BorrowingManager` pour gérer les emprunts, et nous voulons ajouter des variantes pour les emprunts spécifiques :
1. Emprunt standard.
2. Emprunt avec une durée limitée.
3. Emprunt pour une catégorie spécifique.

---

### 1. **Violation du LSP**

#### Code Non-SOLID

```java
class BorrowingManager {
    public void borrowBook(String member, String book) {
        System.out.println(member + " borrowed " + book + " (Standard)");
    }
}

class LimitedBorrowingManager extends BorrowingManager {
    @Override
    public void borrowBook(String member, String book) {
        throw new UnsupportedOperationException("Limited borrowing not supported in this context.");
    }
}
```

#### Problème
1. **Violation du Contrat de la Classe Parent** :
   - `LimitedBorrowingManager` brise le comportement attendu en lançant une exception. Un utilisateur qui s'attend à utiliser `BorrowingManager` sera surpris par ce comportement inattendu.

2. **Impact** :
   - Cela peut entraîner des bugs dans le code client ou des échecs au moment de l’exécution.

#### Exemple d'utilisation problématique

```java
public class Main {
    public static void main(String[] args) {
        BorrowingManager manager = new LimitedBorrowingManager();
        manager.borrowBook("Alice", "The Great Gatsby"); // Lance une exception !
    }
}
```

---

### 2. **Respect du LSP**

Pour respecter le LSP, nous créons une hiérarchie de classes où chaque sous-classe respecte les comportements définis par la classe de base.

---

#### Étape 1 : Définir une Abstraction Générique

La classe de base définit un contrat pour tous les types d'emprunts.

```java
abstract class BorrowingManager {
    public abstract void borrowBook(String member, String book);
}
```

---

#### Étape 2 : Implémenter des Comportements Spécifiques

##### Emprunt Standard

```java
class StandardBorrowingManager extends BorrowingManager {
    @Override
    public void borrowBook(String member, String book) {
        System.out.println(member + " borrowed " + book + " (Standard)");
    }
}
```

##### Emprunt avec Durée Limitée

```java
class LimitedBorrowingManager extends BorrowingManager {
    private int maxDays;

    public LimitedBorrowingManager(int maxDays) {
        this.maxDays = maxDays;
    }

    @Override
    public void borrowBook(String member, String book) {
        System.out.println(member + " borrowed " + book + " for a maximum of " + maxDays + " days.");
    }
}
```

##### Emprunt pour Catégorie Spécifique

```java
class CategoryBorrowingManager extends BorrowingManager {
    private String allowedCategory;

    public CategoryBorrowingManager(String allowedCategory) {
        this.allowedCategory = allowedCategory;
    }

    @Override
    public void borrowBook(String member, String book) {
        System.out.println(member + " borrowed " + book + " (Category: " + allowedCategory + ")");
    }
}
```

---

### Étape 3 : Utilisation Correcte

Avec ces implémentations, chaque sous-classe respecte les comportements définis par la classe de base. Le code client peut utiliser n’importe quelle sous-classe sans se soucier de la logique interne.

#### Exemple

```java
public class Main {
    public static void main(String[] args) {
        BorrowingManager standardManager = new StandardBorrowingManager();
        BorrowingManager limitedManager = new LimitedBorrowingManager(7);
        BorrowingManager categoryManager = new CategoryBorrowingManager("VIP");

        standardManager.borrowBook("Alice", "The Great Gatsby");
        limitedManager.borrowBook("Bob", "1984");
        categoryManager.borrowBook("Charlie", "To Kill a Mockingbird");
    }
}
```

#### Résultat
```
Alice borrowed The Great Gatsby (Standard)
Bob borrowed 1984 for a maximum of 7 days.
Charlie borrowed To Kill a Mockingbird (Category: VIP)
```

---

### Avantages de cette Refactorisation

1. **Respect du LSP** :
   - Toutes les sous-classes respectent le contrat défini par la classe de base. Elles peuvent être utilisées en toute sécurité dans n’importe quel contexte qui attend un `BorrowingManager`.

2. **Comportements Prévisibles** :
   - Aucun comportement inattendu (comme une exception) ne sera introduit par une sous-classe.

3. **Extensibilité** :
   - De nouveaux types d'emprunts peuvent être ajoutés sans affecter les comportements existants.

4. **Testabilité Améliorée** :
   - Chaque sous-classe peut être testée indépendamment en tant qu’implémentation de la classe de base.

---

### Résumé

En respectant le **Principe de Substitution de Liskov (LSP)** :
- Chaque sous-classe respecte le contrat défini par la classe parent.
- Les sous-classes ne changent pas le comportement attendu pour le code client.
- L’approche améliore la robustesse, la maintenabilité et la sécurité du code.