import java.io.*;
public class ErrorLogFilter{
    public static void main(String[] args){
        File file = new File("large_log.txt");
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while((line = reader.readLine())!=null){
                if(line.toLowerCase().contains("error")){
                    System.out.println(line);
                }
            }
        }
        catch(IOException e){
            System.out.println("Error reading the file: "+e.getMessage());
        }
    }
}
