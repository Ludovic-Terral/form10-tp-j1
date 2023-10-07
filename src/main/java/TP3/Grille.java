package TP3;

import fr.lixtec.form10.j1.tp.tp2.TP1.Ascenseur;

public class Grille {
	private int lignes = 0;
	private int colonnes = 0;
	private int[][] grille;
	
	public Grille(int lignes, int colonnes){
		this.lignes = lignes;
		this.colonnes = colonnes;
		grille = new int[lignes][colonnes];
	}
	
	public void afficherGrille(){
		char[] lettresLignes = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
		System.out.println("  1 2 3 4 5 6 7 8 9 10");
		
		for(int i=0; i<colonnes; i++) {
			for(int j=0; j<lignes+1; j++) {
				if(j == 0) {
					System.out.print(lettresLignes[i]+" ");
				}
				else {
					System.out.print(". ");
				}
			}
			System.out.println("");
		}
	}
	
	//public static void main(String[] args) {
	//	Grille grille = new Grille(10, 8);
	//	grille.afficherGrille();
	//}
}
