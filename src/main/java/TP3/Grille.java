package TP3;

class Grille {

	private final static int ROWS = 9;
	private final static int COLUMNS = 23;
	public Case[][] grille = new Case[ROWS][COLUMNS]; 
	/*
	 * on déclare un tableau de 9 ligne soit de A à H plus 1 pour le coin gauche et 11 columns soit de 1 à 10 
	 * plus 1 pour le coin gauche
	 */
	
	Grille() {
		setgrille();
	}
	
	
	
	public void setgrille() {
		for(int i = 0; i<grille.length;i++) {
			for(int j = 0;j<grille[0].length;j++) {
				grille[i][j] = new Case(i,j);
			}
		}
	}
	
	public Case[][] getGrille() {
		return grille;
	}
	
	public void displayGrille() {
		for(int i = 0; i<grille.length;i++) {
			for(int j = 0;j<grille[0].length;j++) {
				System.out.print(grille[i][j].getContent());
			}
			System.out.println("");
		}
	}
	
	public void fillGrille() {
		
	}
}
