package fr.lixtec.form10.j1.tp.tp2;
import java.util.Scanner;

public class bataille {
    private static String[][] grille1 = new String[10][8];
    private static String[][] grille2 = new String[10][8];
    private static String[][] grilleJoueur1 = new String[10][8];
    private static String[][] grilleMemoire1 = new String[10][8];
    private static String[][] grilleJoueur2 = new String[10][8];
    private static String[][] grilleMemoire2 = new String[10][8]; // Grille de mémoire pour enregistrer les positions des bateaux
    private int croixPlacees = 0; // Compteur de croix placées
    

    public void construireGrille() {
        // Remplissage de la grille avec des cases vides
        for (int ligne = 0; ligne < 10; ligne++) {
            for (int colonne = 0; colonne < 8; colonne++) {
            	grille1[ligne][colonne] = "|_|";
            	grille2[ligne][colonne] = "|_|";
                grilleMemoire1[ligne][colonne] = "|_|";
                grilleJoueur1[ligne][colonne] = "|_|"; // Initialise la grille du joueur 1
                grilleMemoire2[ligne][colonne] = "|_|";
                grilleJoueur2[ligne][colonne] = "|_|"; // Initialise la grille du joueur 1
            }
        }

   }
    

    public void afficherGrille(String[][] grilleAUtiliser) {
        // Affichage des lettres pour numéroter les colonnes
        System.out.print("  ");
        for (char colonne = 'A'; colonne <= 'H'; colonne++) {
            System.out.print(" " + colonne + " ");
        }
        System.out.println();

        // Affichage de la grille avec les chiffres pour numéroter les lignes
        for (int ligne = 0; ligne < 10; ligne++) {
            if (ligne == 9) {
                System.out.print((ligne + 1)); // Numéro de ligne sans espace
            } else {
                System.out.print((ligne + 1) + " "); // Numéro de ligne avec espace
            }
            
            for (int colonne = 0; colonne < 8; colonne++) {
                System.out.print(grilleAUtiliser[ligne][colonne]);
            }
            System.out.println(); // Passer à la ligne suivante
        }
    }


    
    
    
    
    public void placerBateau(String bateau, String[][] grille, String tour) {
        Scanner scanner = new Scanner(System.in);

            // Afficher la grille actuelle avec les lettres des colonnes
            afficherGrille(grille);

            // Demande au joueur de placer une croix
            System.out.println(tour + ", entrez les coordonnées du bateau " + bateau + ":");
            String coordonnees = scanner.next();


            // Analyse des coordonnées
            char colonneChoisie = coordonnees.charAt(0);
            int ligneChoisie = Integer.parseInt(coordonnees.substring(1)) - 1; // Soustraire 1 car les lignes commencent à 1

            // Placer une croix dans la case choisie
            if (ligneChoisie >= 0 && ligneChoisie < 10 && colonneChoisie >= 'A' && colonneChoisie <= 'H') {
                // Marquer la case avec une croix dans la grille principale
                grille[ligneChoisie][colonneChoisie - 'A'] = "|X|";

    
                // Impact sur les cases adjacentes (gauche, droite, haut, bas, diagonales)
                if (bateau.equals("Universe"))
                {
                for (int i = 0; i <= 2; i++) {
                    for (int j = 0; j <= 1; j++) {
                        int nouvelleLigne = ligneChoisie + i;
                        int nouvelleColonne = colonneChoisie - 'A' + j;
                        if (nouvelleLigne >= 0 && nouvelleLigne < 10 && nouvelleColonne >= 0 && nouvelleColonne < 8) {
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
                            if (nouvelleLigne >= 0 && nouvelleLigne < 10 && nouvelleColonne >= 0 && nouvelleColonne < 8) {
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
                            if (nouvelleLigne >= 0 && nouvelleLigne < 10 && nouvelleColonne >= 0 && nouvelleColonne < 8) {
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
                            if (nouvelleLigne >= 0 && nouvelleLigne < 10 && nouvelleColonne >= 0 && nouvelleColonne < 8) {
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

    public void sauvegarderGrille(String[][] grille , String[][] grilleMemoire) {
        for (int ligne = 0; ligne < 10; ligne++) {
            for (int colonne = 0; colonne < 8; colonne++) {
                if (grille[ligne][colonne].equals("|X|")) {
                    grilleMemoire[ligne][colonne] = "|X|";
                }
            }
        }
    }

    
    public int tirrermissile(String[][] grilleMemoire, String[][] grilleJoueur, int score, String tour) {
        // Demander au joueur de rentrer des coordonnées
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez les coordonnées du missile " +tour);
        String coordonnees = scanner.next();

        // Analyser les coordonnées
        char colonneChoisie = coordonnees.charAt(0);
        int ligneChoisie = Integer.parseInt(coordonnees.substring(1)) - 1;

        // Vérifier si les coordonnées sont valides
        if (ligneChoisie >= 0 && ligneChoisie < 10 && colonneChoisie >= 'A' && colonneChoisie <= 'H') {
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
        int scoreJoueur2 = 0;
        bataille bataille = new bataille();
        bataille.construireGrille();
        bataille.placerBateau("Universe" , grille1 ,"joueur1");
        bataille.placerBateau("Sovereign" , grille1,"joueur1");
        // bataille.placerBateau("Ambassadeur", grille1 ,"joueur1");
        // bataille.placerBateau("Ambassadeur", grille1 ,"joueur1");
        // bataille.placerBateau("navette", grille1,"joueur1");
        bataille.afficherGrille(grille1);
        bataille.sauvegarderGrille(grille1,grilleMemoire1);
        bataille.placerBateau("Universe" , grille2,"joueur2");
        bataille.placerBateau("Sovereign" , grille2,"joueur2");
        // bataille.placerBateau("Ambassadeur", grille2,"joueur2");
        // bataille.placerBateau("Ambassadeur", grille2,"joueur2");
        // bataille.placerBateau("navette", grille2,"joueur2");
        bataille.afficherGrille(grille2);
        bataille.sauvegarderGrille(grille2 ,grilleMemoire2);
        
        while (true) {
        	//rajouter le clear screen ici mais il ne marche pas chez moi 
            scoreJoueur1 = bataille.tirrermissile(grilleMemoire2, grilleJoueur1, scoreJoueur1, "joueur1");
            System.out.println("Score Joueur 1 : " + scoreJoueur1);
            bataille.afficherGrille(grilleJoueur1);
            
            // Mettez à jour le score du joueur 2 ici
            scoreJoueur2 = bataille.tirrermissile(grilleMemoire1, grilleJoueur2, scoreJoueur2, "joueur2");
            System.out.println("Score Joueur 2 : " + scoreJoueur2);
            bataille.afficherGrille(grilleJoueur2);
            
            if (scoreJoueur1 == 4 ) {
                System.out.println("LE JOUEUR 1 GAGNE");
                break;
            }
            if (scoreJoueur2 == 4 ) {
                System.out.println("LE JOUEUR 2 GAGNE");
                break;
            }
        }
    }
}

