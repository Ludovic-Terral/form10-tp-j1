# TP 3 - Création d'un jeu de bataille galactique

>**Le TP devra être encodé en UTF-8 pour faciliter la correction.**

Ce jeu de société se joue à deux, l’un contre l’autre sur deux grilles où sont placés 5 vaisseaux mis en place par les joueurs.

Le but étant de détruire tous les vaisseaux de l’adversaire. C’est à la fois un jeu de réflexion et un jeu de hasard.

Pour jouer à la bataille galactique, il faut par joueur :
* Une grille de jeu numérotée de 1 à 10 horizontalement et de A à H verticalement 
* 1 vaisseau de classe Universe (3*2 cases)
* 1 vaisseau de classe Sovereign (2*2 cases)
* 1 vaisseau de classe Ambassadeur(3*1 cases)
* 1 vaisseau de classe Constitution(3*1 cases)
* 1 navette (2*1 cases)

Au début du jeu, chaque joueur place à sa guise tous les navires sur sa grille de façon stratégique (vertical ou horizontal). Le but étant de compliquer au maximum la tache de son adversaire, c’est-à-dire détruire tous vos navires. Bien entendu, le joueur ne voit pas la grille de son adversaire.
Une fois tous les vaisseaux en jeu, la partie peut commencer.. Un à un, les joueurs se tire dessus avec des phasers pour détruire les vaisseaux ennemis.


> Exemple: le joueur dit à haute voix H7 correspondant à la case au croisement de la lettre H et du numéro 7 sur les côtés des grilles.

Si un joueur tire sur un navire ennemi, l’adversaire doit le signaler en disant « touché ». Il peut pas jouer deux fois de suite et doit attendre le tour de l’autre joueur.
Si le joueur ne touche pas de navire, l’adversaire le signale en disant « raté » .
Si le navire est entièrement touché l’adversaire doit dire « désintégré ».

Les pions blancs et des pions rouges servent à se souvenir des tirs ratés (blancs) et les tirs touchés (rouges). Il est indispensable de les utiliser pour ne pas tirer deux fois au même endroit et donc ne pas perdre de temps inutilement. Ces pions se placent sur la grille du dessus.

Lorsque un des joueurs a détruits tous les vaisseaux énemis, il a gagné la partie.


Vous allez implémenter de quoi jouer à la bataille galactique. 
Pour celà, votre application devra demander la configuration des vaisseaux de chaque joueur. Vous devrez gérer la structure de chaque vaisseau et la conformité des coordonnées.

Puis à chaque tour, votre jeu devra demander les coordonnées de tir. 
A l'issu du tir, le joueur devra:
* obtenir le résultat du tir (touché, désintégré, loupé)
* afficher la grille des tirs effectués avec T pour toucher et L pour louper

Au début de chaque tour, l'application devra afficher l'état de la flotte et de chaque unité.
ex: 

        Flotte opérationnelle à à 50%
        - vaisseau de classe universe opérationnel à 80%
        - vaisseau de classe Sovereign opérationnel à 100%
        - vaisseau de classe Ambassadeur opérationnel à 100% 
        - vaisseau de classe Constitution desintégré 
        - navette desintégrée
Le pourcentage correspond au nombre de cases restantes.
Il y aura ensuite l'affichage des grilles de tir et de flotte en côte à côte.

Enfin le jeu affichera le nom du joueur gagnant lorsqu'une des flottes est anéantie.
