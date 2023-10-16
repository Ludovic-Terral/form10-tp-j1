package TP1;

public class BoiteDeVitesses {
    private int vitesse;  // Variable pour stocker la vitesse courante

    public BoiteDeVitesses() {
        vitesse = 0;  // Initialise la vitesse à 0 (point mort) au départ
    }

    public void changerVitesse(int nouvelleVitesse) {
        vitesse = nouvelleVitesse;
    }

    public void retrograder() {
        if (vitesse > 0) {
            vitesse--;
        }
    }

    public int getVitesse() {
        return vitesse;
    }

    public static void main(String[] args) {
        BoiteDeVitesses boite = new BoiteDeVitesses();

        System.out.println("-- Démarrage de la voiture --\n");

        for (int i = 0; i <= 6; i++) {
            boite.changerVitesse(i); // Changer de vitesse
            System.out.println("- La voiture est maintenant en " + boite.getVitesse() + "ème vitesse");
        }

        System.out.println("\n!! La voiture est à pleine vitesse !!\n");

        for (int i = 6; i > 0; i--) {
            boite.retrograder(); // Rétrograder
            System.out.println("- La voiture rétrograde à " + boite.getVitesse() + "ème vitesse");
        }

        System.out.println("\n-- La voiture est de retour au point mort --");
    }
}
