import java.util.*;
public class FindingElement{
    public static <T> T findElement(LinkedList<T> list, int n){
        ListIterator<T> fast = list.listIterator();
        ListIterator<T> slow = list.listIterator();
        for(int i=0; i<n; i++){
            if(!fast.hasNext())
                return null;
            fast.next();
        }
        while (fast.hasNext()){
            fast.next();
            slow.next();
        }
        return slow.next();
    }
    public static void main(String[] args){
        LinkedList<String> input = new LinkedList<>(Arrays.asList("A","B","C","D","E"));
        int n = 2;
        String result = findElement(input, n);
        System.out.println(result);
    }
}
