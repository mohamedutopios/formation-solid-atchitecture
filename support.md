---
marp: true
title: Kubernetes
theme: utopios
paginate: true
author: Mohamed Aijjou
header: "![h:70px](https://utopios-marp-assets.s3.eu-west-3.amazonaws.com/logo_blanc.svg)"
footer: "Utopios® Tous droits réservés"
---


<!-- _class: lead -->
<!-- _paginate: false -->

# Séminaire sur les Principes SOLID et la Dette Technique

---

## Sommaire

  1. Introduction à l'Architecture Logicielle
  2. Appliquer les principes SOLID aux modules d’une application 
  2. Maintenir la dette technique sous contrôle

</div>

--- 


<!-- _class: lead -->
<!-- _paginate: false -->

## Introduction à l'Architecture Logicielle

---

## Introduction à l'Architecture Logicielle 

#### Définition
<br/>

<div style="font-size:30px">

- L'architecture logicielle implique la définition des composants ou modules d'un système logiciel, ainsi que des interfaces par lesquelles ces modules interagissent. 
- Elle inclut également les directives qui régissent leur interaction, leur intégration, et la stratégie de leur déploiement et maintenance. 
- Les architectes logiciels utilisent divers outils et modèles, comme les diagrammes UML (Unified Modeling Language), pour décrire la structure, le comportement et les interactions des composants au sein du système.

</div>

---

 ## Introduction à l'Architecture Logicielle 

#### Importance de l'Architecture Logicielle
<br/>

<div style="font-size:28px">

1. **Facilite la communication:** L'architecture fournit une vue de haut niveau du système qui est compréhensible pour les parties prenantes à tous les niveaux. Cela aide les développeurs, les gestionnaires de projet, et les parties prenantes non techniques à comprendre le système et ses interactions.

2. **Prise de décision éclairée:** L'architecture sert de support à la prise de décision en offrant une vue globale sur les contraintes techniques et les trade-offs. Cela permet aux décideurs de choisir les meilleures stratégies en fonction des objectifs du projet et des contraintes opérationnelles.

</div>

---

 ## Introduction à l'Architecture Logicielle 

#### Importance de l'Architecture Logicielle
<br/>

<div style="font-size:28px">

3. **Amélioration de la qualité:** Une bonne architecture permet d’assurer la qualité du système en termes de performance, de fiabilité, de réutilisabilité et de sécurité. Elle aide à détecter les problèmes potentiels tôt dans le cycle de développement et à élaborer des stratégies pour les résoudre.

4. **Maintenabilité et évolutivité:** Une architecture bien conçue est flexible et peut évoluer pour répondre à des exigences changeantes sans nécessiter une refonte complète. Elle facilite également la maintenance en organisant le système de manière logique et compréhensible.

</div>

---

 ## Introduction à l'Architecture Logicielle 

#### Importance de l'Architecture Logicielle
<br/>

<div style="font-size:30px">

5. **Réduction des coûts et des risques:** En anticipant les défis techniques et en planifiant à l'avance, une architecture solide réduit les risques associés à la non-conformité aux exigences, les dépassements de coûts, et les échecs dans la mise en œuvre.

6. **Réutilisation des composants:** Une architecture qui encourage la modularité permet la réutilisation de composants dans d'autres systèmes ou projets, ce qui peut accélérer le développement et réduire les coûts.

</div>

---

 ## Introduction à l'Architecture Logicielle 

#### Rôles et responsabilités d'un architecte logiciel
<br/>

<div style="font-size:35px">Rôles de l'Architecte Logiciel</div>

<div style="font-size:25px">

1. **Concepteur de la structure du système:**

- Définit l'architecture globale du système en choisissant les technologies appropriées et en structurant les composants logiciels de manière à répondre aux exigences du projet tout en maximisant la performance et la maintenabilité.
- S'assure que l'architecture choisie respecte à la fois les exigences techniques et les contraintes budgétaires ou de délai.

</div>

---

 ## Introduction à l'Architecture Logicielle 

#### Rôles et responsabilités d'un architecte logiciel
<br/>

<div style="font-size:35px">Rôles de l'Architecte Logiciel</div>

<div style="font-size:29px">

2. **Responsable de la qualité technique:**

- Veille à ce que le système soit robuste, sécurisé, et facile à maintenir.
- Intègre des pratiques et des standards de qualité dans la conception du système, comme les tests, les revues de code, et les métriques de qualité.

</div>

---

 ## Introduction à l'Architecture Logicielle 

#### Rôles et responsabilités d'un architecte logiciel
<br/>

<div style="font-size:35px">Rôles de l'Architecte Logiciel</div>

<div style="font-size:29px">

3. **Coordinateur entre les équipes de développement et les parties prenantes:**

- Assure la communication entre les développeurs, les gestionnaires de projet, les utilisateurs finaux, et les autres parties prenantes pour garantir que l'architecture répond à toutes les exigences et attentes.
- Traduit les exigences techniques pour les parties prenantes non techniques et vice versa.

</div>

---

 ## Introduction à l'Architecture Logicielle 

#### Rôles et responsabilités d'un architecte logiciel
<br/>

<div style="font-size:35px">Rôles de l'Architecte Logiciel</div>

<div style="font-size:29px">

4. **Guide et mentor pour l'équipe de développement:**

- Fournit un leadership technique et des conseils aux développeurs.
- Aide l'équipe à comprendre l'architecture et les principes sous-jacents.
- Organise des formations et des séminaires pour maintenir l'équipe à jour avec les nouvelles technologies et méthodes.

</div>

---

 ## Introduction à l'Architecture Logicielle 

#### Rôles et responsabilités d'un architecte logiciel
<br/>

<div style="font-size:35px">Responsabilités de l'Architecte Logiciel</div>

<div style="font-size:29px">

1. **Définition de l'architecture:**

- Élabore les modèles architecturaux, les plans et les prototypes.
- Définit les normes de codage, les outils et les plateformes à utiliser.
- Assure la cohérence de l'architecture à travers toutes les phases du projet.

</div>

---

 ## Introduction à l'Architecture Logicielle 

#### Rôles et responsabilités d'un architecte logiciel
<br/>

<div style="font-size:35px">Responsabilités de l'Architecte Logiciel</div>

<div style="font-size:29px">

2. **Évaluation et gestion des risques:**

- Identifie les risques techniques potentiels et propose des solutions pour les atténuer.
- Évalue régulièrement l'efficacité de l'architecture actuelle et propose des modifications si nécessaire.

</div>

---

 ## Introduction à l'Architecture Logicielle 

#### Rôles et responsabilités d'un architecte logiciel
<br/>

<div style="font-size:35px">Responsabilités de l'Architecte Logiciel</div>

<div style="font-size:29px">

3. **Optimisation des performances et de l'évolutivité:**

- Conçoit des systèmes capables de s'adapter à l'augmentation des charges de travail ou à l'évolution des exigences sans performances dégradées.
- Analyse les performances du système et identifie les goulets d'étranglement.

</div>

---

 ## Introduction à l'Architecture Logicielle 

#### Rôles et responsabilités d'un architecte logiciel
<br/>

<div style="font-size:35px">Responsabilités de l'Architecte Logiciel</div>

<div style="font-size:29px">

4. **Documentation de l'architecture:**

- Rédige des documents détaillés sur l'architecture pour assurer une référence claire et une maintenance aisée.
- Maintient une documentation à jour à mesure que le système évolue.

</div>

---

 ## Introduction à l'Architecture Logicielle 

#### Rôles et responsabilités d'un architecte logiciel
<br/>

<div style="font-size:35px">Responsabilités de l'Architecte Logiciel</div>

<div style="font-size:29px">

5. **Innovation et recherche:**

- Se tient informé des dernières tendances et technologies en architecture logicielle.
- Explore de nouvelles approches et technologies pour améliorer continuellement la conception du système.

</div>

---

<!-- _class: lead -->
<!-- _paginate: false -->

## Appliquer les principes SOLID aux modules d’une application 

---

 ### Appliquer les principes SOLID aux modules d’une application  


<br/>

<div style="font-size:30px">

#### Definition

</div>


<div style="font-size:26px">

- Les principes **SOLID** sont un ensemble de bonnes pratiques de conception orientée objet, élaborées par Robert C. Martin (alias "Uncle Bob"). 
- Ils visent à rendre le code plus modulaire, maintenable, extensible, et facile à comprendre.

- Ces principes permettent d'éviter les problèmes courants tels que le code spaghetti, les dépendances cycliques, ou les difficultés d'évolution. 
- **SOLID** est un acronyme qui représente cinq principes fondamentaux.

</div>

---
 ### Appliquer les principes SOLID aux modules d’une application 


<div style="font-size:30px">

### **S.O.L.I.D**

</div>

<div style="font-size:20px">

**S - Single Responsibility Principle (SRP) :** Un module ou une classe doit avoir une seule responsabilité ou une seule raison de changer. Cela signifie que chaque classe doit se concentrer sur une seule tâche ou fonction.

**O - Open/Closed Principle (OCP) :** Une entité (classe, module, fonction) doit être ouverte à l'extension mais fermée à la modification. Autrement dit, il doit être possible d’ajouter de nouvelles fonctionnalités sans modifier le code existant.

**L - Liskov Substitution Principle (LSP) :** Les objets d’une classe dérivée doivent pouvoir remplacer les objets de la classe mère sans altérer le bon fonctionnement du programme. Cela implique que les classes filles doivent conserver les comportements et les caractéristiques de la classe mère.

**I - Interface Segregation Principle (ISP) :** Les clients ne doivent pas être forcés de dépendre d'interfaces qu'ils n'utilisent pas. Il vaut mieux avoir plusieurs interfaces spécifiques plutôt qu'une seule interface générale.

**D - Dependency Inversion Principle (DIP) :** Les modules de haut niveau ne doivent pas dépendre des modules de bas niveau. Tous deux doivent dépendre d'abstractions. En d’autres termes, il faut dépendre d’abstractions (interfaces ou classes abstraites) plutôt que de classes concrètes.


</div>

---

 ### Appliquer les principes SOLID aux modules d’une application

<br/>

<div style="font-size:30px">

### **SOLID dans un cadre méthodologique**

</div>


<div style="font-size:24px">

1. **Modularité et séparation des préoccupations :**
   - Les principes SOLID encouragent la séparation claire des responsabilités, ce qui conduit à des **composants bien isolés**.
   - Les modules ou classes deviennent plus autonomes et réutilisables.

2. **Facilitation des changements :**
   - La conception SOLID permet d’introduire de nouvelles fonctionnalités ou de modifier des comportements sans affecter le reste du système.
   - Cela réduit les risques de **régressions** et favorise l'**agilité** dans le développement.



</div>


--- 

 ### Appliquer les principes SOLID aux modules d’une application

<br/>

<div style="font-size:30px">

### **SOLID dans un cadre méthodologique**

</div>


<div style="font-size:27px">

3. **Réduction du couplage et augmentation de la cohésion :**
   - Les classes et modules sont conçus pour avoir un **faible couplage** (peu de dépendances entre eux) et une **forte cohésion** (une responsabilité bien définie).

4. **Testabilité :**
   - Les systèmes respectant les principes SOLID sont plus **faciles à tester** grâce à l'utilisation d'abstractions et de dépendances injectées.
   - Chaque classe ou composant peut être testé indépendamment des autres.


</div>


---

 ### Appliquer les principes SOLID aux modules d’une application

<br/>

<div style="font-size:30px">

### **SOLID dans un cadre méthodologique**

</div>

<div style="font-size:27px">

5. **Conception basée sur les contrats :**
   - SOLID favorise une conception orientée contrat, où les interfaces et les abstractions définissent **les attentes** sans exposer les détails d'implémentation.

6. **Préparation à l'évolution :**
   - Les systèmes conçus selon SOLID sont prêts à s'adapter aux **changements futurs** sans nécessiter une réécriture complète.


</div>

---

 ### Appliquer les principes SOLID aux modules d’une application

<br/>

<div style="font-size:30px">

#### **SOLID dans un cadre méthodologique**

</div>


<div style="font-size:26px">

1. **Développement Agile :**
   - En facilitant l'ajout de nouvelles fonctionnalités ou le changement de comportement sans risque, SOLID correspond parfaitement aux cycles itératifs et incrémentaux des méthodologies agiles comme Scrum ou Kanban.

2. **Design Patterns :**
   - SOLID fournit les bases pour implémenter des **design patterns** (ex. : Factory, Observer, Strategy) de manière efficace, en tirant parti des abstractions et des polymorphismes.



</div>


---


 ### Appliquer les principes SOLID aux modules d’une application

<br/>

<div style="font-size:30px">

#### **SOLID dans un cadre méthodologique**

</div>


<div style="font-size:20px">

3. **Domain-Driven Design (DDD) :**
   - Les principes SOLID sont compatibles avec la **modélisation basée sur le domaine métier**, en s'assurant que chaque partie du code reflète clairement une intention métier.

4. **Clean Architecture et Hexagonal Architecture :**
   - Les architectures logicielles modernes comme **Clean Architecture** ou **Hexagonal Architecture** utilisent les principes SOLID pour séparer clairement les couches (métier, infrastructure, présentation) et définir des frontières avec des abstractions.

5. **DevOps et CI/CD :**
   - En rendant le code plus modulaire et testable, SOLID facilite l’intégration continue (CI) et la livraison continue (CD), où la qualité et la rapidité sont essentielles.



</div>


---

 ### Appliquer les principes SOLID aux modules d’une application

<br/>

<div style="font-size:30px">

**Objectifs globaux des principes SOLID**

</div>

<br>

<div style="font-size:35px">

- **Rendre le code durable :** Moins sujet à la dette technique.
- **Faciliter la collaboration :** Le code bien structuré est plus facile à comprendre et à partager au sein d’une équipe.
- **Promouvoir la qualité logicielle :** En améliorant la lisibilité, la maintenabilité et la testabilité.


</div>


---

 ### Appliquer les principes SOLID aux modules d’une application

### **1. Single Responsibility Principle (SRP)**

<br>

**Principe de responsabilité unique :**
- **Une classe ou un module ne doit avoir qu'une seule raison de changer.**
- Chaque classe doit être responsable d'une seule fonctionnalité ou d'une seule partie du domaine métier.



---

 ### Appliquer les principes SOLID aux modules d’une application

### **2. Open/Closed Principle (OCP)**
<br>

**Principe ouvert/fermé :**
- **Un module doit être ouvert à l'extension mais fermé à la modification.**
- Le comportement d'une classe doit pouvoir être étendu sans modifier son code source.



---

 ### Appliquer les principes SOLID aux modules d’une application

### **3. Liskov Substitution Principle (LSP)**
<br>

**Principe de substitution de Liskov :**
- **Une classe dérivée doit pouvoir remplacer sa classe de base sans altérer le comportement attendu.**
- Le code utilisant une classe parent doit fonctionner avec ses sous-classes sans modification.



---

 ### Appliquer les principes SOLID aux modules d’une application

### **4. Interface Segregation Principle (ISP)**
<br>

**Principe de ségrégation des interfaces :**
- **Une classe ne doit pas être obligée de dépendre d'interfaces qu'elle n'utilise pas.**
- Les interfaces doivent être spécifiques à leur usage.

---

 ### Appliquer les principes SOLID aux modules d’une application

### **5. Dependency Inversion Principle (DIP)**
<br>

**Principe d'inversion des dépendances :**
- **Les modules de haut niveau ne doivent pas dépendre des modules de bas niveau.**
- Les deux doivent dépendre d'abstractions, et non de détails d'implémentation.

---

 ### Appliquer les principes SOLID aux modules d’une application

<center>
<img src="./assets/demo.jpg" width="600px">
</center>


---

### Appliquer les principes SOLID aux modules d’une application

<br/>

<div style="font-size:30px">

### **Diagramme de tension**

</div>
<br/>

<div style="font-size:25px">

- Un **diagramme de tension** est un outil visuel utilisé pour représenter les forces contradictoires ou complémentaires qui influencent les décisions architecturales ou de conception dans un système logiciel. 
- Ces tensions résultent souvent de compromis nécessaires pour répondre à des exigences conflictuelles, comme la modularité, la simplicité, la testabilité ou la flexibilité.

- Il est particulièrement utile lorsqu'on applique des **principes de conception logicielle**, comme les principes **SOLID**, pour évaluer l'impact des choix architecturaux.

</div>


---

### Appliquer les principes SOLID aux modules d’une application

<br/>

<div style="font-size:30px">

### **Composantes d’un diagramme de tension**

</div>
<br/>

<div style="font-size:25px">

1. **Axes de tension** : Chaque axe représente une exigence ou une qualité souhaitée, comme :
   - **Simplicité** : Réduction de la complexité.
   - **Modularité** : Séparation des responsabilités en composants indépendants.
   - **Flexibilité** : Capacité à s'adapter facilement aux changements.
   - **Testabilité** : Facilité à isoler et tester des parties du système.
   - **Complexité** : Effort nécessaire pour comprendre et maintenir le système.

</div>


---

<!-- _class: lead -->
<!-- _paginate: false -->

## Maintenir la dette technique sous contrôle 

---
