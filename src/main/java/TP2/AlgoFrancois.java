package TP2;

public class AlgoFrancois {

    public static String chiffrer(String texte, int decalage) {
        char[] tableau = texte.toCharArray();
        StringBuilder texteChiffre = new StringBuilder();

        for (char c : tableau) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                texteChiffre.append((char) (base + (c - base + decalage) % 26));
            } else {
                texteChiffre.append(c);
            }
        }

        return texteChiffre.toString();
    }

    public static String dechiffrer(String texteChiffre, int decalage) {
        return chiffrer(texteChiffre, 26 - decalage);
    }

    public static void main(String[] args) {
        String texte = "In cryptography, a cipher is one of the simplest and most widely known encryption techniques.";
        int decalage = 23;

        String texteChiffre = chiffrer(texte, decalage);
        System.out.println("Texte chiffré :");
        System.out.println(texteChiffre);

        String texteDechiffre = dechiffrer(texteChiffre, decalage);
        System.out.println("\nTexte déchiffré :");
        System.out.println(texteDechiffre);
    }
}
