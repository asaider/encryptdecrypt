package encryptdecrypt;

import java.util.ArrayList;
import java.util.List;

public class ShiftAlgorithmStrategy implements AlgorithmContract {
    private final static int SIZE_ALFAVIT = 25;
    ArrayList<Character> symbols = new ArrayList<>(List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
    int index, newIndex, indexGivenSymbol;

    @Override
    public void encrypt(Parameters parameters) {
        StringBuilder encryptedMessage = new StringBuilder();
        String data = parameters.getOriginalLine();

        for (int i = 0; i < data.length(); i++) {
            index = symbols.indexOf(data.charAt(i));
            if (index != -1) {
                indexGivenSymbol = symbols.indexOf(data.charAt(i));
                newIndex = indexGivenSymbol + parameters.getKey();

                if (newIndex > SIZE_ALFAVIT) {
                    newIndex = newIndex - SIZE_ALFAVIT - 1;
                }

                encryptedMessage.append(symbols.get(newIndex));
            } else {
                encryptedMessage.append(data.charAt(i));
            }
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

        String data = parameters.getOriginalLine();
        for (int i = 0; i < data.length(); i++) {
            index = symbols.indexOf(data.charAt(i));
            if (index != -1) {
                indexGivenSymbol = symbols.indexOf(data.charAt(i));
                newIndex = indexGivenSymbol - parameters.getKey();
                if (newIndex < 0) {
                    newIndex = SIZE_ALFAVIT + newIndex + 1;
                }
                decryptedMessage.append(symbols.get(newIndex));
            } else {
                decryptedMessage.append(data.charAt(i));
            }
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
