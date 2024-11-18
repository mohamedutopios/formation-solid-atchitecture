### **Rappels des principes SOLID**

Les principes **SOLID** sont un ensemble de règles conçues pour guider le développement de logiciels orientés objet. Ces principes, proposés par Robert C. Martin ("Uncle Bob"), visent à rendre le code plus **modulaire**, **maintenable**, et **facile à tester**.

---

### **1. Single Responsibility Principle (SRP)**
**Principe de responsabilité unique :**
- **Une classe ou un module ne doit avoir qu'une seule raison de changer.**
- Chaque classe doit être responsable d'une seule fonctionnalité ou d'une seule partie du domaine métier.

#### Exemple
**Violation :**
```java
class Report {
    public void generateReport() {
        // Génération de données
    }

    public void printReport() {
        // Impression du rapport
    }
}
```
La classe `Report` mélange deux responsabilités : **générer** et **imprimer** un rapport.

**Correction :**
```java
class ReportGenerator {
    public void generateReport() {
        // Génération de données
    }
}

class ReportPrinter {
    public void printReport() {
        // Impression du rapport
    }
}
```

---

### **2. Open/Closed Principle (OCP)**
**Principe ouvert/fermé :**
- **Un module doit être ouvert à l'extension mais fermé à la modification.**
- Le comportement d'une classe doit pouvoir être étendu sans modifier son code source.

#### Exemple
**Violation :**
```java
class Shape {
    public void draw(String shapeType) {
        if (shapeType.equals("Circle")) {
            // Dessiner un cercle
        } else if (shapeType.equals("Square")) {
            // Dessiner un carré
        }
    }
}
```

Chaque fois qu’un nouveau type de forme est ajouté, il faut modifier `draw`.

**Correction :**
```java
interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        // Dessiner un cercle
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        // Dessiner un carré
    }
}
```
Ici, on peut ajouter une nouvelle forme sans modifier les classes existantes.

---

### **3. Liskov Substitution Principle (LSP)**
**Principe de substitution de Liskov :**
- **Une classe dérivée doit pouvoir remplacer sa classe de base sans altérer le comportement attendu.**
- Le code utilisant une classe parent doit fonctionner avec ses sous-classes sans modification.

#### Exemple
**Violation :**
```java
class Bird {
    public void fly() {
        System.out.println("Flying");
    }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins can't fly");
    }
}
```

Ici, `Penguin` viole le LSP car elle ne peut pas être substituée à `Bird`.

**Correction :**
```java
interface Bird {
    void move();
}

class FlyingBird implements Bird {
    public void move() {
        System.out.println("Flying");
    }
}

class Penguin implements Bird {
    public void move() {
        System.out.println("Swimming");
    }
}
```

---

### **4. Interface Segregation Principle (ISP)**
**Principe de ségrégation des interfaces :**
- **Une classe ne doit pas être obligée de dépendre d'interfaces qu'elle n'utilise pas.**
- Les interfaces doivent être spécifiques à leur usage.

#### Exemple
**Violation :**
```java
interface Animal {
    void fly();
    void swim();
    void run();
}

class Dog implements Animal {
    public void fly() {
        throw new UnsupportedOperationException();
    }
    public void swim() {
        System.out.println("Swimming");
    }
    public void run() {
        System.out.println("Running");
    }
}
```

**Correction :**
```java
interface Swimmer {
    void swim();
}

interface Runner {
    void run();
}

class Dog implements Swimmer, Runner {
    public void swim() {
        System.out.println("Swimming");
    }

    public void run() {
        System.out.println("Running");
    }
}
```

---

### **5. Dependency Inversion Principle (DIP)**
**Principe d'inversion des dépendances :**
- **Les modules de haut niveau ne doivent pas dépendre des modules de bas niveau.**
- Les deux doivent dépendre d'abstractions, et non de détails d'implémentation.

#### Exemple
**Violation :**
```java
class Database {
    public void connect() {
        // Connexion à la base de données
    }
}

class Service {
    private Database db = new Database();

    public void performAction() {
        db.connect();
    }
}
```

**Correction :**
```java
interface Database {
    void connect();
}

class MySQLDatabase implements Database {
    public void connect() {
        // Connexion à MySQL
    }
}

class Service {
    private Database db;

    public Service(Database db) {
        this.db = db;
    }

    public void performAction() {
        db.connect();
    }
}
```

Avec cette approche, `Service` peut fonctionner avec n'importe quelle implémentation de `Database`.

---

### **Résumé des Principes SOLID**

| Principe | But | Résultat |
|----------|-----|----------|
| **SRP** | Une classe a une seule responsabilité. | Code facile à maintenir et à comprendre. |
| **OCP** | Les classes sont ouvertes à l'extension mais fermées à la modification. | Ajout de nouvelles fonctionnalités sans casser l'existant. |
| **LSP** | Les sous-classes doivent respecter le contrat de la classe parent. | Remplaçabilité garantie des sous-classes. |
| **ISP** | Les interfaces doivent être spécifiques à leur usage. | Réduction des dépendances inutiles. |
| **DIP** | Les modules de haut niveau dépendent d'abstractions, pas d'implémentations. | Code flexible et facilement testable. |

---

Ces principes sont les **fondations des bonnes pratiques de conception orientée objet** et permettent de produire du code **robuste, évolutif**, et **maintenable**.