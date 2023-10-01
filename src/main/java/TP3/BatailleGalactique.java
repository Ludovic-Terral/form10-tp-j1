package TP3;

import java.io.IOException;

import TP3.Grille;

public class BatailleGalactique {

	
    public static void main(String[] args) { 
    	
    	clrscr();
    	System.out.println("Battle");
    	
    	Grille grille = new Grille();
    	
    	//Universe u = new Universe();
    	
    	grille.afficherGrille();
    	
    	char[] pos = {'C','6'};
    	grille.positionnerVaisseau('U',pos,'H');
    	
    	char[] pos2 = {'A','1'};
    	grille.positionnerVaisseau('U',pos2,'V');
    	
    	grille.afficherGrille();
    	
    	System.out.println(grille.getUniverseForTest().getStatsVaisseu());
    	
	
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
	

    
}


