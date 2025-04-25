package src;

import java.io.*;

public class FileMerger {
    public static void main(String[] args) {
        String inputFile1 = "file1.txt";
        String inputFile2 = "file2.txt";
        String outputFile = "combined.txt";

        try (
            BufferedReader reader1 = new BufferedReader(new FileReader(inputFile1));
            BufferedReader reader2 = new BufferedReader(new FileReader(inputFile2));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;

            while ((line = reader1.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            while ((line = reader2.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Files merged successfully into " + outputFile);
        } catch (IOException e) {
            System.out.println("Error processing files: " + e.getMessage());
        }
    }
}
