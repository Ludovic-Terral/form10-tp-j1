package TP1;

public class Ascenseur {
	
	 private int etActuel;
   
	 public Ascenseur() {
	         this.etActuel = 0; 
	     }

	 public int getEtage() {
	         return etActuel;
	     }
       
	 public void appelerDepuis(int etage) {
	         if (etage < 0) {
	             System.out.println("�tage non valide !");
	         } 
	        
	 else if (etage < etActuel) {
	             descendre(etage);
	         } 
	            
	 else if (etage > etActuel) {
	             monter(etage);
	         } 
	            
	 else {
	             System.out.println("L'ascenseur est d�j� au bon �tage " + etActuel);
	         }
	     }
	    
	 private void monter(int newEtage) {
	         System.out.println("L'ascenseur monte du " + etActuel + " � l'�tage " + newEtage);
	         etActuel = newEtage;
	     }


	 private void descendre(int newEtage) {
	         System.out.println("L'ascenseur descend du " + etActuel + " � l'�tage " + newEtage);
	         etActuel = newEtage;
	     }

	 public static void main(String[] args) {
	         
		 Ascenseur ascenseur = new Ascenseur();

	         ascenseur.appelerDepuis(4);
	         System.out.println("L'ascenseur se trouve � l'�tage " + ascenseur.getEtage());

	         ascenseur.appelerDepuis(0);
	         System.out.println("L'ascenseur se trouve � l'�tage " + ascenseur.getEtage());
	         
	         ascenseur.appelerDepuis(2);
	         System.out.println("L'ascenseur se trouve � l'�tage " + ascenseur.getEtage());
	     }

}
