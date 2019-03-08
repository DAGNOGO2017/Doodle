# Titre du projet

Ce projet s'intitule **MyDoodle**. 

## But du projet

Il s'agit d'une application de prise de rendez-vous de type doodle en y ajoutant des services annexes supplémentaires.
Pour cette première partie, seul le back-end a été réalisé.

## Outils utilisés

Cette application a été développée en  Java 8 à l'aide des outils suivants :
* [Maven](https://maven.apache.org/) - Gestionnaire de dépendances
* [Tomcat](http://tomcat.apache.org) - Le conteneur web utilisé
* [JAX-RS](https://github.com/jax-rs) - Used to generate RSS Feeds
* [Jersey](https://github.com/jersey) - Le framework open-source utilisé pour développer des services selon l'architecture REST suivant les spécifications de JAX-RS.

## Fonctionnalités supportées

Cette application permet pour l'instant de créer :
* des utilisateurs
* des sondages sur la date et le lieu d'une réunion
* des dates
* des allergies
* des préférences alimentaires
* des réunions.

## Fonctionnalités encore à développer

Il reste à développer tout le front-end et pour le back-end, il reste encore à gérer :
* la confirmation de la date de la réunion
* la liste des présents en fonction des réponses du sondage
* la liste des absents
* le mail qui sera transmis aux utilisateurs pour qu'ils renseignent leurs préférences alimentaires et leurs allergies après validation de la date de réunion.


## Tests

Les tests automatisés restent encore à faire.


## Auteurs

Ce projet a été réalisé par des étudiants de Master 1 MIAGE.
Il s'agit :
* **Kiko Dagnogo**
* **Anderson Konan**

En collaboration avec le groupe composé de :
* **Hermann Egny**
* **Chris Ouattara**

Sur les points suivants :
* la modélisation du problème
* le mapping objet-relationnel
* les fichiers README.md et design.md

Motifs de la collaboration :
* réaliser une modélisation qui se rapproche au mieux du problème posé
* difficultés rencontrées dans le mapping de certaines relations (ManyToMany) et des héritages

## Licence

Ce projet est de type Open-Source.

# Réponses au TP de NoSQL

**1. Quelles sont les limites d’une base de données orientées document ?**

* La hiérarchisation d'accès
* L’absence de perspective dans la base de données
* La perte d'autonomie des entités.

**2.a. Quelles sont les types de données stockés dans Redis ?**

* Hash
* Sets 
* Les chaines de caractères
* Les valeurs simples
* Les listes
* Sets triés.

**2.b. Que peut-on faire comme types de requêtes ?**

* Les requêtes de projection qui ne conservent que les champs intéressants.
* Les requêtes de jointure qui permettent de mettre en relation des données situées dans différentes tables.
* Les requêtes de sélection qui ne conservent que les enregistrements intéressants.


```
