import java.util.*;
public class RemoveDuplicate{
    public static List<Integer> removeDuplicate(List<Integer> list){
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for(Integer item : list){
            if(seen.add(item)){
                result.add(item);
            }
        }
        return result;
    }
    public static void main(String[] args){
        List<Integer> input = Arrays.asList(3,1,2,2,3,4);
        List<Integer> output = removeDuplicate(input);
        System.out.println(output);
    }
}
