package fr.lixtec.form10.j1.tp.tp1;

public class BoiteVitesse {
	
	private int VitesseActuelle = 0; //Au point mort au début
	

	public void changerVitesse() {
		VitesseActuelle++;
	}
	
	public void retrograder() {
		VitesseActuelle--;
	}
	
	public int getVitesse() {
		return VitesseActuelle;
	}
	
	public static void main(String[] args) {
		
		BoiteVitesse boitedevitesse = new BoiteVitesse();
		
		for (int i = 0; i < 6; i++) {
			boitedevitesse.changerVitesse();
			System.out.print("La vitesse augmente a " + boitedevitesse.getVitesse());
			System.out.print("\n");
		}
		
		for (int i = 6; i > 0; i--) {
			boitedevitesse.retrograder();
			System.out.print("La vitesse retrograde a " + boitedevitesse.getVitesse());
			System.out.print("\n");
		}
		
    }
}
