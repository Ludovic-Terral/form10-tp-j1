package TP3;

import java.io.IOException;
import java.util.Scanner;

//import TP3.Grille;

public class BatailleGalactique {

	
    public static void main(String[] args) { 
    	 	
        Scanner scanner = new Scanner(System.in);
    	Grille grilleP1 = new Grille();
     	Grille grilleP2 = new Grille();

     	//Joueur1
     	clrscr();
    	//grilleP1.afficheStatVaisseaux();
     	grilleP1.instructionGamePlayer("Player1");
     	saisieChampDeBataille(grilleP1,scanner );
     	
    
    		
     	//Joueur2
    	clrscr();
     	grilleP2.instructionGamePlayer("Player2");
     	saisieChampDeBataille(grilleP2,scanner);
        
    	 	
    



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
    
    public static void printErrorRed(String msg) {
		String redColor = "\u001B[31m";
		String reset = "\u001B[0m";
		System.out.println(redColor + msg + reset);
    }
    


    
}


