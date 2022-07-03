package encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        AlgorithmContract algorithm;
        Parameters parameters = Parameters.createFromArguments(args);
        algorithm = AlgorithmFactory.createStrategy(parameters.getAlg());

        switch (parameters.getCommand()) {
            case "enc" -> {
                algorithm.encrypt(parameters);
            }
            case "dec" -> {
                algorithm.decryption(parameters);
            }
            default -> System.out.println("error!");
        }
    }
}
