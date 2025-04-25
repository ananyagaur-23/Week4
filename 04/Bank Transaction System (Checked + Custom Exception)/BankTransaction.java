import java.util.IllegalFormatCodePointException;
import java.util.Scanner;
class BankAccount{
    private double balance;
    BankAccount(double balance){
        this.balance = balance;
    }
    public void withdraw(double amount) throws InsufficientBalanceException{
        if(amount<0){
            throw new IllegalArgumentException("Invalid amount!");
        }
        if(amount>balance){
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance = balance - amount;
        System.out.println("Withdraw successful, new balance: "+balance);
    }
}

class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(String message){
        super(message);
    }
}

public class BankTransaction{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount(1000);

        System.out.println("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        try{
            account.withdraw(amount);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        catch (InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }
    }
}
