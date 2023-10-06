package fr.lixtec.form10.j1.tp.tp3;


import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BatailleNavale {
    
    
    public static void initialiserGrille(char[][] grille) {
        for (char[] ligne : grille) {
            Arrays.fill(ligne, '~');
        }
    }
    
    public static void placerVaisseaux(char[][] grille, char[][] grilleDesNavires, String joueur) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Placement des vaisseaux pour " + joueur + ":");
        placerVaisseauGrille(grille, grilleDesNavires, joueur, "Ambassadeur", 'A', 3, 1);
        placerVaisseauGrille(grille, grilleDesNavires, joueur, "Universe", 'U', 3, 2);
        placerVaisseauGrille(grille, grilleDesNavires, joueur, "Sovereign", 'S', 2, 2);
        placerVaisseauGrille(grille, grilleDesNavires, joueur, "Constitution", 'C', 3, 1);       
    }

    public static void placerVaisseauGrille(char[][] grille, char[][] grilleDesNavires, String joueur, String nomVaisseau, char symbole, int longueur, int largeur) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Placement du vaisseau " + nomVaisseau + " (" + longueur + "x" + largeur + ") pour " + joueur + ":");

        while (true) {
            System.out.print("Entrez les coordonnees (ex. A1) : ");

            String coordonnees = scanner.nextLine();
            if (coordonnees.isEmpty()) {
                System.out.println("Coordonnees vides. Reessayez.");
                continue;
            }
            char lettre = coordonnees.charAt(0);
            int chiffre = Integer.parseInt(coordonnees.substring(1));
            int colonne;
            int ligne;

            if (lettre >= 'A' && lettre <= 'J' && chiffre >= 1 && chiffre <= 10) {
                colonne = lettre - 'A';
                ligne = chiffre - 1;
                System.out.print("Entrez l'orientation (H pour horizontal, V pour vertical) : ");
                String orientation = scanner.next().toUpperCase();

                // Orientation horizontale
                if (orientation.equals("H")) {
                    if (colonne + longueur <= grille[0].length && ligne + largeur <= grille.length) {
                        boolean collision = false;
                        for (int i = ligne; i < ligne + largeur; i++) {
                            for (int j = colonne; j < colonne + longueur; j++) {
                                if (grilleDesNavires[i][j] != '~') {
                                    collision = true;
                                    break;
                                }
                            }
                            if (collision) {
                                break;
                            }
                        }

                        if (!collision) {
                            for (int i = ligne; i < ligne + largeur; i++) {
                                for (int j = colonne; j < colonne + longueur; j++) {
                                    grille[i][j] = symbole;
                                    grilleDesNavires[i][j] = symbole;
                                }
                            }

                            break;
                        } else {
                            System.out.println("Le vaisseau ne peut pas etre place ici. un vaisseau est deja present. Reessayez.");
                        }
                    } else {
                        System.out.println("Le vaisseau ne peut pas etre place ici. Reessayez.");
                    }
                }

                // Orientation verticale
                else if (orientation.equals("V")) {
                    if (ligne + longueur <= grille.length && colonne + largeur <= grille[0].length) {
                        boolean collision = false;
                        for (int i = ligne; i < ligne + longueur; i++) {
                            for (int j = colonne; j < colonne + largeur; j++) {
                                if (grilleDesNavires[i][j] != '~') {
                                    collision = true;
                                    break;
                                }
                            }
                            if (collision) {
                                break;
                            }
                        }

                        if (!collision) {
                            for (int i = ligne; i < ligne + longueur; i++) {
                                for (int j = colonne; j < colonne + largeur; j++) {
                                    grille[i][j] = symbole;
                                    grilleDesNavires[i][j] = symbole;
                                }
                            }

                            break;
                        } else {
                            System.out.println("Le vaisseau ne peut pas etre place ici. Reessayez.");
                        }
                    } else {
                        System.out.println("Le vaisseau ne peut pas etre place ici. Reessayez.");
                    }
                }

                else {
                    System.out.println("Orientation invalide. Réessayez.");
                }
            } else {
                System.out.println("Coordonnées incorrectes. Réessayez.");
            }
        }

        afficherGrille(grille, joueur);
    }

    
    public static void afficherGrille(char[][] grille, String joueur) {
        System.out.println(joueur + " :");
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        
        char lettre = 'A';
        for (int i = 0; i < grille.length; i++) {
            System.out.print(lettre + " ");
            for (int j = 0; j < grille[i].length; j++) {
                System.out.print(grille[i][j] + " ");
            }
            System.out.println();
            lettre++;
        }
        System.out.println();
    }
    
    public static boolean effectuerTir(char[][] grille, String coordonnees) {
        char colonneChar = coordonnees.charAt(0);
        int ligne = coordonnees.charAt(1) - '1';
        int colonne = colonneChar - 'A';

        if (grille[ligne][colonne] != '~') {
            grille[ligne][colonne] = 'X';
            return true;
        } else {
            grille[ligne][colonne] = 'O';
            return false;
        }
    }
    
    
    
    @SuppressWarnings("deprecation")
	public static void clrscr(){
        try
        {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else Runtime.getRuntime().exec("clear");
        }
        catch (IOException | InterruptedException ex)
        {
            // erreur canard. C'est mal
        }
    }
    
    public static boolean estFlotteDetruite(char[][] grille) {
        return false;
    }
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        char[][] grilleJoueur1 = new char[10][10];
        char[][] grilleJoueur2 = new char[10][10];
        initialiserGrille(grilleJoueur1);
        initialiserGrille(grilleJoueur2);
        
        char[][] grilleDesNaviresJoueur1 = new char[10][10];
        char[][] grilleDesNaviresJoueur2 = new char[10][10];

        initialiserGrille(grilleDesNaviresJoueur1);
        initialiserGrille(grilleDesNaviresJoueur2);
        
        placerVaisseaux(grilleJoueur1, grilleDesNaviresJoueur1, "Joueur 1");
        placerVaisseaux(grilleJoueur2, grilleDesNaviresJoueur2, "Joueur 2");
        
        afficherGrille(grilleJoueur1, "Joueur 1");
        afficherGrille(grilleJoueur2, "Joueur 2");
        
        boolean joueur1Tour = true;
        
        while (true) {
        	clrscr();
            String joueurActuel = joueur1Tour ? "Joueur 1" : "Joueur 2";
            System.out.println("Tour de " + joueurActuel);
            System.out.print("Entrez les coordonnees de tir (ex. H7) : ");
            String coordonnees = scanner.nextLine();
            char[][] grilleCible = joueur1Tour ? grilleJoueur2 : grilleJoueur1;
            boolean tirReussi = effectuerTir(grilleCible, coordonnees);
            if (tirReussi) {
                System.out.println("Touche !");
            } else {
                System.out.println("Loupe !");
            }
            afficherGrille(grilleJoueur1, "Joueur 1");
            afficherGrille(grilleJoueur2, "Joueur 2");

            if (estFlotteDetruite(grilleJoueur1)) {
                System.out.println("Joueur 2 a gagné !");
                break;
            } else if (estFlotteDetruite(grilleJoueur2)) {
                System.out.println("Joueur 1 a gagné !");
                break;
            }
            
            joueur1Tour = !joueur1Tour;
        }
        scanner.close();
       
    }
}
