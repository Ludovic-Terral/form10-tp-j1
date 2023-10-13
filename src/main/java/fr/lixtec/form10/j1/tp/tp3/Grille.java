package fr.lixtec.form10.j1.tp.tp3;

public class Grille {
    private static final int TAILLE_GRILLE_LIGNE = 10;
    private static final int TAILLE_GRILLE_COLONNE = 8;
    private static final char CASE_VIDE = ' ';

    private char[][] grille;

    public Grille() {
        this.grille = new char[TAILLE_GRILLE_LIGNE][TAILLE_GRILLE_COLONNE];
        initialiserGrille();
    }

    private void initialiserGrille() {
        // Initialiser la grille avec des cases vides
        for (int i = 0; i < TAILLE_GRILLE_LIGNE; i++) {
            for (int j = 0; j < TAILLE_GRILLE_COLONNE; j++) {
                grille[i][j] = CASE_VIDE;
            }
        }
    }

    public void afficher() {
        System.out.print("    ");
        for (int i = 0; i < TAILLE_GRILLE_COLONNE; i++) {
            System.out.print("  " + (char) ('A' + i) + " ");
        }
        System.out.println();

        for (int i = 0; i < TAILLE_GRILLE_LIGNE; i++) {
            System.out.print(" ");
            int numLigne = i + 1;
            if (numLigne < 10) {
                System.out.print(" ");
            }
            System.out.print(numLigne + " |");

            for (int j = 0; j < TAILLE_GRILLE_COLONNE; j++) {
                System.out.print(" " + grille[i][j] + " |");
            }
            System.out.println();
            System.out.println("    +---+---+---+---+---+---+---+---+");
        }
        System.out.println();
    }





    public void placerBateau(Bateau bateau) {
        // Assurez-vous que les coordonnées du bateau sont valides
        int ligne = bateau.getLigne();
        int colonne = bateau.getColonne();
        int taille = bateau.getTaille();
        char orientation = bateau.getOrientation();

        if (ligne < 1 || ligne > TAILLE_GRILLE_LIGNE || colonne < 1 || colonne > TAILLE_GRILLE_COLONNE) {
            System.out.println("Coordonnées invalides pour le placement du bateau.");
            return;
        }

        // Vérifiez que le placement est possible
        if (orientation == 'H') {
            if (colonne + taille - 1 > TAILLE_GRILLE_COLONNE) {
                System.out.println("Placement impossible pour le bateau.");
                return;
            }
            for (int j = colonne - 1; j < colonne + taille - 1; j++) {
                if (grille[ligne - 1][j] != CASE_VIDE) {
                    System.out.println("Case déjà occupée.");
                    return;
                }
            }
            // Placez le bateau
            for (int j = colonne - 1; j < colonne + taille - 1; j++) {
                grille[ligne - 1][j] = 'B'; // 'B' pour représenter le bateau
            }
        } else if (orientation == 'V') {
            if (ligne + taille - 1 > TAILLE_GRILLE_LIGNE) {
                System.out.println("Placement impossible pour le bateau.");
                return;
            }
            for (int i = ligne - 1; i < ligne + taille - 1; i++) {
                if (grille[i][colonne - 1] != CASE_VIDE) {
                    System.out.println("Case déjà occupée.");
                    return;
                }
            }
            // Placez le bateau
            for (int i = ligne - 1; i < ligne + taille - 1; i++) {
                grille[i][colonne - 1] = 'B'; // 'B' pour représenter le bateau
            }
        }
    }
    
    public static void main(String[] args) {
		
		Grille g1 = new Grille();
		g1.afficher();
		System.out.println();
		Grille g2 = new Grille();
		g2.afficher();
	}

}
