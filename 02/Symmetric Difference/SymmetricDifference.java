import java.util.*;
public class SymmetricDifference{
    public static void main(String[] args){
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(3,4,5));

        Set<Integer> difference = new HashSet<>(s1);
        difference.addAll(s2);
        Set<Integer> temp = new HashSet<>(s1);
        temp.retainAll(s2);

        difference.removeAll(temp);
        System.out.println("Symmetric Difference: "+difference);
    }
}
