# TpArchitecture
Tp about the CV builder


Introduction

Le but de cette page est de présenter le projet qui va servir de base à votre évaluation dans l'unité d'enseignement Architecture des applications.
Cahier des charges

L'objectif du mini projet est simple : gérer à l'aide de la technologie JEE une liste de CVs. Plus précisément,

    Chaque personne est représentée par un ensemble d'informations : nom, prénom, adresse électronique, site WEB, date de naissance et mot de passe.
    Chaque personne peut renseigner un curriculum vitae. Pour notre application, un CV est une liste d'activités. Chaque activité est décrite par
        une année (obligatoire),
        une nature (expérience professionnelle, formation, projets, autre) (obligatoire),
        un titre (obligatoire) ,
        un texte descriptif (facultatif),
        une adresse WEB (facultatif),
    Chaque personne peut créer de nouvelles personnes (cooptation).
    La liste des personnes et les CV sont librement consultables. La modification implique une phase d'authentification.
    Le logiciel doit être capable de gérer environ 100,000 personnes.

Étape 1 : Couche métier (EJB/JPA/Junit)

Objectifs :

    Réalisation d'une couche métier (EJB/JPA) accompagnée de ses tests unitaires.
    Il faut prévoir les actions CRUD (create/read/update/delete) sur les personnes et les activités.
    Il faut également prévoir les fonctions de recherche d'une personne sur une partie du nom, du prénom ou le titre d'une activité.
    il est souhaitable de prévoir un EJB stateful pour représenter un utilisateur (authentifié ou pas).
    il est souhaitable de prévoir un EJB stateless pour offrir les fonctions d'accès et de recherche.

Note : L'interface de la couche métier doit être soumise pour validation avant le 14 janvier 2019 (fichier ZIP envoyé par e-mail contenant les sources des interfaces et des javaBeans avec un fichier README.txt pour les informations complémentaires notamment les noms des étudiants).
Étape 2 : Présentation (JSF/Primefaces)

Cette étape consiste à mettre en place une application WEB basée sur la technologie JSF/Primefaces qui respecte les contraintes suivantes :

    Utilisation d'AJAX pour les phases de modification des CVs et des informations personnelles.
    Utilisation de pages multiples pour le parcours de la liste des CVs.

Échéances

Ce projet est à rendre, par équipe de deux à trois personnes, pour le lundi 11 février 2019.

Documents attendus : une archive ZIP (de la forme NOM1_prenom1-NOM2_prenom2.zip) qui regroupe

    un cahier des charges (fichier CdC.pdf une ou deux pages),
    un rapport technique (fichier rapport.pdf de moins de 10 pages),
    les sources de l'application WEB (répertoire web avec les sources Java et les ressources utiles),

La forme du rendu doit ABSOLUMENT être respectée. Des soutenances seront organisées. Les travaux sont à rendre sur la plateforme AMETICE.
