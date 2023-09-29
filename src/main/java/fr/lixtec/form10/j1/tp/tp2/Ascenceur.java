package fr.lixtec.form10.j1.tp.tp2;
public class Ascenceur {
    private int etageActuel; // Numéro de l'étage actuel

    public Ascenceur() {
        this.etageActuel = 0; // L'ascenseur démarre au rez-de-chaussée (étage 0)
    }

    public int getEtage() {
        return etageActuel;
    }

    public void appelerDepuis(int etage) {
        if (etage < 0) {
            System.out.println("L'étage spécifié est invalide.");
        } else {
            // Déplacer l'ascenseur jusqu'à l'étage spécifié
            etageActuel = etage;
        }
    }

    public static void main(String[] args) {
        Ascenceur ascenseur = new Ascenceur();

        // Appeler l'ascenseur depuis l'étage 5
        ascenseur.appelerDepuis(2);

        // Obtenir l'étage actuel de l'ascenseur
        int etageActuel = ascenseur.getEtage();
        System.out.println("L'ascenseur se trouve actuellement à l'étage " + etageActuel);
    }
}
