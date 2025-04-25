import java.util.Scanner;
public class InterestCalculator{
    public static double calculateInterest(double amount, double rate, int years){
        if(amount < 0 || rate < 0){
            throw new IllegalArgumentException("Amount and rate must be positive");
        }
        return amount*rate*years/100;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Enter amount: ");
            double amount = sc.nextDouble();
            System.out.println("Enter rate: ");
            double rate = sc.nextDouble();
            System.out.println("Enter years: ");
            int years = sc.nextInt();
            double interest = calculateInterest(amount,rate,years);
            System.out.println("Interest: "+interest);
        }
        catch(IllegalArgumentException e){
            System.out.println("Invalid input: Amount and rate must be positive");
        }
    }
}
