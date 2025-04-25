package q;
import java.util.Scanner;
import java.util.regex.Pattern;
public class LicensePlateValidator {
	public static boolean isValid(String plate) {
		String regex = "^[A-Z]{2}[0-9]{4}$";
		return Pattern.matches(regex, plate);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a license plate number: ");
		String input = sc.nextLine();
		if(isValid(input)) {
			System.out.println("Valid License plate");
		}
		else {
			System.out.println("Invalid License plate!");
		}
	}
}
