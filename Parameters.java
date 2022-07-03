package encryptdecrypt;

public class Parameters {
    private final String command;
    private final String originalLine;
    private final String inputFile;
    private final String outputFile;
    private final String alg;
    private final Integer key;

    public String getCommand() {
        return command;
    }

    public String getOriginalLine() {
        return originalLine;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public Boolean isExistOutputFile() {
        return !outputFile.isEmpty();
    }

    public String getAlg() {
        return alg;
    }

    public Integer getKey() {
        return key;
    }

    public Parameters(String command, String originalLine, String inputFile, String outputFile, String alg, Integer key) {
        this.command = command;
        this.originalLine = originalLine;
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.alg = alg;
        this.key = key;
    }

    public static Parameters createFromArguments(String[] args) {
        String command = "enc", originalLine = "",
                inputFile = "", outputFile = "",
                alg = "shift";
        int key = 0;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-alg":
                    alg = args[i + 1];
                    continue;
                case "-mode":
                    command = args[i + 1];
                    continue;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    continue;
                case "-data":
                    originalLine = args[i + 1];
                    continue;
                case "-in":
                    inputFile = args[i + 1];
                    continue;
                case "-out":
                    outputFile = args[i + 1];
            }
        }

        if (!inputFile.isEmpty() && originalLine.isEmpty()) {
            originalLine = FileManager.readInputFile(inputFile);
        }

        return new Parameters(
                command,
                originalLine,
                inputFile,
                outputFile,
                alg,
                key
        );
    }
}
