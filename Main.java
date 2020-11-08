package encryptdecrypt;

import encryptdecrypt.cryptor.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String operation = "enc";
        String text = "";
        int key = 0;
        String inFileName = "";
        String outFileName = "";
        String algorithm = "shift";

        try {
            for (int i = 0; i < args.length; i += 2) {
                switch (args[i]) {
                    case "-mode":
                        operation = args[i + 1];
                        break;
                    case "-key":
                        key = Integer.parseInt(args[i + 1]);
                        break;
                    case "-data":
                        text = args[i + 1];
                        break;
                    case "-in":
                        inFileName = args[i + 1];
                        break;
                    case "-out":
                        outFileName = args[i + 1];
                        break;
                    case "-alg":
                        algorithm = args[i + 1];
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Error in command line");
            return;
        }

        Cryptor cryptor;
        try {
            cryptor = CryptorFactory.createCryptor(operation, text, key, inFileName, outFileName, algorithm);
        } catch (Exception e) {
            return;
        }

        try {
            cryptor.action();
        } catch (IOException e) {
            System.out.println("Error! File not found");
        }

    }
}
