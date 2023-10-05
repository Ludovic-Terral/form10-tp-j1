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
     	grilleP1.instructionInitGame("Player1");
     	saisieChampDeBataille(grilleP1,scanner );
    	grilleP1.resetGrille();
    	
     	
     	/*	
     	grilleP1.positionnerVaisseau("U","C6","V"); //U,C6,V
    	grilleP1.positionnerVaisseau("A","A1","H"); //A,A1,H
    	grilleP1.positionnerVaisseau("C","F1","H"); //C,F1,H
     	grilleP1.positionnerVaisseau("N","F5","H"); //N,F5,H
    	grilleP1.positionnerVaisseau("S","G5","V"); //S,G5,V
*/
   		
     	//Joueur2
     	
     	/*
    	clrscr();
     	grilleP2.instructionInitGame("Player2");
     	saisieChampDeBataille(grilleP2,scanner);
     	grilleP2.resetGrille();
     	*/
        
    	
     	//game
     	Boolean game = true;
     	
     	while(game) {
     	   
     		grilleP1.printNamePlayer("Player");
     		grilleP1.afficherGrille();
     		
     		grilleP1.afficheStatVaisseaux();
     		grilleP1.instructionGame(); 
        	
        	
     		saisieTirChampDeBataille(grilleP1,scanner);
     		
     	}
    
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
    
    public static void printErrorRed(String msg) {
		String redColor = "\u001B[31m";
		String reset = "\u001B[0m";
		System.out.println(redColor + msg + reset);
    }
    


    
}


