package q;
import java.util.Scanner;
import java.util.regex.*;

public class LanguageExtractor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the text: ");
		String text = sc.nextLine();
		String regex = "\\b(Java|Python|JavaScript|Go|C|C\\+\\+|Ruby|PHP|Swift|Kotlin|Rust|Perl|TypeScript|R|Scale|Dart)\\b";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		while(matcher.find()) {
			System.out.println(matcher.group());
		}
	}
}
