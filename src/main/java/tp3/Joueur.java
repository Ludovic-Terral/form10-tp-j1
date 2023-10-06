package tp3;

import java.util.Scanner;

public class Joueur {
    private final String nom;
    private final Grille grille;

    public Joueur(String nom, int tailleGrille) {
        this.nom = nom;
        this.grille = new Grille(tailleGrille);
    }

    public String getNom() {
        return nom;
    }

    public Grille getGrille() {
        return grille;
    }

    public void configurerFlotte() {
        System.out.println("Configuration de la flotte pour le joueur " + nom);
        grille.afficherGrille(false); // Afficher la grille vide

        for (Vaisseau.Type type : Vaisseau.Type.values()) {
            boolean placementValide = false;
            while (!placementValide) {
                System.out.println("Placez le vaisseau de classe " + type.getNom() + " (" + type.getLargeur() + "x" + type.getHauteur() + " cases) :");
                System.out.print("Entrez les coordonnées (par exemple, A1) : ");
                String coordonnees = lireCoordonnees();

                Vaisseau vaisseau = new Vaisseau(type);
                vaisseau.setPosition(coordonnees);

                if (grille.placerVaisseau(vaisseau)) {
                    placementValide = true;
                    grille.afficherGrille(false); // Afficher la grille après chaque placement
                } else {
                    System.out.println("Placement invalide. Réessayez.");
                }
            }
        }
    }

    private String lireCoordonnees() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toUpperCase();
    }

    public boolean effectuerTir(Joueur adversaire) {
        System.out.println("C'est le tour de " + nom);
        System.out.print("Entrez les coordonnées de tir (par exemple, A1) : ");
        String coordonnees = lireCoordonnees();

        boolean tirReussi = adversaire.getGrille().tirer(coordonnees);

        if (tirReussi) {
            System.out.println("Touché !");
        } else {
            System.out.println("Loupé.");
        }

        grille.afficherGrille(true); // Afficher la grille avec les tirs

        return tirReussi;
    }

    public boolean flotteDetruite() {
        return grille.flotteDetruite();
    }
}
