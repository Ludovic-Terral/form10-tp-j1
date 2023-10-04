package tp1_exercices;

public class Ascenceur {

	 private int etageActuel;
	
	 
	 public Ascenceur() {
	        this.etageActuel = 0; //rez-de-chaussee
	    }
	 
	 public int getEtage() {
		    return etageActuel;
		}
	 
	 public void appelerDepuis(int etage) {
		    if (etage >= 0) {
		        System.out.println("L'ascenseur se déplace de l'étage " + etageActuel + " à l'étage " + etage);
		        etageActuel = etage;
		    } else {
		        System.out.println("Cet étage n'existe pas");
		    }
		}

	 
	 public static void main(String[] args) {
		    Ascenceur ascenseur = new Ascenceur(); //creation instance

		    System.out.println("L'ascenseur est actuellement à l'étage : " + ascenseur.getEtage());

		    // Test appel ascenceur
		    ascenseur.appelerDepuis(3);
		    System.out.println("L'ascenseur est maintenant à l'étage : " + ascenseur.getEtage());

		    ascenseur.appelerDepuis(1);
		    System.out.println("L'ascenseur est maintenant à l'étage : " + ascenseur.getEtage());

		    ascenseur.appelerDepuis(5);
		    System.out.println("L'ascenseur est maintenant à l'étage : " + ascenseur.getEtage());
		}

}

