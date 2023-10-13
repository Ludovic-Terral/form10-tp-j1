package fr.lixtec.form10.j1.tp.tp3;

public class Grille {
	
	// Attributs
	private int NbLigne;
	private int NbColonne;
	private char [][] grille;
	
	//Constructeur
	public Grille(int l, int c) {
		NbLigne = l;
		NbColonne = c;
		grille = new char[NbLigne][NbColonne];
		
		for(int i=0; i<NbLigne; i++){
			for(int j=0; j<NbColonne; j++) {
				
				grille[i][j] = '-';
				
			}
		}
	}

	public void afficher() {
		System.out.println();
		for(int i=0; i<NbLigne; i++){
			for(int j=0; j<NbColonne; j++) {
				
				 System.out.print(" |"+ grille[i][j]);
				
			}
			
			System.out.println(" | ");
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Grille g1 = new Grille(8,10);
		g1.afficher();
		System.out.println();
		Grille g2 = new Grille(8,10);
		g2.afficher();
	}
}
