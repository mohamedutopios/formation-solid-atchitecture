### **Exemple d'API : Gestion des Commandes pour un e-commerce**
Dans cet exemple, nous allons concevoir une API REST pour gérer les commandes dans un système e-commerce. Nous appliquerons les principes SOLID, analyserons les tensions qu'ils génèrent, et visualiserons ces tensions sous forme d'un **diagramme de tension**.

---

### **Contexte**
L'API gère les fonctionnalités suivantes :
1. Créer une commande.
2. Récupérer une commande par ID.
3. Mettre à jour une commande.
4. Supprimer une commande.

#### **Architecture initiale (anti-pattern)**
Une seule classe `OrderController` :
- Valide les données entrantes.
- Contient la logique métier (calcul du total, gestion des stocks).
- Interagit directement avec la base de données.

#### **Problèmes**
- **SRP** : Trop de responsabilités dans une seule classe.
- **OCP** : Ajouter une nouvelle fonctionnalité (par ex. : "annuler une commande") nécessite de modifier la classe existante.
- **DIP** : Dépend directement des implémentations concrètes (par ex. : `OrderRepository`).
- **ISP** : L'interface `OrderService` oblige les clients inutilisés à implémenter toutes les fonctionnalités (par ex. : un service n'ayant besoin que de la lecture doit implémenter aussi l'écriture).
- **LSP** : Une mauvaise implémentation de sous-classes (par ex. : un `SpecialOrder` avec des contraintes spécifiques) pourrait briser le comportement attendu.

---

### **Refactoring avec SOLID**
Nous appliquons les principes SOLID pour améliorer l'architecture.

#### **1. Single Responsibility Principle (SRP)**
Découpons les responsabilités :
- `OrderController` : Gère uniquement les requêtes HTTP.
- `OrderValidator` : Valide les données des commandes.
- `OrderService` : Contient la logique métier.
- `OrderRepository` : Gère l'accès à la base de données.

#### **2. Open/Closed Principle (OCP)**
- Ajoutons une interface `IOrderRepository` pour permettre des implémentations différentes (par ex. : base SQL, base NoSQL).
- Utilisons le patron de stratégie pour le calcul des remises, permettant d’ajouter de nouveaux types de remises sans modifier le code existant.

#### **3. Liskov Substitution Principle (LSP)**
- Utilisons des sous-classes cohérentes pour les commandes (`RegularOrder`, `SpecialOrder`) sans modifier le comportement attendu.
- Respectons les signatures et contrats des méthodes.

#### **4. Interface Segregation Principle (ISP)**
Divisons l'interface `OrderService` en interfaces plus spécifiques :
- `IOrderReader` : Méthodes de lecture (`getOrderById`, `getAllOrders`).
- `IOrderWriter` : Méthodes d'écriture (`createOrder`, `updateOrder`, `deleteOrder`).

#### **5. Dependency Inversion Principle (DIP)**
- Utilisons des abstractions (interfaces) pour injecter `IOrderRepository` et `INotificationService` dans `OrderService`.

---

### **Code après refactoring**

#### **Exemple de code**

##### Interfaces
```java
public interface IOrderReader {
    Order getOrderById(int id);
    List<Order> getAllOrders();
}

public interface IOrderWriter {
    void createOrder(Order order);
    void updateOrder(int id, Order order);
    void deleteOrder(int id);
}
```

##### Classe `OrderController`
```java
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final IOrderReader orderReader;
    private final IOrderWriter orderWriter;

    public OrderController(IOrderReader orderReader, IOrderWriter orderWriter) {
        this.orderReader = orderReader;
        this.orderWriter = orderWriter;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable int id) {
        return ResponseEntity.ok(orderReader.getOrderById(id));
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody Order order) {
        orderWriter.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
```

##### Implémentation `OrderService`
```java
public class OrderService implements IOrderReader, IOrderWriter {

    private final IOrderRepository orderRepository;
    private final DiscountStrategy discountStrategy;

    public OrderService(IOrderRepository orderRepository, DiscountStrategy discountStrategy) {
        this.orderRepository = orderRepository;
        this.discountStrategy = discountStrategy;
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    }

    @Override
    public void createOrder(Order order) {
        order.setTotalPrice(discountStrategy.applyDiscount(order));
        orderRepository.save(order);
    }

    // Other methods...
}
```

---

### **Analyse des tensions**

#### Tableau des tensions pour chaque principe

| Principe | Simplicité | Modularité | Flexibilité | Testabilité | Complexité |
|----------|------------|------------|-------------|-------------|------------|
| **SRP**  | 7          | 9          | 8           | 9           | 4          |
| **OCP**  | 5          | 8          | 9           | 8           | 5          |
| **LSP**  | 6          | 8          | 8           | 7           | 5          |
| **ISP**  | 8          | 7          | 8           | 9           | 4          |
| **DIP**  | 5          | 8          | 9           | 9           | 6          |

---

### **Diagramme de tension**
Je vais générer un diagramme radar représentant ces tensions dans un fichier Excel. Un instant.

Le diagramme des tensions pour les principes SOLID appliqués à l'API a été généré.

- [Téléchargez le fichier Excel](sandbox:/mnt/data/SOLID_API_Tensions.xlsx) contenant les données des tensions.
- [Téléchargez le graphique radar au format PNG](sandbox:/mnt/data/SOLID_API_Tensions.png) pour visualiser les tensions.

Ces ressources vous permettent d'explorer les compromis liés à chaque principe dans un cas concret. Si vous souhaitez des ajustements ou d'autres visualisations, faites-le moi savoir ! 😊