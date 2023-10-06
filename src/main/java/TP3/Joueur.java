import java.util.Scanner;
import java.util.HashMap;

public class Joueur {
    private String nom;
    private HashMap<String, Vaisseau> flotte;
    private char[][] grille;

    public Joueur(String nom) {
        this.nom = nom;
        flotte = new HashMap<>();
        grille = new char[10][10];
    }

    public String getNom() {
        return nom;
    }

    public void configurerFlotte(Scanner scanner) {
        System.out.println("Configurer " + nom);
        // Faire ici le placement des vaisseaux dans la grille et la flotte
    }

    public String tirRecu(String coord) {
        // Gérer ici ce qui se passe lorsqu'un tir est reçu
        return "loupé"; // ou "touché", ou "désintégré"
    }

    public void afficherEtatFlotte() {
        // Afficher ici l'état de la flotte
    }

    public boolean flotteDetruite() {
        // Vérifier si la flotte est détruite
        return false;
    }
}

