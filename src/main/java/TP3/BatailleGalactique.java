package TP3;

import java.io.IOException;

public class BatailleGalactique {

	
    public static void main(String[] args) { 
    	
    	clrscr();
    	System.out.print("Battle");
    	
	
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


