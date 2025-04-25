package q;
import java.util.Scanner;
import java.util.regex.*;
public class UsernameValidator {
	public static boolean isValid(String username) {
		String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
		return Pattern.matches(regex,  username);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a username to validate: ");
		String name = sc.nextLine();
		if(isValid(name)) {
			System.out.println("Valid Username!");
		}
		else {
			System.out.println("Invalid Username!");
		}
	}
}
