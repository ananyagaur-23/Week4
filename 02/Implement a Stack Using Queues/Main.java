public class Main {
    public static void main(String[] args){
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top element: " + stack.top()); // 3
        System.out.println("Popped element: " + stack.pop()); // 3
        System.out.println("Top element after pop: " + stack.top()); // 2
    }
}