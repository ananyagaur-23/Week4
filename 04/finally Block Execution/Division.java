import java.util.Scanner;
public class Division{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Enter a numerator: ");
            int n1 = sc.nextInt();
            System.out.println("Enter a denominator: ");
            int n2 = sc.nextInt();
            int result = n1/n2;
            System.out.println("Result: "+result);
        }
        catch(ArithmeticException e){
            System.out.println("Error: Cannot divide by zero");
        }
        finally{
            System.out.println("Operation completed");
        }
    }
}
