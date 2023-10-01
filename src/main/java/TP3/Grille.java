package TP3;

import TP3.Case.ContentCase;

public class Grille {

	
	private final static int COLONNE= 10;
	private final static int LIGNE = 8;
	
	private String[] _repereHorizontal;
	private char[] _repereVertical;
	
	Case[][] _grille;
	
	Universe _u;
	
	public Grille(){
		
		_repereHorizontal = new String[COLONNE];
		fillRepereHorizontal();
		
		_repereVertical = new char[LIGNE];
		fillRepereVerical();
		
		_grille = new Case[LIGNE][COLONNE];
		
		
		for (int i =0; i< LIGNE; i++) {
			for(int k=0;k<COLONNE;k++) {
				_grille[i][k] = new Case();	
			}
		}
		
		_u = new Universe();
	
	}
	
	
	public int afficherGrille() {
		
		affichePremiereLigne();
	
		for (int i = 0; i<LIGNE; i++) {
				
			afficheRepereVertical(i);
			for (int k = 0; k <COLONNE; k++) {
				

				if (_grille[i][k].getContentCase() ==  ContentCase.VIDE)
					afficheCaseVierge();
				else
					afficheCaseVaisseau();
			}
			
			System.out.println();
		}
		return 0;
	}
	
	public void fillRepereHorizontal(){
		for (int i=0; i< COLONNE; i++) {
			_repereHorizontal[i] = new String( Integer.toString(i+1));
		}
	}
	
	public void fillRepereVerical(){
		for (int i=0; i< LIGNE; i++) {
			_repereVertical[i] = (char) (i+ 65);
		}
	}
	
	public void afficheCaseVierge() {
		
		String greenColor = "\u001B[32m";
		String reset = "\u001B[0m";
		System.out.print( greenColor + "#" + reset); //
	}
	
	public void afficheCaseVaisseau() {
		
		String redColor = "\u001B[31m";
		String reset = "\u001B[0m";
		System.out.print( redColor + "#" + reset); //
	}


	public void affichePremiereLigne() {
		
		String greenColor = "\u001B[32m";
		String reset = "\u001B[0m";
		
		System.out.print(greenColor + " ");
		//String.format("%02d",i);
		for (String i : _repereHorizontal) {
			System.out.print(i);
		}
		
		System.out.println(reset); //
	}
	
	
	public void afficheRepereVertical(int i) {
		
		String greenColor = "\u001B[32m";
		String reset = "\u001B[0m";
		
		System.out.print(greenColor);
		System.out.print(_repereVertical[i]);

		System.out.print(reset); //
	}
	
	
	public int positionnerVaisseau(char idVaisseau, char[]position, char orientation) {
		
		int indexV = indexVertical(position);
		int indexH = indexHorizontal(position);
		
		if(indexV == -1 || indexH == -1)
			return -1;
		
		if (checkOrientation(orientation) != 0)
			return -1;
		
		
	
		switch (idVaisseau) {
		case 'U':
			if(orientation == 'H')
				_u.positionHorizontale();
			else
				_u.positionVerticale();
			
			if( indexV + _u.getLongueurVerticale() > LIGNE )
				return -1;
			
			if( indexH + _u.getLongueurHorizontale() > COLONNE )
				return -1;
			
			for (int i = 0 ; i < _u.getLongueurVerticale(); i++) {
				for (int j =0; j< _u.getLongueurHorizontale(); j++) {
					_grille[indexV+i][indexH+j].setContentCase(ContentCase.VAISSEAU);
				}
			}
					
				
			
			break;
					
		default:
			return -1;
			
			
		}
		
		return 0;
		
	}
	
	
	public int indexHorizontal(char[] position) {

		int c = (int) position[1];
		c = c - 49;
		
		if (c > COLONNE ||  c < 0) 
			return -1;//..err
		else
			return c;	
	}
	
	public int indexVertical(char[] position) {

		int c = (int) position[0];
		c = c - 65;
		
		if (c > LIGNE ||  c < 0) 
			return -1;//..err
		else
			return c;	
	}
	
	public int checkOrientation(char orientation) {
		
		if (orientation != 'H' && orientation != 'V')
			return -1;
		else
			return 0;
		
	}
	


	
	//List de vaisseau
	public Universe getUniverseForTest() {
		return _u;
	}
	
	/*•La configuration du navire en début de partie pourrait se faire via la pattern suivante:
 [<U identifiant en une lettre>, <X1 point haut gauche>, <H ou V orientation>]
•On nettoie la console (hors IDE) avec le code suivant:

	public void afficheCaseAvecCouleur() {
	    // Codes d'échappement ANSI pour la couleur
	    String reset = "\u001B[0m"; // Réinitialisation de la couleur
	    String couleurRouge = "\u001B[31m"; // Rouge

	    // Caractère spécial Unicode représentant la forme
	    char coinHautGauche = '\u259B';

	    // Affichage de la forme en rouge
	    System.out.println(couleurRouge + coinHautGauche + reset);
	}
	*/
	
	
}
