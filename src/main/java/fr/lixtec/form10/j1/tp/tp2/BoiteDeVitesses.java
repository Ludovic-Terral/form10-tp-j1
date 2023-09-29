package fr.lixtec.form10.j1.tp.tp2;

public class BoiteDeVitesses {

    private int vitesseCourante;

    public BoiteDeVitesses() {
        this.vitesseCourante = 0; //point mort
    }

    public void changerVitesse(int nouvelleVitesse) {
        vitesseCourante = nouvelleVitesse;
    }

    public void retrograder() {
        if (vitesseCourante > 0) {
            vitesseCourante--;
        }
    }

    public int getVitesse() {
        return vitesseCourante;
    }

    public static void main(String[] args) {
        BoiteDeVitesses boiteDeVitesses = new BoiteDeVitesses(); // creation instance

        System.out.println("L'auto prend son envol.");

        for (int i = 0; i <= 6; i++) {
            boiteDeVitesses.changerVitesse(i);
            System.out.println("L'auto est en " + boiteDeVitesses.getVitesse() + "e vitesse.");
        }

        // Retrogradons jusqu'au point mort
        while (boiteDeVitesses.getVitesse() > 0) {
            boiteDeVitesses.retrograder();
            System.out.println("L'auto est en " + boiteDeVitesses.getVitesse() + "e vitesse.");
        }

        System.out.println("L'auto est stoppée.");
    }
}
