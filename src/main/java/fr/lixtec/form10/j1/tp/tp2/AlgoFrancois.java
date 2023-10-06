package fr.lixtec.form10.j1.tp.tp2;


public class AlgoFrancois{
	private static final int DECALAGE = 23;

    
    public static void main(String[] args){
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

    
    public String encrypte(String texte) {
        StringBuilder resultat = new StringBuilder(); //chaine de caractère dynamique pour ajouter les prochains caractères
        for (char lettre : texte.toCharArray()) {
            if (Character.isLetter(lettre)) {
            	char base;
            	if (Character.isUpperCase(lettre)) {
            	    base = 'A';
            	} else {
            	    base = 'a';
            	}
            	int lettreCode = (lettre - base + DECALAGE) % 26;
            	char encrypteLettre = (char) (lettreCode + base);
                resultat.append(encrypteLettre);
            } else {
                resultat.append(lettre);
            }
        }

        return resultat.toString();
    }

    
    
    public String decrypte(String texteChiffre) {
        StringBuilder resultat = new StringBuilder();

        for (char lettre : texteChiffre.toCharArray()) {
            if (Character.isLetter(lettre)) {
            	char base;
            	if (Character.isUpperCase(lettre)) {
            	    base = 'A';
            	} else {
            	    base = 'a';
            	}
            	//System.out.println(lettre);
            	//System.out.println(base);
            	int lettreCode = (lettre - base - DECALAGE + 26) % 26;
            	char decrypteLettre = (char) (lettreCode + base);
            	//System.out.println(decrypteLettre);
                resultat.append(decrypteLettre);
            } else {
                resultat.append(lettre);
            }
        }

        return resultat.toString();
    }
    
}