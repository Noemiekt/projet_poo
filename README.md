# Projet POO ( OOP Project ) : MOTUS

Ce projet consiste en l'implémentation d'un jeu MOTUS en Java. Il se découpe en 3 packages.

- `Controllers` : Contient le backend et la gestion des tableaux
- `Graphics` : Contient les classes pour l'interface graphique
- `Tests` : Contient la classe `Game` à exécuter pour lancer le jeu.

Quelques classes marquantes du projet, en particulier les classes contenant des *features BONUS*, sont détaillées ci-dessous.

## `Controllers.GamesControls`

Analyse le mot en entrée et le mot du dictionnaire pour vérifier les bonnes lettres et les lettres mal placées. Le code couleur suivant est utilisé pour identifier la progression du joueur :
- Fond rose et police blanche : Lettre & Position exactes
- Fond jaune et police blanche : Lettre exacte & Position inexacte
- Fond blanc et police noire : Lettre & Position inexactes

## `Controllers.Dictionnary`

Importe les différents dictionnaires associées aux 4 langues disponibles dans le jeu afin de pouvoir générer des mots aléatoires (parmi Français, Anglais, Espagnol et Allemand).

## `Controllers.TimerControls`

Crée le chronomètre imposant un temps imparti au joueur pour résoudre le puzzle. Le temps diffère en fonction du nombre de lettres afin d'adapter la difficulté.

- 4 lettres : 1 minute
- 4+i lettres : 1 minutes + i*30 secondes

## `Graphics.Motus1V1Util`

Permet à deux joueurs de jouer en face à face. La première fenêtre qui s'affiche est pour le joueur 1, la deuxième pour le joueur 2. Le score final s'affiche une fois la partie terminée.

## `Graphics.Music`

Implémente les différents effets sonores du jeux, notamment :
- Musique du menu principal
- Musique en jeu
- Musique de fin de partie : temps écoulé
- Bruitage d'erreur (mot de mauvaise longueur, etc.)
- Bruitage de fin de partie : victoire
- Bruitage de fin de partie : nombre d'essai épuisé

## Autres *features BONUS* implémentées

- Le menu principal propose un onglet `Score` dans lequel le meilleur score du joueur peut être consulté après avoir réalisé plusieurs parties.
- A des fins de *DEBUG*, le mot à deviner est affiché dans la console.


Pour un détail complet du déroulement du jeu, veuillez consulter le fichier "explication.pdf" inclus dans ce répertoire.