package q;
import java.util.*;
import java.util.regex.*;

public class RepeatitionLocator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the sentence: ");
		String text = sc.nextLine();
		String regex = "\\b(\\w+)\\b";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		
		Set<String> seenWords = new HashSet<>();
		Set<String> repeatingWords = new HashSet<>();
		while(matcher.find()) {
			String word = matcher.group().toLowerCase();
			if(!seenWords.add(word)) {
				repeatingWords.add(word);
			}
		}
		System.out.println(String.join(", ", repeatingWords));
	}
}
