package encryptdecrypt.cryptor;

public class CryptorFactory {

    public static Cryptor createCryptor(String operation, String text, int key, String inFileName,
                                        String outFileName, String algorithm) throws Exception {
        switch (operation) {
            case "enc":
                return new Cryptor(text, key, inFileName, outFileName, algorithm);
            case "dec":
                return new Cryptor(text, -key, inFileName, outFileName, algorithm);
            default:
                System.out.println("Error! Unknown operation");
                throw new RuntimeException();
        }
    }
}
