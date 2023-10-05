package fr.lixtec.form10.j1.tp.tp2;

public class Ascenseur {
    private int etage = 0; // on commence au rez-de-chaussée
    public int getEtage() { return this.etage; } // lecture seule

    public void appelerDepuis(int etage) {
        int direction = etage > this.etage ? +1 : -1;

        while (etage != this.etage) {
            System.out.format("L'ascenseur est au %d.\n", this.etage);
            this.etage += direction;
        }
        System.out.format("L'ascenseur est bien arrivé au %d.\n", this.etage);
    }

    public static void main(String[] args) {
        // testing
        Ascenseur asc = new Ascenseur();

		System.out.format("@%d\n", asc.getEtage());
		asc.appelerDepuis(5);
		System.out.format("@%d\n", asc.getEtage());
		asc.appelerDepuis(2);
		System.out.format("@%d\n", asc.getEtage());
		asc.appelerDepuis(12);
		System.out.format("@%d\n", asc.getEtage());
		asc.appelerDepuis(-4);
		System.out.format("@%d\n", asc.getEtage());
		asc.appelerDepuis(0);
        System.out.format("@%d\n", asc.getEtage());
    }
}