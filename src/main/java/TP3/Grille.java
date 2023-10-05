package TP3;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import TP3.Case.Color;
import TP3.Case.ContentCase;
import TP3.Vaiseau.*;


public class Grille {

	
	private final static int COLONNE= 10;
	private final static int LIGNE = 8;
	
	private String[] _repereHorizontal;
	private char[] _repereVertical;
	
	private Case[][] _grille;
	
	private List<Vaisseau> _listVaisseau;
	
	private Universe _u;
	private Sovereign _s;
	private Ambassadeur _a;
	private Constitution _c;
	private Navette _n;
	
	private String _namePlayer;
	
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
		
		_listVaisseau = new ArrayList<>();
		
		_u = new Universe();
		_listVaisseau.add(_u);
		
		_s = new Sovereign();
		_listVaisseau.add(_s);
		
		_a = new Ambassadeur();
		_listVaisseau.add(_a);
		
		_c = new Constitution();
		_listVaisseau.add(_c);
		
		_n = new Navette();
		_listVaisseau.add(_n);
		
		

		
	}

	
	
	public int getNbLigne() {
		return LIGNE;
	}
	
	public int getNbColonne() {
		return COLONNE;
	}
		
	public String getPlayerName() {
		return _namePlayer;
	}
	public void setPlayerName(String name) {
		_namePlayer = name;
	}
	
	public Case[][] getGrille() {
		return _grille;
	}
		
	public int afficherGrille() {
		
		Case currentCase = new Case();
		
		affichePremiereLigne();
		for (int i = 0; i<LIGNE; i++) {
				
			afficheRepereVertical(i);
			for (int k = 0; k <COLONNE; k++) {
				
				if (_grille[i][k].getIsReveal() !=  true)
					currentCase.afficheCaractereCase('#',Color.RESET);
				else {
					switch(_grille[i][k].getContentCase()){
						case VIDE:
							currentCase.afficheCaractereCase('.',Color.RESET);
						break;
						case VAISSEAU:
							currentCase.afficheCaractereCase('#',Color.ROUGE);
						default:
							break;
					}
				}	
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
	
	public void affichePremiereLigneSansLn() {
		
		String greenColor = "\u001B[32m";
		String reset = "\u001B[0m";
		
		System.out.print(greenColor + " ");
		//String.format("%02d",i);
		for (String i : _repereHorizontal) {
			System.out.print(i);
		}
		
		System.out.print(reset); //
	}
	
	
	public void afficheRepereVertical(int i) {
		
		String greenColor = "\u001B[32m";
		String reset = "\u001B[0m";
		
		System.out.print(greenColor);
		System.out.print(_repereVertical[i]);

		System.out.print(reset); //
	}
	
	
	//Err: -1 	Impossible de positionner le vaisseau
	//Err: 1	Positionnement vaisseau hors limite
	//Err: 2	Orientation non reconnu	
	//Err: 3	Placement du vaisseau impossible: collision avec un autre vaisseau ou vaisseau hors-limite
	//Err: 4	Id vaisseau non reconnu
	//Err: 5	Id vaisseau deja placé
	public int positionnerVaisseau(String idVaisseau, String position, String orientation) {
		
		idVaisseau = idVaisseau.toUpperCase();
		position = position.toUpperCase();
		orientation = orientation.toUpperCase();
		
		if (idVaisseau.length() != 1)
			return 4;
		
		int indexV = indexVertical(position);
		int indexH = indexHorizontal(position);
		 
		if(indexV == -1 || indexH == -1)
			return 1;
		
		if (checkOrientation(orientation.charAt(0)) != 0)
			return 2;
	
		switch (idVaisseau.charAt(0)) {
		case 'U':
			if (_u.getStatusPostion() == true)
				return 5;
			if ( placementVaisseau(orientation, indexV, indexH, _u) !=0)
				return 3;
			break;
			
		case 'S':
			if (_s.getStatusPostion() == true)
				return 5;
			if ( placementVaisseau(orientation, indexV, indexH, _s) !=0)
				return 3;
			break;
					
		case 'A':
			if (_a.getStatusPostion() == true)
				return 5;
			if ( placementVaisseau(orientation, indexV, indexH, _a) !=0)
				return 3;
			break;
			
		case 'C':	
			if (_c.getStatusPostion() == true)
				return 5;
			if ( placementVaisseau(orientation, indexV, indexH, _c) !=0)
				return 3;
			break;
					
		case 'N':	
			if (_n.getStatusPostion() == true)
				return 5;
			if ( placementVaisseau(orientation, indexV, indexH, _n) !=0)
				return 3;
			break;
					
		default:
			return 4;
					
		}	
		return 0;		
	}	
	

	
	
	public int indexHorizontal(String position) {
		
		String s = position.substring(1);
		
	 	if(!s.matches("^[0-9]*$")) {
	        return -1;
	    }
			
		int c = Integer.parseInt(s);
		
		c = c -1;
		
		if (c > COLONNE ||  c < 0) 
			return -1;//..err
		else
			return c;	
	}
	
	public int indexVertical(String position) {
		
		String s = position.substring(0,1);
		char[] tabChar = s.toCharArray();
		int c = (int) tabChar[0];
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
	

	public int placementVaisseau(String orientation, int indexV, int indexH, Vaisseau v) {
		
		if(orientation.charAt(0) == 'H')
			v.positionHorizontale();
		else
			v.positionVerticale();
		
		if( indexV + v.getLongueurVerticale() > LIGNE )
			return -1;
		
		if( indexH + v.getLongueurHorizontale() > COLONNE )
			return -1;
		
		if (checkCollision(v,indexV,indexH) != 0)
			return -1;
		
		for (int i = 0 ; i < v.getLongueurVerticale(); i++) {
			for (int j =0; j< v.getLongueurHorizontale(); j++) {		
				_grille[indexV+i][indexH+j].setContentCase(ContentCase.VAISSEAU);
				_grille[indexV+i][indexH+j].setVaisseau(v);
				//v.setStatusPostion(true);
			}
		}
		
		v.setStatusPostion(true);
		
		return 0;
	}


	
	//List de vaisseau
	public List<Vaisseau> getListVaisseau() {
		return _listVaisseau;
	}
	
    public int handleInputPostionVaisseau(String input) {
    	
    	String[] tabString = input.split(",");
    	if (tabString.length != 3)
    		return -1;
    	
    	switch (positionnerVaisseau(tabString[0],tabString[1],tabString[2])) {
    	case 0:
    		break;
    	case 1:
    		printErrorRed("Positionnement vaisseau hors limite");
    		break;		
    	case 2:
    		printErrorRed("Orientation non reconnu");
    		break;
    	case 3:
    		printErrorRed("Placement du vaisseau impossible: collision avec un autre vaisseau ou vaisseau hors-limite");
    		break;   		
    	case 4:
    		printErrorRed("Id vaisseau non reconnu");
    		break;
    	case 5:
    		printErrorRed("Id vaisseau deja placé");
    		break;
    	case -1:
    		printErrorRed("Impossible de positionner le vaisseau");
    		break;
    	default:
    		return -1;
    	}   	
    	return 0;
    }
    
    public int checkCollision(Vaisseau v, int indexV, int indexH) {
    	for (int i = 0 ; i < v.getLongueurVerticale(); i++) {
			for (int j =0; j< v.getLongueurHorizontale(); j++) {
				if(_grille[indexV+i][indexH+j].getContentCase() != ContentCase.VIDE)
					return -1;				
			}
		}
    	return 0;	
    }
    
    
    
    
    
    public void resetGrille() {
		for (int i =0; i< LIGNE; i++) {
			for(int k=0;k<COLONNE;k++) {
				_grille[i][k].setIsReveal(false);
			}
		}
		
		for (Vaisseau v : _listVaisseau) {
			v.setPv();
		}
		//_u.setStatusPostion(false);
		//_s.setStatusPostion(false);
		//_a.setStatusPostion(false);
		//_c.setStatusPostion(false);
		//_n.setStatusPostion(false);
		
    }
    
    
    public int listeVaisseauxAPlacer() {
    	
    	if (_u.getStatusPostion() != true)
		 	System.out.println("<Id Universe (3x2)>:     U");
		 
     	if (_s.getStatusPostion() != true)
     		System.out.println("<Id Sovereign (2x2)>:    S");
     	if (_a.getStatusPostion() != true)
     		System.out.println("<Id Ambassadeur (3x1)>:  A");
     	if (_c.getStatusPostion() != true)
     		System.out.println("<Id Constitution (3x1)>: C");
     	if (_n.getStatusPostion() != true)
     		System.out.println("<Id Navette (2x1)>:      N");
		
		if(	_u.getStatusPostion() == true 
			 && _s.getStatusPostion() == true
			 && _a.getStatusPostion() == true
			 && _c.getStatusPostion() == true
			 && _n.getStatusPostion() == true) {
			return 0;
		}
		else
			return -1;
    }
    
    
    
    public void afficheStatVaisseaux() {  
    		
    	afficheStatFlotte();
    	
    	for (Vaisseau v : _listVaisseau) {
    		System.out.println(v.getStatsVaisseau());
    	} 
    	
    	System.out.println();
    }
    
    public void afficheStatFlotte() {  
	
    	System.out.println(_namePlayer +": " + "flotte opérationnelle à " + calculStatFlotte() + "%");
    }
    	
   
    public int calculStatFlotte() {  
		
    	int percentFlotte = 0;
    	
    	for (Vaisseau v : _listVaisseau) {
    		percentFlotte += v.getPercentLife();
    	}
    	
    	return percentFlotte = percentFlotte / _listVaisseau.size() ;
    }
       
    public void instructionInitGame(String player) {
    	
		String greenColor = "\u001B[32m";
		String reset = "\u001B[0m";

     	System.out.println(greenColor + player + reset);
     	System.out.println(">>Saisir la position des vaisseaux sur le champ de battaile<<");
     	System.out.println("<Id>,<Coordonnées>,<H ou V orientation>");
     	System.out.println("Exemple: U,C6,H");
      	System.out.println();
    	afficherGrille();
    	//resetGrille();
    }
    public void printNamePlayer(String player) {
		String greenColor = "\u001B[32m";
		String reset = "\u001B[0m";
    	
     	System.out.println(greenColor + player + reset);
    }
    
    public void instructionGame() {

     	System.out.println(">>Saisir les coordonnées du tir sur le champ de battaile<<");
     	System.out.println("<Coordonnées>");
     	System.out.println("Exemple: C6");
    }
    
    
    
    
 public int handleInputTir(String input) {
	 
	 	if(!input.matches("^[a-zA-Z0-9]*$")) {
	        return -1;
	    }
	 
	 	input = input.toUpperCase();
    	
		int indexV = indexVertical(input);
		int indexH = indexHorizontal(input);
		
		if(indexV == -1 || indexH == -1)
			return -1;
    	
		revelerCaseContent(indexV, indexH);
		
    	return 0;
    }
 
 
 	public int revelerCaseContent(int indexV,  int indexH ) {
 		
		String greenColor = "\u001B[32m";
		String redColor = "\u001B[31m";
		String reset = "\u001B[0m";			
 		if( _grille[indexV][indexH].getIsReveal() ==  true) {
 			System.out.println(redColor + "déja tiré ici!!" + reset );
		}
		else {
			if( _grille[indexV][indexH].getContentCase()== ContentCase.VIDE)
				System.out.println(redColor + "Loupé" + reset);
			else {
				System.out.println(greenColor+ "Touché!" + reset);
				_grille[indexV][indexH].getVaisseau().damage();
			}
			_grille[indexV][indexH].setIsReveal(true);			
		}
 		return 0;
	}



    public void printErrorRed(String msg) {
		String redColor = "\u001B[31m";
		String reset = "\u001B[0m";
		System.out.println(redColor + msg + reset);
    }
    
	
}
