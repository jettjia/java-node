
public class IntegerDemo {
	public static void main(String[] args) {
		// int -> string
		Integer age = 23;
		String ageString = String.valueOf(23);
		System.out.println(ageString);
		
		// string -> int
		String a = "33";
		System.out.println(Integer.parseInt(a));
	}
}
