package fr.lixtec.form10.j1.tp.tp2;

public class BoiteDeVitesses {
	private int vitesse = 0;
	private int vitessesMax = 0;
	
	public BoiteDeVitesses(int vitessesMax){ 
		vitesse = 0;
		this.vitessesMax = vitessesMax;
	}
	
	public void changerVitesse() {
		if(vitesse < vitessesMax) {
			this.vitesse++;
			System.out.printf("You've upshifted to %d\n", vitesse);
		}else System.out.printf("Already at top gear!\n");
	}
	
	public void retrograder() {
		if(vitesse > 0) {
			this.vitesse--;
			System.out.printf("You've downshifted to %d\n", vitesse);
		}else System.out.printf("Already at bottom gear!\n");
	}
	
	public int getVitesse() {
		return vitesse;
	}
	
	
	
	public static void main(String[] args) {
		BoiteDeVitesses boiteDeVitesses = new BoiteDeVitesses(6); 
		boiteDeVitesses.changerVitesse();
		boiteDeVitesses.changerVitesse();
		boiteDeVitesses.changerVitesse();
		boiteDeVitesses.changerVitesse();
		boiteDeVitesses.changerVitesse();
		boiteDeVitesses.changerVitesse();
		boiteDeVitesses.changerVitesse();
		System.out.printf("vitesse : %d\n", boiteDeVitesses.getVitesse());
		boiteDeVitesses.retrograder();
	}
}
