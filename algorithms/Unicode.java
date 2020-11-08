package encryptdecrypt.algorithms;

public class Unicode implements Algorithm {

    @Override
    public String crypt(String text, int key) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            encryptedText.append((char) (text.charAt(i) + key));
        }
        return encryptedText.toString();
    }

}
