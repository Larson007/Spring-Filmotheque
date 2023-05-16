# Filmotèque

## Présentation du projet

Filmotèque est un site web qui met en avant une bibliothèque de films personnalisée où les utilisateurs peuvent créer et gérer des fiches de films, ajouter des informations sur les acteurs, le réalisateur, le genre du film, et partager leurs avis.

Pour réaliser ce projet, j'ai utilisé le langage `Java` avec le framework `Spring` pour développer l'`API` côté serveur, et `Vue.js` pour le développement du front-end. Cette combinaison de technologies puissantes nous permet de créer une expérience utilisateur fluide et interactive.

&nbsp;

---

## Voici les principales fonctionnalités offertes par Filmotèque :

1. Création de fiches de films : Les utilisateurs peuvent créer de nouvelles fiches de films en ajoutant les informations pertinentes telles que le titre, la description, les acteurs, le réalisateur, le genre, etc. L'application offre une interface conviviale qui facilite la saisie de ces informations.

2. Recherche et filtres : Les utilisateurs peuvent rechercher des films dans la filmotèque en utilisant différents critères tels que le titre, le genre, l'acteur ou le réalisateur. Des filtres sont également disponibles pour affiner les résultats de recherche et faciliter la navigation.

3. Gestion des fiches de films : Les utilisateurs peuvent mettre à jour les informations des fiches de films existantes, ajouter de nouveaux acteurs, modifier le réalisateur ou donner leur avis sur un film. Cette fonctionnalité permet aux utilisateurs de contribuer et d'enrichir la base de données de la filmotèque.

4. Système de notation et d'avis : Chaque utilisateur peut donner son avis sur un film en attribuant une note et en laissant un commentaire. Ces avis sont affichés sur les fiches de films et permettent aux autres utilisateurs d'avoir des recommandations et des opinions sur les films.

5. Interface utilisateur conviviale : Filmotèque offre une interface utilisateur intuitive et attrayante grâce à l'utilisation de Vue.js. Les utilisateurs peuvent naviguer facilement dans le site, consulter les détails des fiches de films et interagir avec les fonctionnalités de manière transparente.

&nbsp;

En utilisant `Java` avec Spring pour l'`API` et `Vue.js` pour le front-end, Filmotèque bénéficie d'une architecture solide et d'une séparation claire des responsabilités entre le back-end et le front-end. Cette approche permet une évolutivité facile, une maintenance simplifiée et offre une expérience utilisateur réactive.

&nbsp;

En conclusion, Filmotèque est un projet qui offre aux utilisateurs la possibilité de créer et de gérer leur propre bibliothèque de films, d'explorer de nouveaux titres, de partager leurs avis et de découvrir des recommandations.

&nbsp;

---

## Installation

### Configuration de la BDD

1. Ouvrir le fichier `application.properties` dans :

> Filmotheque\bin\main\application.properties

2. Modifier le fichier en fonction de vos paramètres

````properties
spring.datasource.url=jdbc:mysql://localhost:3306/NOM_DE_LA_BDD_MYSQL
spring.datasource.username=NOM_UTILISATEUR_MYSQL
spring.datasource.password=MOTS_DE_PASSE_MYSQL
````

### Initailisation de l'API

1. Création de la `BDD` avec `MySQL` en fonction du nom indiqué dans `application.properties`

2. Lancement de l'`API` avec `SpringToolSuite4`

### Initialisation du Front avec Vue Js

1. Installation des dépendances

````bash
npm i
````

2. Lancement du serveur

````bash
npm run dev
````

&nbsp;

---

## URL

Back API (port 8080)

> http://localhost:8080/api/films

> http://localhost:8080/api/participants

> http://localhost:8080/api/genres

Front (port 5173)

> http://localhost:5173/