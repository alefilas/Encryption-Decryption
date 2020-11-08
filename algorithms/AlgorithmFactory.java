package encryptdecrypt.algorithms;

public class AlgorithmFactory {

    public static Algorithm createAlgorithm(String algorithm) throws Exception{
        switch (algorithm) {
            case "unicode":
                return new Unicode();
            case "shift":
                return new Shift();
            default:
                System.out.println("Error! Unknown algorithm.");
                throw new RuntimeException();
        }
    }
}
