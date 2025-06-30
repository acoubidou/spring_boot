# 🚗 Auto Pro - Gestion des Personnes et Véhicules

Projet Java Spring Boot permettant de gérer des **personnes** et leurs **véhicules** via une API externe :
[AutoPro API](https://github.com/acoubidou/spring_boot_api)
Il propose une interface web pour consulter les données et effectuer diverses opérations.

## 🛠️ Technologies utilisées

- Java 21
- Wamp (BDD : MySql - PHPMyAdmin)
- Spring Boot
- Spring MVC
- Thymeleaf
- Bootstrap 5
- REST API (consommation d'une API externe)
- JUnit 5 & Mockito pour les tests

## 📂 Structure du projet
```
📦src
┣ 📂 main
┃   ┣ 📂 java/com/sami/springboot
┃   ┃   ┣ 📂 controller   → Contrôleurs MVC
┃   ┃   ┣ 📂 model        → Modèles (Personne, Véhicule)
┃   ┃   ┣ 📂 repository   → Appels vers l'API externe
┃   ┃   ┗ 📂 service      → Logique métier
┃   ┗ 📂 resources
┃       ┣ 📂 templates    → Vues Thymeleaf (.html)
┃       ┣ 📂 static       → Fichiers CSS, JS, images
┃       ┗ 📂 application.properties
┗ 📂 test
    ┗ 📂 java/com/sami/springboot
        ┣ 📂 controller   → Tests d'intégration (MockMvc)
        ┗ 📂 service      → Tests unitaires (Mockito)
```

## 🚀 Lancer le projet

### Prérequis
- Java 21+
- Maven

### Commande pour lancer :
Sans maven installé :
```bash
./mvnw spring-boot:run
```
Avec maven installé
```bash
mvn spring-boot:run
```
Le site sera accessible sur : http://localhost:8080

## ✅ Fonctionnalités
Affichage des personnes et de leurs véhicules

Recherche dynamique

Interface responsive avec Bootstrap

Footer toujours fixé en bas de page

Tests unitaires et d'intégration

## 🧪 Lancer les tests
Sans maven installé :
```bash
./mvnw test
```
Avec maven installé
```bash
mvn test
```

## SonarQube 

Il est possible de tester la qualité du code via SonarQube. Pour ceci, installez SonarQube à https://www.sonarsource.com/fr/products/sonarqube/downloads/ 

En ligne de commande tapez StartSonar.bat. Une fois lancé, SonarQube est disponible à l’adresse http://localhost:9000/ 

Changez votre user et mdp, puis créez le projet via l’interface. Vous pourrez ensuite lancer le projet depuis la racine du projet en lancant le fichier Sonar.bat 
## 👤 Auteur
Sami [AutoPro]
