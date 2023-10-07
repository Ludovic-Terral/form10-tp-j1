package fr.lixtec.form10.j1.tp.tp2.TP1;

public class Ascenseur {
	private int etage = 0;
	
	
	public Ascenseur() {
		etage = 0;
	}
	
	public int getEtage() {
		return etage;
	}
	
	public void appelerDepuis(int etage) {
		int direction = this.etage > etage ? -1 : +1;
		for(int i = this.etage; i<= etage; i+=direction) {
			System.out.printf("Elevator moved to %d floor.\n", i);
		}
	}
	
	
	public static void main(String[] args) {
		Ascenseur ascenseur = new Ascenseur();
		ascenseur.appelerDepuis(5);
	}
}