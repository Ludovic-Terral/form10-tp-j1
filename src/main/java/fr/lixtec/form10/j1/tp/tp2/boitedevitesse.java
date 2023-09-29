package fr.lixtec.form10.j1.tp.tp2;

public class boitedevitesse {
    private int vitesse = 0; // Vitesse actuelle de la voiture

    public void changerDeVitesse() {
        this.vitesse = vitesse + 1;
    }

    public void retrograder() {
        vitesse = vitesse - 1;
    }

    public int getVitesse() {
        return vitesse;
    }

    public static void main(String[] args) {
        boitedevitesse boiteDeVitesse = new boitedevitesse();

        while (boiteDeVitesse.getVitesse() < 6) {
            boiteDeVitesse.changerDeVitesse();
            System.out.println("Vitesse actuelle : " + boiteDeVitesse.getVitesse());
        }
        while (boiteDeVitesse.getVitesse() > 0) {
            boiteDeVitesse.retrograder();
            System.out.println("Vitesse actuelle : " + boiteDeVitesse.getVitesse());
        }

    }
}

