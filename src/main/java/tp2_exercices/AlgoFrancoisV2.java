package tp2_exercices;

public class AlgoFrancoisV2 {
    public static void main(String[] args) {
        AlgoFrancoisV2 algoFrancois = new AlgoFrancoisV2();

        String resultat = algoFrancois.encrypte("");
        System.out.println("".equals(resultat));

        // Étape 2
        resultat = algoFrancois.encrypte("az");
        System.out.println("Attendu: xw - Obtenu:" + resultat + " - Verifié:" + "xw".equals(resultat));

        // Étape 3
        resultat = algoFrancois.encrypte("AZ");
        System.out.println("Attendu: XW - Obtenu:" + resultat + " - Verifié:" + "XW".equals(resultat));

        // Étape 4
        resultat = algoFrancois.encrypte("1,000.00");
        System.out.println("Attendu: 1,000.00 - Obtenu:" + resultat + " - Verifié:" + "1,000.00".equals(resultat));

        // Étape 5
        String phrase = "In cryptography, this cipher is one "
                        + "of the simplest and most widely known "
                        + "encryption techniques.";
        resultat = algoFrancois.encrypte(phrase);

        String phraseAttendue = "Fk zovmqldoxmev, qefp zfmebo fp lkb "
                                + "lc qeb pfjmibpq xka jlpq tfabiv hkltk "
                                + "bkzovmqflk qbzekfnrbp.";
        System.out.println("Obtenu:" + resultat + " - Verifié:" + phraseAttendue.equals(resultat));

        // Étape 6
        resultat = algoFrancois.decrypte("xw");
        System.out.println("Attendu: az - Obtenu:" + resultat + " - Verifié:" + "az".equals(resultat));

        // Étape 7
        resultat = algoFrancois.decrypte("XW");
        System.out.println("Attendu: AZ - Obtenu:" + resultat + " - Verifié:" + "AZ".equals(resultat));

        // Étape 8
        resultat = algoFrancois.decrypte("Gb prfp xr ylrq ab jbp mbfkbp xsbz zbq xidl.");
        System.out.println("Obtenu:" + resultat);
    }

    public String encrypte(String texte) {
        char[] tableau = texte.toCharArray();
        for (int i = 0; i < tableau.length; i++) {
            char c = tableau[i];
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                tableau[i] = (char) (base + (c - base + 23) % 26);
            }
        }
        return new String(tableau);
    }

    public String decrypte(String texte) {
        char[] tableau = texte.toCharArray();
        for (int i = 0; i < tableau.length; i++) {
            char c = tableau[i];
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                tableau[i] = (char) (base + (c - base - 23 + 26) % 26);
            }
        }
        return new String(tableau);
    }
}
