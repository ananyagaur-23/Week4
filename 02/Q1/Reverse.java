import java.util.*;
public class Reverse{
    public static Queue<Integer> reverse(Queue<Integer> queue){
        Stack<Integer> stack =  new Stack<>();
        while (!queue.isEmpty()){
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()){
            queue.add(stack.pop());
        }
        return queue;
    }
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println("Original Queue: "+queue);
        Queue<Integer> reversed = reverse(queue);
        System.out.println("Reversed Queue: "+reversed);
    }
}
