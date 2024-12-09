# Assignement 3 : Mise en oeuvre d'une architecture Micro-services 

## Objectif  
Le but de ce projet est de créer une application basée sur une architecture microservices pour gérer des factures contenant des produits associés à des clients. Ce projet vise à appliquer les concepts clés des microservices, notamment la communication entre services, la découverte dynamique, et l’orchestration via Docker Compose.

---

## Structure et Fonctionnalités des Services

1. **Customer Service**  
   - Gère les informations relatives aux clients (création, mise à jour, suppression, consultation).
   - Technologie : Spring Boot, JPA

2. **Inventory Service**  
   - Permet la gestion des produits (stock, disponibilité, etc.).
   - Technologie : Spring Boot, JPA

3. **Billing Service**  
   - Génère des factures, associe les produits aux clients et gère les calculs de facturation.  
   - Utilise **OpenFeign** pour la communication inter-services.  
   - Technologie : Spring Boot, JPA

4. **Eureka Discovery Service**  
   - Fournit un registre de services pour permettre la découverte dynamique.  
   - Technologie : Spring Boot, Eureka Server

5. **API Gateway**  
   - Implémente une passerelle centralisée pour router les requêtes vers les services appropriés.
   - Configuration statique et dynamique des routes avec **Spring Cloud Gateway**.
   - Technologie : Spring Boot, Spring Cloud Gateway

---

## Architecture Globale  
L’ensemble des microservices est orchestré via **Docker Compose**, garantissant une déploiement et un scaling simplifiés. L'architecture repose sur les principes suivants :  
- **Modularité** : Chaque service est autonome.  
- **Extensibilité** : Possibilité d’ajouter de nouveaux services facilement.  
- **Résilience** : Découplage des services pour réduire les points de défaillance.

---

## Étapes Réalisées

### 1. Création des Services  
- **Customer-Service** : Gestion des entités client.  
- **Inventory-Service** : Gestion des produits.  
- **Billing-Service** : Génération des factures et gestion des interactions via OpenFeign.  

### 2. Implémentation de l’API Gateway  
- Configuration statique et dynamique des routes.  
- Centralisation de l’accès aux services.

### 3. Configuration de Eureka Discovery Service  
- Mise en place du serveur Eureka pour le registre des microservices.  
- Enregistrement automatique des services dans l'annuaire.

### 4. Communication entre Services  
- **OpenFeign** : Implémenté pour permettre une communication RESTful efficace et dynamique.

### 5. Orchestration des Services  
- Création d’un fichier `docker-compose.yml` pour automatiser le déploiement des conteneurs.  

---

## Résultats et Déploiement

1. **Construction** :  
   Chaque service est empaqueté avec Maven :  
   ```bash
   mvn clean package
   ```

2. **Lancement** :  
   L’ensemble des services est déployé avec Docker Compose :  
   ```bash
   docker-compose up --build
   ```

3. **Accès** :  
   - **API Gateway** : [http://localhost:8080](http://localhost:8080)  
   - **Dashboard Eureka** : [http://localhost:8761](http://localhost:8761)  

---

## Ressources

1. **Backend (Partie 1)** : [Vidéo YouTube](https://www.youtube.com/watch?v=hVlEoKQG_2E)  
2. **Backend (Partie 2)** : [Vidéo YouTube](https://www.youtube.com/watch?v=XEzBA3yIII8)  

---

## Conclusion  
Ce projet a permis d’appliquer des concepts fondamentaux liés aux microservices : découplage des services, communication inter-services, découverte dynamique, et orchestration via Docker. L'architecture mise en œuvre peut être facilement étendue pour intégrer de nouvelles fonctionnalités.
