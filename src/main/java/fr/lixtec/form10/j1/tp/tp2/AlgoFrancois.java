package fr.lixtec.form10.j1.tp.tp2;

/**
 * Cette classe encode et décode selon la méthode de cryptage de Francois.
 * 
 * @author <a definir>
 */
public class AlgoFrancois
{
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
    private static final int DECALAGE = 23; 
    
    public String encrypte(String texte)
    {
    	StringBuilder resultat = new StringBuilder();
    	for (char c : texte.toCharArray()) {
    		if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                char encodedChar = (char) (base + (c - base + DECALAGE) % 26);
                resultat.append(encodedChar);
            } else {
                resultat.append(c); 
            }
       
    	}
    	return resultat.toString();
    }

  
    
    public String decrypte(String texte)
    {
        StringBuilder resultat = new StringBuilder();
        for (char c : texte.toCharArray()) {
           
        	if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                char decodedChar = (char) (base + (c - base - DECALAGE + 26) % 26);
                resultat.append(decodedChar);
            } else {
                resultat.append(c); 
            }
        }
        return resultat.toString();
    }
}