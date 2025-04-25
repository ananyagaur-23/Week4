import java.io.*;
public class UserToFile{
    public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("userinfo.text");
        try(FileWriter writer = new FileWriter(file)) {
            System.out.println("Enter your name: ");
            String name = reader.readLine();
            System.out.println("Enter your age: ");
            String age = reader.readLine();
            System.out.println("Enter your favorite programming language: ");
            String language = reader.readLine();

            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Preferred Programming Language: " + language + "\n");

            System.out.println("Information saved to userinfo.txt");
        }
        catch(IOException e){
            System.out.println("An error occurred: "+ e.getMessage());

        }
    }
}
