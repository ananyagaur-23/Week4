package problem;
import java.util.*;

public class DivisionApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter numerator: ");
		int numerator = sc.nextInt();
		System.out.println("Enter denominator: ");
		int denominator = sc.nextInt();
		try {
			calculate(numerator,denominator);
		}
		catch(ArithmeticException e) {
			System.out.println("Error Occurred: "+e.getMessage());
		}
	}
	
	public static void calculate(int numerator, int denominator) {
		try {
			performDivision(numerator,denominator);
		}
		catch(ArithmeticException e) {
			throw new ArithmeticException("Division failed in calculate(): "+e.getMessage());
		}
	}
	public static void performDivision(int numerator, int denominator) {
		if (denominator == 0) {
			throw new ArithmeticException("Cannot divide by zero");
		}
		int result = numerator/denominator;
		System.out.println("Result: "+result);
	}
}
