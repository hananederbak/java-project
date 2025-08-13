# java-project
#Projet de Programmation Avancée – Analyse CSV contenant uniquement des valeurs numériques.
 
**** Membres du Groupe****
***-DERBAK Hanane***
***- KERROUCH Abdennour***

**AnalyseurCsv.java (main)**
Lance le programme.
Demande au lecteur de charger data/java_project.csv.
Calcule les stats par colonne (min, max, moyenne, nombre).
Affiche les résultats.
Appelle Rapport pour enregistrer le résumé.

**LecteurCSV.java (interface)**
Définit quoi doit savoir faire un lecteur CSV (obtenir en-têtes, lignes…).
Pas de logique ici, seulement des signatures de méthodes.

**LecteurCsvSimple.java (lecteur)**
Ouvre le CSV.
Lit la première ligne comme en-têtes.
Lit les lignes suivantes comme données.
Nettoie les cellules (trim des espaces, remplace , par . pour les décimales).

**StatistiqueColonne.java (stats d’une colonne)**
Garde à jour : min, max, somme, compte.
Pour chaque valeur numérique : met à jour ces chiffres.
Donne getMoyenne() = somme / compte.

**Statistique.java (helpers/formatage)**
Petites fonctions utilitaires.
Formate les nombres en 0.0000 et aide à l’affichage.

**Rapport.java (écriture du résumé)**
Crée un fichier de sortie (ex. data/resume.csv).
Écrit une ligne par colonne : Nom, Moyenne, Min, Max, Nombre.
