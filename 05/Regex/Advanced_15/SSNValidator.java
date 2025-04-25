package q;
import java.util.*;
import java.util.regex.*;

public class SSNValidator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the SSN: ");
		String ssn = sc.nextLine();
		String ssnPattern = "^(?!000|666|9\\d{2})\\d{3}-(?!00)\\d{2}-(?!0000)\\d{4}$";
		if(Pattern.matches(ssnPattern, ssn)) {
			System.out.println("Valid");
		}
		else {
			System.out.println("Invalid");
		}
	}
}
