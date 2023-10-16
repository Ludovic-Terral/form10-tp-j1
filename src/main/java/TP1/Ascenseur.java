package TP1;

public class Ascenseur {
    private int etageCourant;

    public Ascenseur() {
        this.etageCourant = -1;
    }

    public int getEtage() {
        return etageCourant;
    }

    public void deplacer(int nouvelEtage) {
        etageCourant = nouvelEtage;
        System.out.println("Ascenseur est appelé au : " + this.etageCourant);
    }

    public static void main(String[] args) {
        Ascenseur monAscenseur = new Ascenseur();
        System.out.println("Étage courant : " + monAscenseur.getEtage());

        monAscenseur.deplacer(4);
        System.out.println("Étage courant : " + monAscenseur.getEtage());

        monAscenseur.deplacer(1);
        System.out.println("Étage courant : " + monAscenseur.getEtage());
    }
}
