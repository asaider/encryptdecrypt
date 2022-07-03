package encryptdecrypt;

import java.util.Objects;

public class AlgorithmFactory {
    public static AlgorithmContract createStrategy(String type) {
        if (Objects.equals(type, "unicode")) {
            return new UnicodeAlgorithmStrategy();
        }
        return new ShiftAlgorithmStrategy();
    }
}
