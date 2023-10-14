package TP3;
import java.util.Scanner;
import java.io.IOException;

public class GalacticBattle {
	private static final int LIGNE = 10;
    private static final int COLOMNE = 8;
    private static final char VIDE = ' ';
    private static final char Universe = 'U';
    private static final char Sovereign = 'S';
    private static final char Ambassadeur = 'A';
    private static final char Constitution = 'C';
    private static final char Navette = 'N';
    private static final char TOUCHE = 'T';
    private static final char MANQUE = 'M';
    private static boolean fin = false;

    public static void main(String[] args) {
        char[][] joueur1 = new char[LIGNE][COLOMNE];
        char[][] joueur2 = new char[LIGNE][COLOMNE];
        initialiserGrille(joueur1);
        afficherGrille(joueur1);
        placerVaisseaux(joueur1,"joueur1");
        initialiserGrille(joueur2);
        afficherGrille(joueur2);
        placerVaisseaux(joueur2,"joueur2");
        while(!fin) {
        jouer(joueur1,"joueur1");
        if (fin==true) {
        	System.out.println("Le joueur 1 a gagné");
        	return;
        }
        jouer(joueur2,"joueur2");
        if (fin==true) System.out.println("Le joueur 1 a gagné");
        }
    }
    
    private static void initialiserGrille(char[][] grille) {
        for (int i = 0; i < LIGNE; i++) {
            for (int j = 0; j < COLOMNE; j++) {
                grille[i][j] = VIDE;
            }
        }
    }

    private static void placerVaisseaux(char[][] grille, String nom) {
        System.out.println("Placement des vaisseaux pour "+nom+" :");
        placerVaisseau(grille, "Universe", 3, 2);
        placerVaisseau(grille, "Sovereign", 2, 2);
        placerVaisseau(grille, "Ambassadeur", 3, 1);
        placerVaisseau(grille, "Constitution", 3, 1);
        placerVaisseau(grille, "Navette", 2, 1);
    }


    private static void placerVaisseau(char[][] grille, String nom, int largeur, int hauteur) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Placement du vaisseau " + nom + " :");
    	boolean placementValide = false;

    	while (!placementValide) {
    		System.out.print("Entrez la ligne :");
    		int row = scanner.nextInt();
    		scanner.nextLine();
    		System.out.print("Entrez la colomne en majuscule :");
    		String str = scanner.nextLine();
    		int col = (int) str.charAt(0)-65;

    		if (row < 0 || row >= LIGNE || col < 0 || col >= COLOMNE) {
    			System.out.println("Coordonnées invalides. Veuillez réessayer.");
    			continue;
    		}

    		if (grille[row][col] == VIDE) {
    			if (verifierPlacementPossible(grille, row, col, largeur, hauteur)) {
    				placementValide = true;
    				marquerVaisseau(grille, row, col, largeur, hauteur, nom);
    				afficherGrille(grille);
    			} 
    			else System.out.println("Placement impossible. Veuillez réessayer.");

    		} 
    		else System.out.println("Emplacement déjà occupé. Veuillez réessayer.");
    	}
    }

    private static boolean verifierPlacementPossible(char[][] grille, int ligne, int colonne, int largeur, int hauteur) {
        if (ligne + hauteur > LIGNE || colonne + largeur > COLOMNE) return false;
        for (int i = ligne; i < ligne + hauteur; i++) {
            for (int j = colonne; j < colonne + largeur; j++) {
                if (grille[i][j] != VIDE) return false;
            }
        }
        return true;
    }

    private static void marquerVaisseau(char[][] grille, int row, int col, int largeur, int hauteur, String nom) {
       System.out.println(nom);
       for (int i = row; i < row + hauteur; i++) {
            for (int j = col; j < col + largeur; j++) {
                  switch(nom) {
                  	case "Universe":
                  		grille[i][j] = Universe;
                    break;
                  	case "Sovereign":
                  		grille[i][j] = Sovereign;
                    break;
                  	case "Ambassadeur":
                  		grille[i][j] = Ambassadeur;
                    break;
                  	case "Constitution":
                  		grille[i][j] = Constitution;
                    break;
                  	case "Navette":
                  		grille[i][j] = Navette;
                    break;
            }

            }
        }
    }


    private static void jouer(char[][] grille, String nom) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(nom+", préparez votre tir :");
        System.out.print("Entrez la ligne :");
        int row = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Entrez la colomne en majuscule :");
        String str = scanner.nextLine();
        int col = (int) str.charAt(0)-65;
        tirer(grille, row, col);
        afficherGrille(grille);
        santeVaisseau(grille);
    }

    private static void afficherGrille(char[][] grille) {

      clrscr();
      System.out.println("");
      System.out.print("   ");
      for (int i = 1; i < LIGNE+1; i++) {
    	  System.out.print(" " + i);
      }
      System.out.println();
        for (int i = 0; i < COLOMNE; i++) {
            char lettre = (char) ('a' + i);
            char lettreMajuscule = Character.toUpperCase(lettre);
            System.out.print(lettreMajuscule + " ");

            for (int j = 0; j < LIGNE; j++) {
                System.out.print(grille[j][i] + " ");
            }
            System.out.println();
        }
    }

    private static char[][] tirer(char[][] grille, int row, int col) {
        if (grille[row][col] == Universe || grille[row][col] == Sovereign || grille[row][col] == Ambassadeur || grille[row][col] == Constitution || grille[row][col] == Navette) {
            grille[row][col] = TOUCHE;
            grille[row][col] = TOUCHE;
            return grille;
        } else {
            grille[row][col] = MANQUE;
            return grille;
        }
    }
  

    public static boolean verifierTableau(char[][] grille) {
        for (int i = 0; i < LIGNE; i++) {
            for (int j = 0; j < COLOMNE; j++) {
                if (grille[i][j] == Universe || grille[i][j]  == Sovereign || grille[i][j]  == Ambassadeur || grille[i][j]  == Constitution || grille[i][j] == Navette)
                    return false; 
            }
        }
        return true; 
    }

    public static void clrscr() {
       try
        {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else Runtime.getRuntime().exec("clear");
        }
        catch (IOException | InterruptedException ex)
        {
        	System.out.println("erreur canard. C'est mal");
        }
    }

    private static void santeVaisseau(char[][] grille) {
      int a=0;
      int b=0;
      int c=0;
      int d=0;
      int e=0;
      int f=0;
      for (int i = 0; i < LIGNE; i++) {
            for (int j = 0; j < COLOMNE; j++) {
                switch(grille[i][j]) {
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
      if (a != 0 || b != 0 || c != 0 || d != 0 || e != 0) {
          f = ((a + b + c + d + e) * 100) / 18;
          System.out.println("Flotte opérationnelle à " + f + "%");
      } else {
          f = 0;
          System.out.println("- Flotte desintégré");
          fin = true;
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