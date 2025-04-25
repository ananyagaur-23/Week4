import java.io.*;

public class FileReadAndWrite {
    public static void main(String[] args) {
        File sourceFile = new File("source.txt");
        File destinationFile = new File("destination.txt");

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            System.out.println("File copied successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found.");
        } catch (IOException e) {
            System.out.println("Error reading or writing the file.");
        }
    }
}
