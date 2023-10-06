public class AlgoFrancois {
    
    public static String encode(String text, int shift) {
        StringBuilder encodedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char encodedChar = (char) (((c - base + shift) % 26) + base);
                encodedText.append(encodedChar);
            } else {
                encodedText.append(c);
            }
        }
        return encodedText.toString();
    }

    public static String decode(String encodedText, int shift) {
        return encode(encodedText, 26 - shift);
    }

    public static void main(String[] args) {
        String text = "In cryptography, a cipher is one of the simplest and most widely known encryption techniques.";
        int shift = 23;

        String encodedText = encode(text, shift);
        System.out.println("Encoded Text: " + encodedText);

        String decodedText = decode(encodedText, shift);
        System.out.println("Decoded Text: " + decodedText);
    }
}
