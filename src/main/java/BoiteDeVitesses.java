
public class BoiteDeVitesses {
	private static int vitesseActuelle;

	
	public int changerVitesse() {
		int newVitesse = vitesseActuelle+1;
		vitesseActuelle = newVitesse;
		return (newVitesse);
		
	}
	
	public int retrograder() {
	    int newVitesse2 = vitesseActuelle - 1;
	    if (newVitesse2 >= 0) {
	        vitesseActuelle = newVitesse2;
	    } else {
	        System.out.println("Impossible de rétrograder, la boîte de vitesse est au point mort");
	    }
	    return newVitesse2;
	}
	
	
	public static int getVitesse() {
		return vitesseActuelle;}
	
	
	public static void main(String[] args) {
	    BoiteDeVitesses boiteDeVitesse = new BoiteDeVitesses();

	    int nouvelleVitesse = boiteDeVitesse.changerVitesse();
	    System.out.println("Nouvelle vitesse : " + nouvelleVitesse);

	    int vitesseRetrogradee = boiteDeVitesse.retrograder();
	    if (vitesseRetrogradee >= 0) {
	        System.out.println("Vitesse retrogradee : " + vitesseRetrogradee);
	    }
	}

}
