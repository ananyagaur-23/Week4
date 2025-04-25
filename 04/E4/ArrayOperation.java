import java.util.*;
public class ArrayOperation{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = {10,20,30,40,50};
        System.out.println("Enter index to retrieve: ");
        try{
            int index = sc.nextInt();
            System.out.println("Value at index "+index+": "+arr[index]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid index!");
        }
        catch(NullPointerException e){
            System.out.println("Array is not initialized");
        }
        catch(InputMismatchException e){
            System.out.println("Please enter a valid integer index.");
        }
    }
}
