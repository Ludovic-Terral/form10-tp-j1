package TP2;

public class AlgoFrancois {
    private static final int DECALAGE = 23; 

    public static String encoder(String texte) {

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

    public static String decoder(String texte) {
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

    public static void main(String[] args) {
        String texteOriginal = "In cryptography, a cipher is one of the simplest and most widely known encryption techniques.";
        String texteEncode = encoder(texteOriginal);
        String texteDecode = decoder(texteEncode);

        System.out.println("Texte de base : " + texteOriginal);
        System.out.println("Texte encodé   : " + texteEncode);
        System.out.println("Texte décodé   : " + texteDecode);
    }
}
