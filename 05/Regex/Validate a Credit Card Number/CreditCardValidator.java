package q;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CreditCardValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the credit card number: ");
        String cardNumber = sc.nextLine();
        String cardPattern = "^(4\\d{15}|5\\d{15})$";        
        if (Pattern.matches(cardPattern, cardNumber)) {
            System.out.println("Valid Credit Card Number");
        } else {
            System.out.println("Invalid Credit Card Number");
        }
    }
}
