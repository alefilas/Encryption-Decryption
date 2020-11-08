package encryptdecrypt.cryptor;

import encryptdecrypt.algorithms.Algorithm;
import encryptdecrypt.algorithms.AlgorithmFactory;

import java.io.*;

public class Cryptor {

    private String text;
    private final int key;
    private final String inFileName;
    private final String outFileName;
    private Algorithm algorithm;

    public Cryptor(String text, int key, String inFileName, String outFileName, String algorithm) throws Exception {
        this.text = text;
        this.key = key;
        this.inFileName = inFileName;
        this.outFileName = outFileName;
        this.algorithm = AlgorithmFactory.createAlgorithm(algorithm);
    }

    public void action() throws IOException {
        if (!inFileName.equals("") && text.length() == 0) {
            readTextFromFile();
        }
        if (outFileName.equals("")){
            System.out.println(algorithm.crypt(text, key));
        } else {
            writeToFile(algorithm.crypt(text, key));
        }
    }

    private void readTextFromFile() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inFileName)));
        while (reader.ready()) {
            text += reader.readLine();
        }
        reader.close();
    }

    private void writeToFile(String text) throws IOException {

        FileWriter writer = new FileWriter(outFileName);
        writer.write(text);
        writer.close();

    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

}
