import java.io.*;
import java.util.*;
public class WordCounter{
    public static void main(String[] args){
        File file = new File("input.txt");
        Map<String,Integer> wordCount = new HashMap<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while((line = reader.readLine())!=null){
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z\\s]","").split("\\s+");
                for(String word : words){
                    if(!word.isEmpty()){
                        wordCount.put(word,wordCount.getOrDefault(word,0)+1);
                    }
                }
            }
            wordCount.entrySet().stream()
                    .sorted((a,b)->b.getValue().compareTo(a.getValue()))
                    .limit(5)
                    .forEach(entry-> System.out.println(entry.getKey()+"; "+entry.getValue()));
        }
        catch (IOException e){
            System.out.println("Error reading the file: "+e.getMessage());
        }
    }
}
