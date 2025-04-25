import java.io.*;
public class UpperToLowercase{
    public static void main(String[] args){
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");
        try(
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile),"UTF-8"));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile),"UTF-8"));
        ){
            String line;
            while((line = reader.readLine())!=null){
                writer.write(line.toLowerCase());
                writer.newLine();
            }
            System.out.println("File converted to lowercase successfully.");
        }
        catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
