package tp3;

import java.util.Scanner;

public class BatailleSpatiale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Demander les noms des joueurs
        System.out.print("Entrez le nom du Joueur 1 : ");
        String nomJoueur1 = scanner.nextLine();
        System.out.print("Entrez le nom du Joueur 2 : ");
        String nomJoueur2 = scanner.nextLine();

        // Créer les joueurs
        Joueur joueur1 = new Joueur(nomJoueur1, 10);
        Joueur joueur2 = new Joueur(nomJoueur2, 10);

        // Configurer la flotte de chaque joueur
        joueur1.configurerFlotte();
        joueur2.configurerFlotte();

        boolean joueur1Tour = true;
        boolean partieTerminee = false;

        while (!partieTerminee) {
            // Afficher l'état du jeu
            System.out.println("\nTour de " + (joueur1Tour ? joueur1.getNom() : joueur2.getNom()));

            // Afficher l'état de la flotte et des vaisseaux
            System.out.println("État de la flotte de " + joueur1.getNom() + ":");
            joueur1.getGrille().afficherGrille(false);

            System.out.println("État de la flotte de " + joueur2.getNom() + ":");
            joueur2.getGrille().afficherGrille(false);

            // Demander les coordonnées de tir et effectuer le tir
            Joueur attaquant = joueur1Tour ? joueur1 : joueur2;
            Joueur defenseur = joueur1Tour ? joueur2 : joueur1;

            boolean tirReussi = attaquant.effectuerTir(defenseur);

            // Mettre à jour l'état du jeu
            partieTerminee = defenseur.flotteDetruite();

            // Vérifier si la partie est terminée
            if (partieTerminee) {
                System.out.println("La flotte de " + defenseur.getNom() + " a été détruite.");
                System.out.println("Félicitations, " + attaquant.getNom() + ", vous avez gagné la partie !");
            } else {
                System.out.println("Appuyez sur Entrée pour passer au tour suivant...");
                scanner.nextLine(); // Attendre l'entrée pour passer au tour suivant
            }

            // Passer au tour suivant
            joueur1Tour = !joueur1Tour;
        }

        scanner.close();
    }
}
