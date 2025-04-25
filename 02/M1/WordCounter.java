import java.util.*;
import java.io.*;
public class WordCounter{
    public static void main(String[] args) throws IOException{
        File file = new File("sample.txt");
        Scanner sc = new Scanner(file);
        Map<String, Integer> wordCount = new HashMap<>();
        while(sc.hasNext()){
            String word = sc.next().toLowerCase().replaceAll("[^a-z]","");
            if(!word.isEmpty()){
                wordCount.put(word, wordCount.getOrDefault(word,0)+1);
            }
        }
        for(Map.Entry<String,Integer> entry : wordCount.entrySet()){
            System.out.println(entry.getKey()+" - "+entry.getValue());
        }
    }
}