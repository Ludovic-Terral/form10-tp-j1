package fr.lixtec.form10.j1.tp.tp2;

/**
 * Cette classe encode et décode selon la méthode de cryptage de Francois.
 * 
 * @author <a definir>
 */
public class AlgoFrancois
{
	
	public final static int DECALAGE = 23;
	
    // ---------- static methods ----------
    public static void main(String[] args)
    {
        AlgoFrancois algoFrancois = new AlgoFrancois();

        String resultat = algoFrancois.encrypte("");
        System.out.println("".equals(resultat));

        // étape 2
        resultat = algoFrancois.encrypte("az");
        System.out.println("Attendu: xw - Obtenu:"+resultat+" - Verifie:"+"xw".equals(resultat));

        // étape 3
        resultat = algoFrancois.encrypte("AZ");
        System.out.println("Attendu: XW - Obtenu:"+resultat+" - Verifie:"+"XW".equals(resultat));

        // étape 4
        resultat = algoFrancois.encrypte("1,000.00");
        System.out.println("Attendu: 1,000.00 - Obtenu:"+resultat+" - Verifie:"+"1,000.00".equals(resultat));

        // étape 5
        String phrase = "In cryptography, this cipher is one "
                        + "of the simplest and most widely known "
                        + "encryption techniques.";
        resultat = algoFrancois.encrypte(phrase);

        String phraseAttendue = "Fk zovmqldoxmev, qefp zfmebo fp lkb "
                                + "lc qeb pfjmibpq xka jlpq tfabiv hkltk "
                                + "bkzovmqflk qbzekfnrbp.";
        System.out.println("Obtenu:"+resultat+" - Verifie:"+phraseAttendue.equals(resultat));
        
        //étape 6
        resultat = algoFrancois.decrypte("xw");
        System.out.println("Attendu: az - Obtenu:"+resultat+" - Verifie:"+"az".equals(resultat));
        
        //étape 7
        resultat = algoFrancois.decrypte("XW");
        System.out.println("Attendu: XW - Obtenu:"+resultat+" - Verifie:"+"AZ".equals(resultat));

        //étape 8
        resultat = algoFrancois.decrypte("Gb prfp xr ylrq ab jbp mbfkbp xsbz zbq xidl.");
        System.out.println("Obtenu:"+resultat);
     
    }

    

    // ---------- instance methods ----------
    public String encrypte(String texte)
    {   	
    	char[]tableau = texte.toCharArray();
    	int nbChar = texte.length();
    	
    	for (int i=0; i<nbChar; i++) {
    		
    		int j = (int)tableau[i];
    		
    		if ( isMajuscule(j) ) {
        		j = j - 65;
        		j = (j +DECALAGE)%26;
        		j = j + 65;
    		}
    		
    		if ( isMinuscule(j) ) {
        		j = j - 97;
        		j = (j +DECALAGE)%26;
        		j = j + 97;
    		}
    		   		
    		tableau[i] = (char)j;
    	}

        return new String(tableau) ;
    }

  
    public boolean isMajuscule(int c) {
    	if( c >= 65 && c<= 90)
    		return true;
    	else
    		return false;
   
    }
    
    public boolean isMinuscule(int c) {
    	if( c >= 97 && c<= 122)
    		return true;
    	else
    		return false;
   
    }
    
    public String decrypte(String texte)
    {
    	  	
    	char[]tableau = texte.toCharArray();
    	int nbChar = texte.length();
    	
    	for (int i=0; i<nbChar; i++) {
    		
    		int j = (int)tableau[i];
    		
    		if ( isMajuscule(j) ) {
        		j = j - 65;
        		j = j + 26;
        		j = (j - DECALAGE)%26;
        		j = j + 65;
    		}
    		
    		if ( isMinuscule(j) ) {
        		j = j - 97;
        		j = j + 26;
        		j = (j - DECALAGE)%26;
        		j = j + 97;
    		}
    		   		
    		tableau[i] = (char)j;
    	}

        return new String(tableau) ;
    }
}