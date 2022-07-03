package encryptdecrypt;

public class UnicodeAlgorithmStrategy implements AlgorithmContract {
    static final Integer highDecimal = 127;

    @Override
    public void encrypt(Parameters parameters) {
        StringBuilder encryptedMessage = new StringBuilder();

        char[] messageArray = parameters.getOriginalLine().toCharArray();
        for (char chars : messageArray) {
            char shiftedChar = (char) (chars + parameters.getKey());
            int i = 127;
            shiftedChar = shiftedChar > highDecimal ? (char) (shiftedChar - i) : shiftedChar;
            encryptedMessage.append(shiftedChar);
        }

        if (parameters.isExistOutputFile()) {
            FileManager.writeOutputFile(
                    parameters.getOutputFile(),
                    encryptedMessage.toString()
            );
            return;
        }
        System.out.println(encryptedMessage);
    }

    @Override
    public void decryption(Parameters parameters) {
        StringBuilder decryptedMessage = new StringBuilder();
        char[] messageArray = parameters.getOriginalLine().toCharArray();
        for (char chars : messageArray) {
            decryptedMessage.append((char) (chars - parameters.getKey()));
        }

        if (parameters.isExistOutputFile()) {
            FileManager.writeOutputFile(
                    parameters.getOutputFile(),
                    decryptedMessage.toString()
            );
            return;
        }

        System.out.println(decryptedMessage);
    }
}
