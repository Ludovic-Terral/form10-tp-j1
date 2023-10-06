package fr.lixtec.form10.j1.tp.tp3;

public abstract class Vaisseau {
    private String nom;
    private int longueur;
    private int largeur;
    private int pointsDeVie;
    
    public Vaisseau(String nom, int longueur, int largeur, int pointsDeVie) {
        this.nom = nom;
        this.longueur = longueur;
        this.largeur = largeur;
        this.pointsDeVie = pointsDeVie;
    }
    
    public String getNom() {
        return nom;
    }
    
    public int getLongueur() {
        return longueur;
    }
    
    public int getLargeur() {
        return largeur;
    }
    
    public int getPointsDeVie() {
        return pointsDeVie;
    }
    
    public void prendreDegats(int degats) {
        pointsDeVie -= degats;
    }
    
    public boolean estDetruit() {
        return pointsDeVie <= 0;
    }
    
    
    public abstract void afficherInfos();
    public abstract char getSymbole();
}