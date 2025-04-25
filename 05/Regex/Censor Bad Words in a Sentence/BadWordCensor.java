package a;
import java.util.*;
import java.util.regex.*;

public class BadWordCensor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a text: ");
		String text = sc.nextLine();
		String[] badWords = {"damn","shit","hell"};
		for(String word : badWords) {
			text = text.replaceAll("(?i)\\b"+ word + "\\b", "****");
		}
		System.out.println(text);
	}
}
