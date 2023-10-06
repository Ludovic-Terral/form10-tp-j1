package tp3;

import java.util.Arrays;
public class Grille {
    private final char[][] grille;
    private final int taille;
    private final char[][] grilleTirs; // Grille pour les tirs (T pour touché, L pour loupé)

    public Grille(int taille) {
        this.taille = taille;
        this.grille = new char[taille][taille];
        this.grilleTirs = new char[taille][taille];
        initialiserGrille();
    }

    private void initialiserGrille() {
        for (int i = 0; i < taille; i++) {
            Arrays.fill(grille[i], ' ');
            Arrays.fill(grilleTirs[i], ' ');
        }
    }

    public void afficherGrille(boolean afficherTirs) {
        System.out.print("  ");
        for (int i = 0; i < taille; i++) {
            System.out.print((char) ('A' + i) + " ");
        }
        System.out.println();

        for (int i = 0; i < taille; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < taille; j++) {
                char affichage = grille[i][j];
                if (afficherTirs) {
                    char tir = grilleTirs[i][j];
                    if (tir == 'T') {
                        affichage = 'T'; // Afficher 'T' pour touché
                    } else if (tir == 'L') {
                        affichage = 'L'; // Afficher 'L' pour loupé
                    }
                }
                System.out.print(affichage + " ");
            }
            System.out.println();
        }
    }

    public boolean placerVaisseau(Vaisseau vaisseau) {
        String position = vaisseau.getPosition();
        int largeur = vaisseau.getLargeur();
        int hauteur = vaisseau.getHauteur();

        int x = position.charAt(0) - 'A'; // Conversion de la lettre en indice de colonne
        int y = Integer.parseInt(position.substring(1)) - 1; // Conversion du chiffre en indice de ligne

        if (x < 0 || x >= taille || y < 0 || y >= taille) {
            return false; // Coordonnées invalides
        }

        if (x + largeur > taille || y + hauteur > taille) {
            return false; // Le vaisseau ne rentre pas dans la grille
        }

        for (int i = x; i < x + largeur; i++) {
            for (int j = y; j < y + hauteur; j++) {
                if (grille[i][j] != ' ') {
                    return false; // Emplacement déjà occupé
                }
            }
        }

        // Placer le vaisseau
        for (int i = x; i < x + largeur; i++) {
            for (int j = y; j < y + hauteur; j++) {
                grille[i][j] = 'S'; // 'S' pour vaisseau
            }
        }

        return true; // Vaisseau placé avec succès
    }

    public boolean tirer(String coordonnees) {
        int x = coordonnees.charAt(0) - 'A'; // Conversion de la lettre en indice de colonne
        int y = Integer.parseInt(coordonnees.substring(1)) - 1; // Conversion du chiffre en indice de ligne

        if (x < 0 || x >= taille || y < 0 || y >= taille) {
            System.out.println("Coordonnées invalides.");
            return false; // Coordonnées invalides
        }

        char cible = grille[x][y];
        if (cible == 'S') {
            grille[x][y] = 'X'; // 'X' pour vaisseau touché
            grilleTirs[x][y] = 'T'; // 'T' pour touché
            return true; // Touché
        } else if (cible == ' ') {
            grilleTirs[x][y] = 'L'; // 'L' pour loupé
            return false; // Loupé
        } else if (cible == 'X' || cible == 'T' || cible == 'L') {
            System.out.println("Coordonnées déjà ciblées.");
            return false; // Coordonnées déjà ciblées
        }

        return false;
    }

    public boolean flotteDetruite() {
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                if (grille[i][j] == 'S') {
                    return false; // Il reste au moins un vaisseau
                }
            }
        }
        return true; // Tous les vaisseaux ont été détruits
    }
}
