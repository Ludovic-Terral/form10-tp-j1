package fr.lixtec.form10.j1.tp.tp1;

public class Ascenseur {
	private static int etageActuel;

	public static int getEtage() {
		return etageActuel;
	}
	
	public static int appelerDepuis(int etage){
        if (etage > etageActuel) {
            monterA(etage);
        } else if (etage < etageActuel) {
            descendreA(etage);
        }
        return etage;
    }

    private static void monterA(int etage) {
        System.out.println("L'ascenseur monte a l'etage " + etage);
        etageActuel = etage;
    }

    private static void descendreA(int etage) {
        System.out.println("L'ascenseur descend a l'etage " + etage);
        etageActuel = etage;
    }


public static void main(String[] args) {
    Ascenseur ascenseur = new Ascenseur();

    int etageActuel = Ascenseur.getEtage();
    System.out.println("L'ascenseur est a l'etage " + etageActuel);

    int etageAppel = 5;
    int nouvelEtage = Ascenseur.appelerDepuis(etageAppel);
    System.out.println("L'ascenseur est maintenant a l'etage " + nouvelEtage);
    
}

}