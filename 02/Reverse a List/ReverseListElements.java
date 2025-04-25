import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseListElements{
    public static <T> void reverseArrayList(List<T> list){
        int left = 0, right = list.size() - 1;
        while (left < right){
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }
    public static <T> void reverseLinkedList(List<T> list){
        int left = 0, right = list.size() - 1;
        while (left < right){
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }
    public static void main(String[] args){
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i=1; i<=5; i++){
            arrayList.add(i);
            linkedList.add(i);
        }

        System.out.println("\n'Original ArrayList: "+ arrayList);
        reverseArrayList(arrayList);
        System.out.println("Reversed ArrayList: "+arrayList);

        System.out.println("\nOriginal LinkedList: "+linkedList);
        reverseLinkedList(linkedList);
        System.out.println("Reversed LinkedList: "+linkedList);
    }
}
