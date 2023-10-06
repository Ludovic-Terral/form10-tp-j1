package fr.lixtec.form10.j1.tp.tp2;
import java.util.Scanner;

public class bataille {
    private static String[][] grille = new String[8][10];
    private static String[][] grilleJoueur1 = new String[8][10];
    private static String[][] grilleMemoire = new String[8][10]; // Grille de mémoire pour enregistrer les positions des bateaux
    private int croixPlacees = 0; // Compteur de croix placées
    

    public void construireGrille() {
        // Remplissage de la grille avec des cases vides
        for (int ligne = 0; ligne < 8; ligne++) {
            for (int colonne = 0; colonne < 10; colonne++) {
            	grille[ligne][colonne] = "|_|";
                grilleMemoire[ligne][colonne] = "|_|";
                grilleJoueur1[ligne][colonne] = "|_|"; // Initialise la grille du joueur 1
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

    public void sauvegarderGrille() {
        for (int ligne = 0; ligne < 8; ligne++) {
            for (int colonne = 0; colonne < 10; colonne++) {
                if (grille[ligne][colonne].equals("|X|")) {
                    grilleMemoire[ligne][colonne] = "|X|";
                }
            }
        }
    }

    
    public int tirrermissile(String[][] grilleMemoire, String[][] grilleJoueur, int score) {
        // Demander au joueur de rentrer des coordonnées
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez les coordonnées du missile (ex: A3) :");
        String coordonnees = scanner.next();

        // Analyser les coordonnées
        char colonneChoisie = coordonnees.charAt(0);
        int ligneChoisie = Integer.parseInt(coordonnees.substring(1)) - 1;

        // Vérifier si les coordonnées sont valides
        if (ligneChoisie >= 0 && ligneChoisie < 8 && colonneChoisie >= 'A' && colonneChoisie <= 'J') {
            // Vérifier si la case visée contient une croix dans la grille de mémoire
            if (grilleMemoire[ligneChoisie][colonneChoisie - 'A'].equals("|X|")) {
                grilleJoueur[ligneChoisie][colonneChoisie - 'A'] = "|X|";
                System.out.println("Bravo ! Vous avez touché une croix !");
                score = score + 1;
            } else {
                grilleJoueur[ligneChoisie][colonneChoisie - 'A'] = "|O|";
                System.out.println("Raté ! Il n'y a pas de croix à cet endroit.");
            }
        } else {
            System.out.println("Coordonnées invalides. Veuillez entrer des coordonnées valides.");
        }

        return score; // Renvoyer la valeur du score mise à jour
    }

    public static void main(String[] args) {
        int scoreJoueur1 = 0;
        bataille bataille = new bataille();
        bataille.construireGrille();
        bataille.placerBateau("Universe");
        bataille.placerBateau("Sovereign");
        // bataille.placerBateau("Ambassadeur");
        // bataille.placerBateau("Ambassadeur");
        // bataille.placerBateau("navette");
        bataille.sauvegarderGrille();
        
        while (true) {
            scoreJoueur1 = bataille.tirrermissile(grilleMemoire, grilleJoueur1, scoreJoueur1); // Mettez à jour le score directement
            System.out.println("Score Joueur 1 : " + scoreJoueur1); // Affichez le score mis à jour
            bataille.afficherGrille(grilleJoueur1);
            if (scoreJoueur1 == 4)
            {
            	 System.out.println("le joueur 1 à gagné ");
            	 break;
            }
            
        }
    }
}

