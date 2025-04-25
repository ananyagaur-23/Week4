import java.io.*;
import java.util.*;

public class ImageByteArrayConversion {
    public static void main(String[] args) {
        File originalImage = new File("original.jpg");
        File copiedImage = new File("copied.jpg");

        try (FileInputStream fis = new FileInputStream(originalImage);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            byte[] imageBytes = baos.toByteArray();

            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                 FileOutputStream fos = new FileOutputStream(copiedImage)) {

                while ((bytesRead = bais.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }

            System.out.println("Image copied successfully using byte array.");

            byte[] originalBytes = new FileInputStream(originalImage).readAllBytes();
            byte[] copiedBytes = new FileInputStream(copiedImage).readAllBytes();
            System.out.println("Files are identical: " + Arrays.equals(originalBytes, copiedBytes));

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
