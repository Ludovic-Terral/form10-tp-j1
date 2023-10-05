package fr.lixtec.form10.j1.tp.tp2;

public class AlgoFrancois {
    private static final int DECALAGE = 23; // Le décalage utilisé pour le chiffrement

    public static void main(String[] args) {
        AlgoFrancois algoFrancois = new AlgoFrancois();

        String resultat = algoFrancois.encrypte("");
        System.out.println("".equals(resultat));

        // Étape 2
        resultat = algoFrancois.encrypte("az");
        System.out.println("Attendu: xw - Obtenu:" + resultat + " - Verifie:" + "xw".equals(resultat));

        // Étape 3
        resultat = algoFrancois.encrypte("AZ");
        System.out.println("Attendu: XW - Obtenu:" + resultat + " - Verifie:" + "XW".equals(resultat));

        // Étape 4
        resultat = algoFrancois.encrypte("1,000.00");
        System.out.println("Attendu: 1,000.00 - Obtenu:" + resultat + " - Verifie:" + "1,000.00".equals(resultat));

        // Étape 5
        String phrase = "In cryptography, this cipher is one "
                + "of the simplest and most widely known "
                + "encryption techniques.";
        resultat = algoFrancois.encrypte(phrase);

        String phraseAttendue = "Fk zovmqldoxmev, qefp zfmebo fp lkb "
                + "lc qeb pfjmibpq xka jlpq tfabiv hkltk "
                + "bkzovmqflk qbzekfnrbp.";
        System.out.println("Obtenu:" + resultat + " - Verifie:" + phraseAttendue.equals(resultat));

        // Étape 6
        resultat = algoFrancois.decrypte("xw");
        System.out.println("Attendu: az - Obtenu:" + resultat + " - Verifie:" + "az".equals(resultat));

        // Étape 7
        resultat = algoFrancois.decrypte("XW");
        System.out.println("Attendu: AZ - Obtenu:" + resultat + " - Verifie:" + "AZ".equals(resultat));

        // Étape 8
        resultat = algoFrancois.decrypte("Gb prfp xr ylrq ab jbp mbfkbp xsbz zbq xidl.");
        System.out.println("Obtenu:" + resultat);
    }

    public String encrypte(String texte) {
        StringBuilder messageChiffre = new StringBuilder();

        for (char c : texte.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                char ch = (char) (((c - base + DECALAGE) % 26) + base);
                messageChiffre.append(ch);
            } else {
                messageChiffre.append(c);
            }
        }

        return messageChiffre.toString();
    }

    public String decrypte(String texte) {
        StringBuilder messageDecode = new StringBuilder();

        for (char c : texte.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                char ch = (char) (((c - base - DECALAGE + 26) % 26) + base);
                messageDecode.append(ch);
            } else {
                messageDecode.append(c);
            }
        }

        return messageDecode.toString();
    }
}
