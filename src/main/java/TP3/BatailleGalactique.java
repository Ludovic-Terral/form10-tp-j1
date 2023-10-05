package TP3;

import java.io.IOException;
import java.util.Scanner;

import TP3.Case.Color;

//import TP3.Grille;

public class BatailleGalactique {

	
    public static void main(String[] args) { 
    	 	
        Scanner scanner = new Scanner(System.in);
    	Grille grilleP1 = new Grille();
     	Grille grilleP2 = new Grille();
     	
     	
     	
     	
     	
     	//Joueur1
     	clrscr();
     	System.out.println("Player1"); 		
       	saisiePlayerName(grilleP1,scanner);
     	grilleP1.instructionInitGame(grilleP1.getPlayerName());
     	saisieChampDeBataille(grilleP1,scanner );
    	grilleP1.resetGrille();
    	
     	
     	
     	/*
     	//grilleP1.positionnerVaisseau("U","C6","V"); //U,C6,V
    	//grilleP1.positionnerVaisseau("A","A1","H"); //A,A1,H
    	//grilleP1.positionnerVaisseau("C","F1","H"); //C,F1,H
     	//grilleP1.positionnerVaisseau("N","F5","H"); //N,F5,H
    	grilleP1.positionnerVaisseau("S","G5","V"); //S,G5,V
    	grilleP1.resetGrille();
    	*/
    	

   		
     	//Joueur2 	
    	clrscr();
     	System.out.println("Player2");
    	saisiePlayerName(grilleP2,scanner);
     	grilleP2.instructionInitGame(grilleP2.getPlayerName());
     	saisieChampDeBataille(grilleP2,scanner);
     	grilleP2.resetGrille();
        
     	/*
     	
     	//grilleP2.positionnerVaisseau("U","C6","V"); //U,C6,V
    	//grilleP2.positionnerVaisseau("A","A1","H"); //A,A1,H
    	//grilleP2.positionnerVaisseau("C","F1","H"); //C,F1,H
     	//grilleP2.positionnerVaisseau("N","F5","H"); //N,F5,H
    	grilleP2.positionnerVaisseau("S","A5","V"); //S,G5,V
    	grilleP2.resetGrille();
    	
     	*/
    	
    	boolean game = true;

     	clrscr();
     	while(game) {
     	       		
     		afficherDoubleGrille(grilleP1, grilleP2);
     	    roundTir(grilleP2, scanner, grilleP1.getPlayerName() );
     	    if (grilleP2.calculStatFlotte()==0)
     	    	game = false;
     	      		
     		afficherDoubleGrille(grilleP1, grilleP2);
     	    roundTir(grilleP1, scanner, grilleP2.getPlayerName() );
     	    if (grilleP1.calculStatFlotte()==0)
     	    	game = false;
     	}
     	
     	//Winnner
     	 winner(grilleP1, grilleP2);
    
        scanner.close();
     


    	
    }
    
    public static void clrscr()
	{
	    try
	    {
	        if (System.getProperty("os.name").contains("Windows"))
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        else Runtime.getRuntime().exec("clear");
	    }
	    catch (IOException | InterruptedException ex)
	    {
	        // erreur canard. C'est mal
	    }
	}
    
    public static void saisieChampDeBataille(Grille grille, Scanner scanner) {
        //Scanner scanner = new Scanner(System.in);
		String greenColor = "\u001B[32m";
		String reset = "\u001B[0m";
    	
    	while(grille.listeVaisseauxAPlacer() != 0) {
	        System.out.print(greenColor + ">>");
	        String input = scanner.next();
	       	clrscr();
	        System.out.print(reset + ">>");
	        printErrorRed(input);
	        if (grille.handleInputPostionVaisseau(input) != 0)
	        	 printErrorRed("Saisie non coforme");
	    	System.out.println("<Id>,<Coordonnées>,<H ou V orientation>");
	     	System.out.println("Exemple: U,C6,H");
	        System.out.println();
	        grille.afficherGrille();
    	}
    }
    
    public static void saisieTirChampDeBataille(Grille grille, Scanner scanner) {
		String greenColor = "\u001B[32m";
		String reset = "\u001B[0m";
		
        System.out.print(greenColor + ">>");
        String input = scanner.next();
       	clrscr();
        System.out.print(reset + ">>");
        if (grille.handleInputTir(input) != 0)
        	printErrorRed("Saisie non coforme");
        
    }
    
    public static void saisiePlayerName(Grille p, Scanner scanner) {
        System.out.println("Saisir votre pseudo");
        System.out.print(">>");
        String input = scanner.next();
        p.setPlayerName(input);
    }
    
    
    public static void printErrorRed(String msg) {
		String redColor = "\u001B[31m";
		String reset = "\u001B[0m";
		System.out.println(redColor + msg + reset);
    }
    
    public static void printGreen(String msg) {
    	String greenColor = "\u001B[32m";
		String reset = "\u001B[0m";
		System.out.println(greenColor + msg + reset);
    }
    
    

    public static void roundTir(Grille g, Scanner scanner, String name) {
		//g.afficherGrille();
		g.afficheStatVaisseaux();
		printGreen(name + " => GO");
		g.instructionGame(); 
		
		saisieTirChampDeBataille(g,scanner);
    }
    
    public static void winner(Grille p1, Grille p2) {
		String greenColor = "\u001B[32m";
		String reset = "\u001B[0m";
		String bold = "\u001B[1m";
		String italic = "\u001B[3m";
    	
    	
    	
    	if (p1.calculStatFlotte() == 0)
    		System.out.println(greenColor + bold + italic + p2.getPlayerName() + " win!!" + reset);
    	else
    		System.out.println(greenColor + bold + italic + p1.getPlayerName() + " win!!" + reset);
    		
    }
    
    
    
    
	public static int afficherDoubleGrille(Grille p1, Grille p2) {
		
		String espace = "                         ";
		String espace2 = "                        ";
		String espace3 = "                               ";
		
		Case currentCase = new Case();
		
		System.out.print(" "+ p1.getPlayerName());
		System.out.print(espace3);
		System.out.println(p2.getPlayerName());
		
		p1.affichePremiereLigneSansLn();
		System.out.print(espace2);
		p2.affichePremiereLigne();
		
		for (int i = 0; i<p1.getNbLigne(); i++) {
				
			p1.afficheRepereVertical(i);

			
			
			for (int k = 0; k <p1.getNbColonne(); k++) {
				
				if (p1.getGrille()[i][k].getIsReveal() !=  true)
					currentCase.afficheCaractereCase('#',Color.RESET);
				
				else {
					switch(p1.getGrille()[i][k].getContentCase()){
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
				
			System.out.print(espace);
			p2.afficheRepereVertical(i);
			
			for (int k = 0; k <p2.getNbColonne(); k++) {
				
				if (p2.getGrille()[i][k].getIsReveal() !=  true)
					currentCase.afficheCaractereCase('#',Color.RESET);
				
				else {
					switch(p2.getGrille()[i][k].getContentCase()){
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
}



