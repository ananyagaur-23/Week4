import java.util.*;
public class CheckEqual{
    public static boolean areEqual(Set<Integer> s1, Set<Integer> s2){
        return s1.equals(s2);
    }
    public static void main(String[] args){
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(2,3,1));
        boolean result = areEqual(s1,s2);
        System.out.println(result);
    }
}
