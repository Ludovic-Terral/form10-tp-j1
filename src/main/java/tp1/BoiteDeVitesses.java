package tp1;

public class BoiteDeVitesses {

	private int vitesse_actuel = 0;
	
	public BoiteDeVitesses() {
		this.vitesse_actuel=0;
	}
	public int changerVitesse(int vitesse) {
		vitesse_actuel = vitesse;
		System.out.println("La vitesse a changé vers la " + vitesse_actuel);
		return(vitesse_actuel);
	}
	
	public int retrograder() {
		if(vitesse_actuel==0)System.out.println("Impossible la vitesse est au point mort");
		else{vitesse_actuel = vitesse_actuel-1;System.out.println("La vitesse a changé vers la " + vitesse_actuel);}
		return(vitesse_actuel-1);
	}
	
	public int getVitesse() {
		if(vitesse_actuel==0)System.out.println("La vitesse actuel est au poin mort ");
		else{System.out.println("La vitesse actuel est " + vitesse_actuel);}
		return(vitesse_actuel);
	}
	
    public static void main(String[] args) {
    	
    	BoiteDeVitesses boite = new BoiteDeVitesses();
    	boite.changerVitesse(6);
    	boite.retrograder();
    	boite.retrograder();
    	boite.retrograder();
    	boite.retrograder();
    	boite.retrograder();
    	boite.retrograder();
    	boite.getVitesse();
    	
    }
}

