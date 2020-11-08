package encryptdecrypt.algorithms;

public class Shift implements Algorithm {

    @Override
    public String crypt(String text, int key) {

        if (key == 0) {
            return text;
        }

        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);

            if (letter < 123 && letter > 96 || letter < 91 && letter >64) {
                for (int j = 0; j < Math.abs(key); j++) {

                    if (key < 0) {
                        letter--;
                    } else {
                        letter++;
                    }

                    if (letter == 123) {
                        letter = 97;
                    } else if (letter == 96) {
                        letter = 122;
                    } else if (letter == 91) {
                        letter = 65;
                    } else if (letter == 64) {
                        letter = 90;
                    }
                }
            }
            encryptedText.append(letter);
        }
        return encryptedText.toString();
    }
}
