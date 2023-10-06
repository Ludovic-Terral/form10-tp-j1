package tp2;

public class AlgoFrançois {
    private static final int DECALAGE = 23;

    // Méthode pour chiffrer un message
    public static String chiffrer(String message) {
        StringBuilder messageChiffre = new StringBuilder();

        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                char chiffré = (char) (((c - base + DECALAGE) % 26) + base);
                messageChiffre.append(chiffré);
            } else {
                messageChiffre.append(c);
            }
        }

        return messageChiffre.toString();
    }

    // Méthode pour déchiffrer un message chiffré
    public static String dechiffrer(String messageChiffre) {
        StringBuilder messageDechiffre = new StringBuilder();

        for (char c : messageChiffre.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                char dechiffré = (char) (((c - base - DECALAGE + 26) % 26) + base);
                messageDechiffre.append(dechiffré);
            } else {
                messageDechiffre.append(c);
            }
        }

        return messageDechiffre.toString();
    }

    public static void main(String[] args) {
        String message = "In cryptography, a cipher is one of the simplest and most widely known encryption techniques.";
        
        // Chiffrement
        String messageChiffre = chiffrer(message);
        System.out.println("Message chiffré :");
        System.out.println(messageChiffre);
        
        // Déchiffrement
        String messageDechiffre = dechiffrer(messageChiffre);
        System.out.println("\nMessage déchiffré :");
        System.out.println(messageDechiffre);
    }
}
