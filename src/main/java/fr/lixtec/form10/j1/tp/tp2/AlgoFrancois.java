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

    // Décalage pour l'encodage et le décodage
    private static final int SHIFT = 23;

    // Méthode pour effectuer le décalage d'une lettre selon l'algorithme de François
    private static char shiftLetter(char letter, int shift) {
        char base = Character.isUpperCase(letter) ? 'A' : 'a'; // ? ... : ... c'est un if else pour choisir la base
        return (char) ((letter - base + shift) % 26 + base); // On vient définir la "valeur" du calcul dans (char)
    }
    
    // Méthode pour appliquer le décalage à chaque lettre dans une chaîne de caractères
    private static String applyShift(String message, int shift) {
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                chars[i] = shiftLetter(chars[i], shift);
            }
        }
        return new String(chars);
    }
    
    // Méthode pour encoder une chaîne de caractères
    public static String encrypte(String message) {
        return applyShift(message, SHIFT);
    }

    // Méthode pour décoder une chaîne de caractères
    public static String decrypte(String message) {
        // Utilise un décalage de -23 pour décoder (équivalent à un décalage de +3)
        return applyShift(message, 3);
    }
}