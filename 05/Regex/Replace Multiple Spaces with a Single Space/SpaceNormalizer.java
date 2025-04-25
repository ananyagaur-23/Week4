package q;
import java.util.Scanner;

public class SpaceNormalizer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a text: ");
		String text = sc.nextLine();
		String normalized = text.replaceAll("\\s+", " ");
		System.out.println(normalized);
	}
}
