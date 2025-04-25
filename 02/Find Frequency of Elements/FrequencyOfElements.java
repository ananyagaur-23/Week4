import java.util.*;
public class FrequencyOfElements{
    public static Map<String, Integer> countFrequency(List<String> items){
        Map<String, Integer> frequencyMap = new HashMap<>();
        for(String item : items){
            frequencyMap.put(item, frequencyMap.getOrDefault(item,0)+1);
        }
        return frequencyMap;
    }
    public static void main(String[] args){
        List<String> input = Arrays.asList("Apple","Banana","Apple","Orange");
        Map<String, Integer> result = countFrequency(input);
        System.out.println(result);
    }
}
