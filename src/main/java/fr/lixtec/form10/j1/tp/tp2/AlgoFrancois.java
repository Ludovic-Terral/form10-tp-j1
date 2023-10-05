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
    public String encrypte(String texte)
    {
        char[] input = texte.toCharArray();
        char[] result = new char[texte.length()];
        for (int i=0; i<texte.length(); i++) {
            result[i] = encrypte(input[i], 23);
        }
        return new String(result);
    }

    private char encrypte(char c, int step) // step must be positive or function won't work, I have to tell you because there are no unsigned integers... thank you java! you suck!
    {
        if ('a' <= c && c <= 'z') return (char) ((26 + c-'a' + step) % 26 + 'a');
        if ('A' <= c && c <= 'Z') return (char) ((26 + c-'A' + step) % 26 + 'A');
        else return c;
    }

    public String decrypte(String texte)
    {
        char[] input = texte.toCharArray();
        char[] result = new char[texte.length()];
        for (int i=0; i<texte.length(); i++) {
            result[i] = encrypte(input[i], -23);
        }
        return new String(result);
    }
}