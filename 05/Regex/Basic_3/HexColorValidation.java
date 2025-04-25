package q;
import java.util.Scanner;
import java.util.regex.Pattern;
public class HexColorValidation {
	public static boolean isValid(String color) {
		String regex = "#[0-9a-fA-F]{6}$";
		return Pattern.matches(regex, color);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Hexcode to check: ");
		String input = sc.nextLine();
		if(isValid(input)) {
			System.out.println("Valid");
		}
		else {
			System.out.println("Invalid");
		}
	}
}
