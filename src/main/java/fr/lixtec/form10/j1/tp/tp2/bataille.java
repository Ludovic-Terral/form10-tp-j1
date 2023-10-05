package fr.lixtec.form10.j1.tp.tp2;
import java.util.Scanner;

public class bataille {
    private String[][] grille = new String[8][10];
    private String[][] grilleMemoire = new String[8][10]; // Grille de mémoire pour enregistrer les positions des bateaux
    private int croixPlacees = 0; // Compteur de croix placées

    public void construireGrille() {
        // Remplissage de la grille avec des cases vides
        for (int ligne = 0; ligne < 8; ligne++) {
            for (int colonne = 0; colonne < 10; colonne++) {
                grille[ligne][colonne] = "|_|";
            }
        }

        // Initialisation de la grille de mémoire avec des cases vides
        for (int ligne = 0; ligne < 8; ligne++) {
            for (int colonne = 0; colonne < 10; colonne++) {
                grilleMemoire[ligne][colonne] = "|_|";
            }
        }
    }

    public void afficherGrille(String[][] grilleAUtiliser) {
        // Affichage des lettres pour numéroter les colonnes
        System.out.print("  ");
        for (char colonne = 'A'; colonne <= 'J'; colonne++) {
            System.out.print(" " + colonne + " ");
        }
        System.out.println();

        // Affichage de la grille avec les chiffres pour numéroter les lignes
        for (int ligne = 0; ligne < 8; ligne++) {
            System.out.print((ligne + 1) + " "); // Numéro de ligne
            for (int colonne = 0; colonne < 10; colonne++) {
                System.out.print(grilleAUtiliser[ligne][colonne]);
            }
            System.out.println(); // Passer à la ligne suivante
        }
    }

    
    
    
    
    public void placerBateau(String bateau) {
        Scanner scanner = new Scanner(System.in);

        // Boucle pour permettre au joueur de placer plusieurs croix
            // Afficher la grille actuelle avec les lettres des colonnes
            afficherGrille(grille);

            // Demande au joueur de placer une croix
            System.out.println("Entrez les coordonnées de la case pour placer une croix (ex: A3) ou tapez 'q' pour quitter :");
            String coordonnees = scanner.next();


            // Analyse des coordonnées
            char colonneChoisie = coordonnees.charAt(0);
            int ligneChoisie = Integer.parseInt(coordonnees.substring(1)) - 1; // Soustraire 1 car les lignes commencent à 1

            // Placer une croix dans la case choisie
            if (ligneChoisie >= 0 && ligneChoisie < 8 && colonneChoisie >= 'A' && colonneChoisie <= 'J') {
                // Marquer la case avec une croix dans la grille principale
                grille[ligneChoisie][colonneChoisie - 'A'] = "|X|";

                // Marquer la case avec une croix dans la grille de mémoire
                grilleMemoire[ligneChoisie][colonneChoisie - 'A'] = "|X|";
    
                // Impact sur les cases adjacentes (gauche, droite, haut, bas, diagonales)
                if (bateau.equals("Universe"))
                {
                for (int i = 0; i <= 2; i++) {
                    for (int j = 0; j <= 1; j++) {
                        int nouvelleLigne = ligneChoisie + i;
                        int nouvelleColonne = colonneChoisie - 'A' + j;
                        if (nouvelleLigne >= 0 && nouvelleLigne < 8 && nouvelleColonne >= 0 && nouvelleColonne < 10) {
                            grille[nouvelleLigne][nouvelleColonne] = "|X|";
                        }
                    }
                }
            }
                else if (bateau.equals("Sovereign"))
                {
                    for (int i = 0; i <= 1; i++) {
                        for (int j = 0; j <= 1; j++) {
                            int nouvelleLigne = ligneChoisie + i;
                            int nouvelleColonne = colonneChoisie - 'A' + j;
                            if (nouvelleLigne >= 0 && nouvelleLigne < 8 && nouvelleColonne >= 0 && nouvelleColonne < 10) {
                                grille[nouvelleLigne][nouvelleColonne] = "|X|";
                            }
                        }
                    }
                }
                else if (bateau.equals("Ambassadeur"))
                {
                    for (int i = 0; i <= 2; i++) {
                        for (int j = 0; j <= 0; j++) {
                            int nouvelleLigne = ligneChoisie + i;
                            int nouvelleColonne = colonneChoisie - 'A' + j;
                            if (nouvelleLigne >= 0 && nouvelleLigne < 8 && nouvelleColonne >= 0 && nouvelleColonne < 10) {
                                grille[nouvelleLigne][nouvelleColonne] = "|X|";
                            }
                        }
                    }
                }
                else if (bateau.equals("navette"))
                {
                    for (int i = 0; i <= 1; i++) {
                        for (int j = 0; j <= 0; j++) {
                            int nouvelleLigne = ligneChoisie + i;
                            int nouvelleColonne = colonneChoisie - 'A' + j;
                            if (nouvelleLigne >= 0 && nouvelleLigne < 8 && nouvelleColonne >= 0 && nouvelleColonne < 10) {
                                grille[nouvelleLigne][nouvelleColonne] = "|X|";
                            }
                        }
                    }
                }
                }
                else {
                System.out.println("Coordonnées invalides. Veuillez entrer des coordonnées valides.");
            }
            
    }
    public void nettoyerGrille() {
        // Nettoyer la grille principale
        for (int ligne = 0; ligne < 8; ligne++) {
            for (int colonne = 0; colonne < 10; colonne++) {
                grille[ligne][colonne] = "|_|";
            }
        }

        // Réinitialiser la grille de mémoire pour effacer tous les "X"
        for (int ligne = 0; ligne < 8; ligne++) {
            for (int colonne = 0; colonne < 10; colonne++) {
                grilleMemoire[ligne][colonne] = "|_|";
            }
        }

        // Afficher un message pour informer que la grille a été nettoyée
        System.out.println("La grille a été nettoyée, mais les positions des bateaux sont en mémoire.");
    }

    
    public void tirrermissile() {
        Scanner scanner = new Scanner(System.in);

        // Afficher la grille actuelle avec les lettres des colonnes
        afficherGrille(grille);

        // Demande au joueur de tirer un missile
        System.out.println("Entrez les coordonnées pour tirer un missile (ex: A3) ou tapez 'q' pour quitter :");
        String coordonnees = scanner.next();

        // Vérifier si le joueur veut quitter
        if (coordonnees.equalsIgnoreCase("q")) {
            System.out.println("Vous avez quitté le jeu.");
            System.exit(0);
        }

        // Analyse des coordonnées
        char colonneChoisie = coordonnees.charAt(0);
        int ligneChoisie = Integer.parseInt(coordonnees.substring(1)) - 1; // Soustraire 1 car les lignes commencent à 1

        // Vérifier si des croix sont présentes à ces coordonnées dans la grille de mémoire
        if (ligneChoisie >= 0 && ligneChoisie < 8 && colonneChoisie >= 'A' && colonneChoisie <= 'J') {
            if (grilleMemoire[ligneChoisie][colonneChoisie - 'A'].equals("|X|")) {
                System.out.println("Vous avez touché une croix ! Vous gagnez 1 point.");
                // Incrémenter le score du joueur ici
            } else {
                System.out.println("Raté ! Aucune croix à cet endroit.");
            }
        } else {
            System.out.println("Coordonnées invalides. Veuillez entrer des coordonnées valides.");
        }
    }

    public static void main(String[] args) {
        bataille bataille = new bataille();
        bataille.construireGrille();
        bataille.placerBateau("Universe");
       bataille.placerBateau("Sovereign");
       // bataille.placerBateau("Ambassadeur");
      //  bataille.placerBateau("Ambassadeur");
       // bataille.placerBateau("navette");
        bataille.nettoyerGrille();
        bataille.afficherGrille(bataille.grilleMemoire); // Afficher la grille de mémoire
        while (true)
        {
        	bataille.tirrermissile();
        }
    }
}

