package q;
import java.util.Scanner;
import java.util.regex.Pattern;

public class IPAddressValidator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the IP Address: ");
		String ipAddress = sc.nextLine();
		String ipPattern = 
				"^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
				"(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
				"(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
				"(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$" ;
		
		if(Pattern.matches(ipPattern, ipAddress)) {
			System.out.println("Valid IP Address");
		}
		else {
			System.out.println("Invalid IP Address");
		}
	}
}
