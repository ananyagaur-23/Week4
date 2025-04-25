package q;
import java.util.*;
import java.util.regex.*;
public class EmailExtractor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter email: ");
		String text = sc.nextLine();
		
		Pattern pattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-z]{2,}");
		Matcher matcher =pattern.matcher(text);
		while(matcher.find()) {
			System.out.println(matcher.group());
		}
	}
}
