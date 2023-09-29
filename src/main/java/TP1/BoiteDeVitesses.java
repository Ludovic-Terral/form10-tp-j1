package TP1;

public class BoiteDeVitesses {
	 private int vCourante;

	 public BoiteDeVitesses() {
	         this.vCourante = 0; 
	     }

	 public void changerVitesse() {
	         if (vCourante < 5) {
	             vCourante++;
	         }
	     }

	                 
	 public void retrograder() {
	         if (vCourante > 0) {
	        	 vCourante--;
	         }
	 }
	         
	 public int getVitesse() {
	         return vCourante;
	     }
	 

	 public static void main(String[] args) {
	         BoiteDeVitesses boite = new BoiteDeVitesses();

	         System.out.println("Démarrage : vitesse courante = " + boite.getVitesse());

	         for (int i = 1; i <= 5; i++) {
	             boite.changerVitesse();
	             System.out.println("Changement de vitesse : vitesse courante = " + boite.getVitesse());
	         }

	         while (boite.getVitesse() > 0) {
	             boite.retrograder();
	             System.out.println("Changement de vitesse (rétrograder) : vitesse courante = " + boite.getVitesse());
	         }
	     }

}
