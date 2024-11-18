### Application du **Principe Ouvert/Fermé (OCP)**

Le **Principe Ouvert/Fermé (OCP)** stipule que les composants doivent être **ouverts à l'extension** mais **fermés à la modification**. Cela signifie que vous devez pouvoir ajouter de nouvelles fonctionnalités sans modifier le code existant, en utilisant des abstractions et du polymorphisme.

---

### Exemple : Gestion des Emprunts de Livres

#### Contexte
Vous gérez des emprunts de livres, mais les conditions d'emprunt peuvent évoluer. Par exemple :
1. Emprunt standard : Un membre peut emprunter un livre.
2. Emprunt avec durée : Vous ajoutez une logique pour spécifier une date de retour.
3. Emprunt par catégorie : Vous ajoutez une logique pour limiter les emprunts selon des règles spécifiques (ex. : catégorie de membre).

---

### 1. **Violation du OCP**

Dans une implémentation non SOLID, vous modifiez directement la méthode `borrowBook` chaque fois que de nouvelles règles d'emprunt sont ajoutées.

#### Code Non-SOLID

```java
class BorrowingManager {
    private Map<String, String> borrowings = new HashMap<>(); // Membre -> Livre

    public void borrowBook(String member, String book, String type) {
        if (type.equals("standard")) {
            borrowings.put(member, book);
            System.out.println(member + " borrowed " + book + " (Standard)");
        } else if (type.equals("withDuration")) {
            borrowings.put(member, book);
            System.out.println(member + " borrowed " + book + " with a return date.");
        } else if (type.equals("categoryBased")) {
            // Règles spécifiques pour la catégorie
            borrowings.put(member, book);
            System.out.println(member + " borrowed " + book + " (Category Based)");
        } else {
            System.out.println("Unknown borrowing type.");
        }
    }
}
```

#### Problèmes

1. **Violation du OCP** :
   - Chaque nouveau type d'emprunt nécessite une modification de la méthode `borrowBook`.
   - Si vous ajoutez une nouvelle règle d'emprunt, vous risquez de casser les comportements existants.

2. **Code difficile à maintenir** :
   - La méthode devient de plus en plus complexe à mesure que de nouvelles conditions sont ajoutées.

3. **Testabilité réduite** :
   - Tester une logique nécessite de vérifier tous les cas dans la même méthode.

---

### 2. **Respect du OCP**

Pour respecter le principe OCP, nous utilisons une abstraction pour représenter les différents types d'emprunts. Cela permet d'ajouter de nouveaux comportements sans modifier le code existant.

---

#### Étape 1 : Créer une Abstraction pour les Emprunts

Nous définissons une interface `BorrowingStrategy` qui représente la logique d'emprunt.

```java
interface BorrowingStrategy {
    void borrow(String member, String book);
}
```

---

#### Étape 2 : Implémenter des Stratégies d'Emprunt

Chaque règle d'emprunt est implémentée comme une classe séparée.

##### Emprunt Standard

```java
class StandardBorrowing implements BorrowingStrategy {
    @Override
    public void borrow(String member, String book) {
        System.out.println(member + " borrowed " + book + " (Standard)");
    }
}
```

##### Emprunt avec Durée

```java
class DurationBorrowing implements BorrowingStrategy {
    private String returnDate;

    public DurationBorrowing(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public void borrow(String member, String book) {
        System.out.println(member + " borrowed " + book + " with a return date: " + returnDate);
    }
}
```

##### Emprunt par Catégorie

```java
class CategoryBasedBorrowing implements BorrowingStrategy {
    private String memberCategory;

    public CategoryBasedBorrowing(String memberCategory) {
        this.memberCategory = memberCategory;
    }

    @Override
    public void borrow(String member, String book) {
        System.out.println(member + " borrowed " + book + " (Category: " + memberCategory + ")");
    }
}
```

---

#### Étape 3 : Implémenter un Gestionnaire Générique

Le gestionnaire d'emprunts délègue la logique d'emprunt à une stratégie spécifique.

```java
class BorrowingManager {
    private BorrowingStrategy borrowingStrategy;

    public BorrowingManager(BorrowingStrategy borrowingStrategy) {
        this.borrowingStrategy = borrowingStrategy;
    }

    public void borrowBook(String member, String book) {
        borrowingStrategy.borrow(member, book);
    }
}
```

---

### 3. **Utilisation**

Voici comment vous pouvez utiliser le gestionnaire d'emprunts avec différentes stratégies, sans modifier le code du gestionnaire.

#### Exemple

```java
public class Main {
    public static void main(String[] args) {
        // Emprunt standard
        BorrowingManager standardManager = new BorrowingManager(new StandardBorrowing());
        standardManager.borrowBook("Alice", "The Great Gatsby");

        // Emprunt avec durée
        BorrowingManager durationManager = new BorrowingManager(new DurationBorrowing("2024-12-01"));
        durationManager.borrowBook("Bob", "1984");

        // Emprunt par catégorie
        BorrowingManager categoryManager = new BorrowingManager(new CategoryBasedBorrowing("VIP"));
        categoryManager.borrowBook("Charlie", "To Kill a Mockingbird");
    }
}
```

---

### Avantages de la Refactorisation

1. **Respect du OCP** :
   - Vous pouvez ajouter de nouvelles règles d'emprunt en créant une nouvelle implémentation de `BorrowingStrategy`, sans modifier le gestionnaire.

2. **Maintenance Simplifiée** :
   - Chaque règle d'emprunt est isolée dans une classe dédiée, facilitant sa modification ou son extension.

3. **Testabilité Améliorée** :
   - Chaque stratégie peut être testée indépendamment, sans affecter les autres comportements.

4. **Flexibilité** :
   - Le gestionnaire d'emprunts peut être configuré dynamiquement avec n'importe quelle stratégie.

---

### Résumé

En respectant le **Principe Ouvert/Fermé (OCP)** :
- **Le code existant reste intact** lorsque de nouvelles fonctionnalités sont ajoutées.
- **Les comportements sont extensibles** via des abstractions et des implémentations spécifiques.
- L'approche améliore la modularité, la maintenabilité, et la testabilité du système.