package TP1;

public class Ascenseur {
    private int etageCourant;

    public Ascenseur() {
        this.etageCourant = 0;
    }

    public int getEtage() {
        return etageCourant;
    }

    public void appelerDepuis(int etage) {
        etageCourant = etage;
        System.out.println("Ascenseur est appelé à l'étage " + etageCourant);
    }

    public static void main(String[] args) {
        Ascenseur monAscenseur = new Ascenseur();
        System.out.println("Étage courant : " + monAscenseur.getEtage());

        monAscenseur.appelerDepuis(5);
        System.out.println("Étage courant : " + monAscenseur.getEtage());

        monAscenseur.appelerDepuis(2);
        System.out.println("Étage courant : " + monAscenseur.getEtage());
    }
}
