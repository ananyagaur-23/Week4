import java.util.*;
public class MergeMap{
    public static Map<String, Integer> merge(Map<String, Integer> m1, Map<String,Integer> m2){
        Map<String, Integer> result = new HashMap<>(m1);
        for(Map.Entry<String, Integer> entry : m2.entrySet()){
            result.put(entry.getKey(), result.getOrDefault(entry.getKey(), 0)+ entry.getValue());
        }
        return result;
    }
    public static void main(String[] args){
        Map<String, Integer> m1 = new HashMap<>();
        m1.put("A",1);
        m1.put("B",2);
        Map<String, Integer> m2 = new HashMap<>();
        m2.put("B",3);
        m2.put("C",4);
        Map<String, Integer> merged = merge(m1, m2);
        System.out.println(merged);
    }
}
