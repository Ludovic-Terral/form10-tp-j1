package fr.lixtec.form10.j1.tp.tp3;

public class Bateau {
    private String nom;
    private int taille;
    private char orientation;
    private int ligne;
    private int colonne;

    public Bateau(String nom, int taille, char orientation) {
        this.nom = nom;
        this.taille = taille;
        this.orientation = orientation;
    }

    public String getNom() {
        return nom;
    }

    public int getTaille() {
        return taille;
    }

    public char getOrientation() {
        return orientation;
    }

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public void setCoordonnees(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
    }
}

