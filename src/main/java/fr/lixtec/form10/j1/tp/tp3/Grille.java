package fr.lixtec.form10.j1.tp.tp3;

public class Grille {
    private char[][] grille;
    private int lignes;
    private int colonnes;
    private boolean naviresReveles;

    public Grille(int lignes, int colonnes) {
        this.lignes = lignes;
        this.colonnes = colonnes;
        this.grille = new char[lignes][colonnes];
        this.naviresReveles = false; // Navires pas révélés
        initialiserGrille();
    }

    private void initialiserGrille() {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                grille[i][j] = '~';
            }
        }
    }

    public void revelerNavires() {
        naviresReveles = true;
    }

    public void masquerNavires() {
        naviresReveles = false;
    }

    public void afficherGrille() {
        System.out.println("Grille :");
        System.out.println("  1 2 3 4 5 6 7 8 9 10");

        char lettre = 'A';
        for (int i = 0; i < lignes; i++) {
            System.out.print(lettre + " ");
            for (int j = 0; j < colonnes; j++) {
                if (!naviresReveles && grille[i][j] != '~') {
                    System.out.print('~' + " ");
                } else {
                    System.out.print(grille[i][j] + " ");
                }
            }
            System.out.println();
            lettre++;
        }
        System.out.println();
    }
}
