import java.io.*;
import java.util.*;
public class UncheckedException{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Enter numerator: ");
            int n1 = sc.nextInt();
            System.out.println("Enter Denominator: ");
            int n2 = sc.nextInt();
            int result = n1/n2;
            System.out.println("Result: "+result);
        }
        catch(ArithmeticException e){
            System.out.println("Cannot divide by Zero");
        }
        catch(InputMismatchException e){
            System.out.println("Please enter valid numeric values!");
        }
    }
}
