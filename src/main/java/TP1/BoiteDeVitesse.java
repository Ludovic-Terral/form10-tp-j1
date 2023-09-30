package TP1;

public class BoiteDeVitesse {
	
	private int _vitesseCurrent;
	public final static int NB_RAPPORT = 6;

	//Initialise le rapport initial
	public BoiteDeVitesse(int vitesseInit) {
		_vitesseCurrent = vitesseInit;
	}
	
	
	//Pour changer de vitesse
	public int changerVitesse(String cmd) {
		
		if( cmd.equals("UP")) {
	    		avancer();	
	    		
	    }
		else if (cmd.equals("DOWN")) {
		    retrograder();
		}
		else {
			System.out.println("Débraye!! :)");
			return 1;
		}
		System.out.print("Rapport courant: ");
		System.out.println( getVitesse() );
		return 0;
	}
		
	//Pour passer à la vitesse inférieure
	public void retrograder() {
		_vitesseCurrent--;
	}
	//Pour passer à la vitesse sup
	public void avancer() {
		_vitesseCurrent++;
	}

	//Pour donner la vitesse courante (0 représente le point mort)
	public int getVitesse() {
		return _vitesseCurrent;
	}
	
	
	
    public static void main(String[] args) { //0 400m
    	
    	BoiteDeVitesse bv = new BoiteDeVitesse(0);
    	
    	//Acceleration
    	int i = 0;
    	while (bv.getVitesse() < NB_RAPPORT && i == 0) {
    		i = bv.changerVitesse("UP");
    	}
    	//Freinage
    	while (bv.getVitesse() > 0 && i == 0) {
    		i = bv.changerVitesse("DOWN");
    	}
    }	
}

