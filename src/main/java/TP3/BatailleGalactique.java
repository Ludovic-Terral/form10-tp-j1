package TP3;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class BatailleGalactique {
	
	private static final int TAILLE = 10;
    private static final int TAILLE0 = 8;
    private static final int TAILLE1 = 4;
    private static final char VIDE = '~';
    private static final char Universe = 'U';
    private static final char Sovereign = 'S';
    private static final char Ambassadeur = 'A';
    private static final char Constitution = 'C';
    private static final char Navette = 'N';
    private static final char TOUCHE = 'T';
    private static final char MANQUE = 'M';


    public static void main(String[] args) {

        char[][][] grille = new char[TAILLE0][TAILLE][TAILLE1];

        initialiserGrille(grille);

        placerVaisseaux(grille);

        jouer(grille);

    }

 

    private static void initialiserGrille(char[][][] grille) {

        for (int i = 0; i < TAILLE0; i++) {

            for (int j = 0; j < TAILLE; j++) {

                grille[i][j][0] = VIDE;
                grille[i][j][1] = VIDE;
                grille[i][j][2] = VIDE;
                grille[i][j][3] = VIDE;

            }
        }
    }

 

    private static void placerVaisseaux(char[][][] grille) {

        System.out.println("Placement des vaisseaux pour le Joueur 1 :");
        placerVaisseau(grille, "Universe", 3, 2, 0);
        placerVaisseau(grille, "Sovereign", 2, 2, 0);
        placerVaisseau(grille, "Ambassadeur", 3, 1, 0);
        placerVaisseau(grille, "Constitution", 3, 1, 0);
        placerVaisseau(grille, "Navette", 2, 1, 0);

        System.out.println("Placement des vaisseaux pour le Joueur 2 :");
        placerVaisseau(grille, "Universe", 3, 2, 1);
        placerVaisseau(grille, "Sovereign", 2, 2, 1);
        placerVaisseau(grille, "Ambassadeur", 3, 1, 1);
        placerVaisseau(grille, "Constitution", 3, 1, 1);
        placerVaisseau(grille, "Navette", 2, 1, 1);

    }


    private static void placerVaisseau(char[][][] grille, String nom, int largeur, int hauteur, int joueur) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Placement du vaisseau " + nom + " :");
        boolean placementValide = false;

        while (!placementValide) {

            System.out.println("Entrez la ligne et la colonne pour la pointe du vaisseau (format : ligne colonne) :");
            String input = scanner.nextLine().replaceAll("\\s", ""); 
            char lettre = Character.toUpperCase(input.charAt(0));
            int colonne = Integer.parseInt(input.substring(1)) - 1;
            int ligne = lettre - 'A';

            if (ligne < 0 || ligne >= TAILLE0 || colonne < 0 || colonne >= TAILLE) {
                System.out.println("Coordonnées invalides. Veuillez réessayer.");
                continue;
            }


            if (grille[ligne][colonne][joueur] == VIDE) {
                if (verifierPlacementPossible(grille, ligne, colonne, largeur, hauteur, joueur)) {
                    placementValide = true;
                    marquerVaisseau(grille, ligne, colonne, largeur, hauteur, joueur, nom);
                    afficherGrille(grille, joueur);
                } else {

                    System.out.println("Placement impossible. Veuillez réessayer.");
                }

            } else {

                System.out.println("Emplacement déjà occupé. Veuillez réessayer.");
            }
        }
    }

 

    private static boolean verifierPlacementPossible(char[][][] grille, int ligne, int colonne, int largeur, int hauteur, int joueur) {

        if (ligne + hauteur > TAILLE || colonne + largeur > TAILLE) {
            return false;
        }
        for (int i = ligne; i < ligne + hauteur; i++) {
            for (int j = colonne; j < colonne + largeur; j++) {
                if (grille[i][j][joueur] != VIDE) {
                    return false;
               }
            }
        }
        return true;
    }

 

    private static void marquerVaisseau(char[][][] grille, int ligne, int colonne, int largeur, int hauteur, int joueur, String nom) {

       System.out.println(nom);
       for (int i = ligne; i < ligne + hauteur; i++) {
            for (int j = colonne; j < colonne + largeur; j++) {
                  switch(nom) {
                  	case "Universe":
                  		grille[i][j][joueur] = Universe;
                    break;
                  	case "Sovereign":
                  		grille[i][j][joueur] = Sovereign;
                    break;
                  	case "Ambassadeur":
                  		grille[i][j][joueur] = Ambassadeur;
                    break;
                  	case "Constitution":
                  		grille[i][j][joueur] = Constitution;
                    break;
                  	case "Navette":
                  		grille[i][j][joueur] = Navette;
                    break;
            }

            }
        }
    }


    private static void jouer(char[][][] grille) {

        Scanner scanner = new Scanner(System.in);
        boolean fini = false;
        boolean fini0 = false;
        while (!fini0) {

            afficherGrille(grille, 2);
            santeVaisseau(grille, 0);
            System.out.println("Joueur 1, entrez les coordonnées de votre tir (ligne, colonne):");
            String input = scanner.nextLine().replaceAll("\\s", ""); 
            char lettre = Character.toUpperCase(input.charAt(0));
            int colonne = Integer.parseInt(input.substring(1)) - 1;
            int ligne = lettre - 'A';
            fini = tirer(grille, ligne, colonne, 2, 1);
            fini0 = verifierTableau(grille, 1);

            if (fini0 == false) {

                afficherGrille(grille, 3);
                santeVaisseau(grille, 1);
                System.out.println("Joueur 2, entrez les coordonnées de votre tir (ligne, colonne):");
                input = scanner.nextLine().replaceAll("\\s",""); 
                lettre = Character.toUpperCase(input.charAt(0));
                colonne = Integer.parseInt(input.substring(1)) - 1;
                ligne = lettre - 'A';
                fini = tirer(grille, ligne, colonne, 3, 0);
                fini0 = verifierTableau(grille, 0);
            }
        }
        System.out.println("Fin du jeu!");
    }


    private static void afficherGrille(char[][][] grille, int joueur) {

      clrscr();
      System.out.println("");
      System.out.println("  1 2 3 4 5 6 7 8 9 10");

        for (int i = 0; i < TAILLE0; i++) {

            char lettre = (char) ('a' + i);
            if (lettre >= 'a' && lettre <= 'h') {

                  char lettreMajuscule = Character.toUpperCase(lettre);
                System.out.print(lettreMajuscule + " ");
            }

            for (int j = 0; j < TAILLE; j++) {
                System.out.print(grille[i][j][joueur] + " ");
            }
            System.out.println();
        }
    }


    private static boolean tirer(char[][][] grille, int ligne, int colonne, int joueur ,int adv) {

        if (grille[ligne][colonne][adv] == Universe || grille[ligne][colonne][adv] == Sovereign || grille[ligne][colonne][adv] == Ambassadeur || grille[ligne][colonne][adv] == Constitution || grille[ligne][colonne][adv] == Navette) {
            grille[ligne][colonne][joueur] = TOUCHE;
            grille[ligne][colonne][adv] = TOUCHE;
            return true;
        } else {
            grille[ligne][colonne][joueur] = MANQUE;
            return false;
        }
    }
  

    public static boolean verifierTableau(char[][][] grille, int joueur) {

        for (int i = 0; i < TAILLE0; i++) {
            for (int j = 0; j < TAILLE; j++) {
                if (grille[i][j][joueur] == Universe || grille[i][j][joueur]  == Sovereign || grille[i][j][joueur]  == Ambassadeur || grille[i][j][joueur]  == Constitution || grille[i][j][joueur] == Navette) {
                    return false; 
                }
            }
        }
        return true; 
    }

   

    public static void clrscr()

    {
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

    private static void santeVaisseau(char[][][] grille, int joueur) {

      int a=0;
      int b=0;
      int c=0;
      int d=0;
      int e=0;
      int f=0;

      for (int i = 0; i < TAILLE0; i++) {
            for (int j = 0; j < TAILLE; j++) {
                switch(grille[i][j][joueur]) {
                case Universe:
                    a++;
                    break;

                case Sovereign:
                    b++;
                    break;

                case Ambassadeur:
                    c++;
                    break;

                case Constitution:
                    d++;
                    break;

                case Navette:
                    e++;
                    break;
            }
            }    
      }

      if (a != 0 && b != 0 && c != 0 && d != 0 && e != 0) {
          f = ((a + b + c + d + e) * 100) / 18;
          System.out.println("Flotte opérationnelle à " + f + "%");
      } else {
          f = 0;
          System.out.println("- Flotte desintégré");
      }
      if (a != 0) {
          a = (a * 100) / 6;
          System.out.println("- Vaisseau de classe Universe opérationnel à " + a + "%");
      } else {
          a = 0;
          System.out.println("- Vaisseau de classe Universe desintégré");
      }
      if (b != 0) {
          b = (b * 100) / 4;
          System.out.println("- Vaisseau de classe Sovereign opérationnel à " + b + "%");
      } else {
          b = 0;
          System.out.println("- Vaisseau de classe Sovereign desintégré");
      }

      if (c != 0) {
          c = (c * 100) / 3;
          System.out.println("- Vaisseau de classe Ambassadeur opérationnel à " + c + "%");
      } else {
            c = 0;
            System.out.println("- Vaisseau de classe Ambassadeur desintégré");
      }
     if (d != 0) {
          d = (d * 100) / 3;
          System.out.println("- Vaisseau de classe Constitution opérationnel à " + d + "%");
      } else {
           d = 0;
            System.out.println("- Vaisseau de classe Constitution desintégré");
      }

      if (e != 0) {
          e = (e * 100) / 2;
          System.out.println("- Navette opérationnel à " + e + "%");
      } else {
          e = 0;
          System.out.println("- Vaisseau de classe Navette desintégré");
      }
    }
    
    
}




