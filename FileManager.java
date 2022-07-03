package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {
    public static void writeOutputFile(String outputFile, String data) {
        File file = new File(outputFile);
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(data);
        } catch (IOException e) {
            System.out.printf("An exception occurred %s", e.getMessage());
        }
    }
    public static String readInputFile(String inputFile) {
        File file = new File(inputFile);
        try {
            Scanner scanner = new Scanner(file);
            return scanner.nextLine();
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + inputFile);
            return "";
        }
    }
}
