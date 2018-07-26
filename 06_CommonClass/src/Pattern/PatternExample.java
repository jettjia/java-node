package Pattern;

import java.util.regex.Pattern;

public class PatternExample {
	public static void main(String[] args) {
		String input = "Hello Java, Hello world";
		String pattern = ".*wo.*";
		boolean isMatch = Pattern.matches(pattern, input);
		System.out.println(isMatch);
	}
}
