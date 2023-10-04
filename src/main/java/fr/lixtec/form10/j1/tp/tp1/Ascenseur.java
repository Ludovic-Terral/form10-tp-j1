package fr.lixtec.form10.j1.tp.tp1;

public class Ascenseur {
    private int etageActuel = 0;

    public int getEtage() {
        return etageActuel;
    }

    public void EtageDemander(int etage) {
        System.out.println("Du " + etageActuel + " au " + etage);
        etageActuel = etage;
    }

    public static void main(String[] args) {
        Ascenseur ascenseur = new Ascenseur();

        System.out.println("Etage Actuelle " + ascenseur.getEtage());

        ascenseur.EtageDemander(5);
        
        System.out.println("Il est au " + ascenseur.getEtage());

    }
}
