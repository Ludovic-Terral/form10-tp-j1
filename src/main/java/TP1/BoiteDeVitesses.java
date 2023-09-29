package TP1;

public class BoiteDeVitesses {
    private int vitesseCourante;

    public BoiteDeVitesses() {
        this.vitesseCourante = 0;
    }

    public void changerVitesse() {
        vitesseCourante++;
        System.out.println("Accélération ! Vitesse changée à " + vitesseCourante);
    }

    public void retrograder() {
        if (vitesseCourante > 0) {
            vitesseCourante--;
            System.out.println("Rétrogradé à la vitesse " + vitesseCourante);
        }
    }

    public int getVitesse() {
        return vitesseCourante;
    }

    public static void main(String[] args) {
        BoiteDeVitesses maBoite = new BoiteDeVitesses();
        int distance = 0;
        System.out.println("Début de la course de 400m. Vitesse courante : " + maBoite.getVitesse());

        // Accélérer jusqu'à la 6e vitesse
        for (int i = 0; i < 6; i++) {
            maBoite.changerVitesse();
            distance += 60;  // Simule un gain de distance
            System.out.println("Distance parcourue : " + distance + "m");
        }

        // Rétrograder au point mort
        for (int i = 0; i < 6; i++) {
            maBoite.retrograder();
            distance += 20;  // Simule un gain de distance moins important
            System.out.println("Distance parcourue : " + distance + "m");
        }

        System.out.println("Fin de la course. Vitesse courante : " + maBoite.getVitesse());
    }
}
