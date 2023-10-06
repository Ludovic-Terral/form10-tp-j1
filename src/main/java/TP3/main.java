import java.util.Scanner;

public class BatailleGalactique {
    public static void main(String[] args) {
        // Initialisation
        Scanner scanner = new Scanner(System.in);
        Joueur joueur1 = new Joueur("Joueur 1");
        Joueur joueur2 = new Joueur("Joueur 2");

        // Configuration des vaisseaux pour chaque joueur
        System.out.println("Configuration des vaisseaux pour Joueur 1:");
        joueur1.configurerFlotte(scanner);

        System.out.println("Configuration des vaisseaux pour Joueur 2:");
        joueur2.configurerFlotte(scanner);

        // Début du jeu
        Joueur joueurActif = joueur1;
        Joueur joueurPassif = joueur2;

        while (true) {
            clrscr();
            System.out.println("Tour de " + joueurActif.getNom());

            // Affichage de l'état de la flotte
            joueurActif.afficherEtatFlotte();

            // Demander les coordonnées de tir
            System.out.print("Entrez les coordonnées de tir (ex: H7): ");
            String coord = scanner.next();

            // Résultat du tir
            String resultatTir = joueurPassif.tirRecu(coord);
            System.out.println("Résultat du tir : " + resultatTir);

            // Afficher la grille de tir
            joueurActif.afficherGrilleTirs();

            // Vérifier si le jeu est terminé
            if (joueurPassif.flotteDetruite()) {
                System.out.println(joueurActif.getNom() + " a gagné la partie!");
                break;
            }

            // Changement de joueur
            Joueur temp = joueurActif;
            joueurActif = joueurPassif;
            joueurPassif = temp;
        }
        
        scanner.close();
    }

    public static void clrscr() {
        // Code pour nettoyer la console
    }
}

