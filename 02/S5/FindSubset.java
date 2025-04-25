import java.util.*;
public class FindSubset{
    public static void main(String[] args){
        Set<Integer> s1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        boolean isSubset = s2.containsAll(s1);
        System.out.println(isSubset);
    }
}
