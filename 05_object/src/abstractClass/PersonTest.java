package abstractClass;

public class PersonTest {
	public static void main(String[] args) {
		Person[] people = new Person[2];
		people[0] = new Employee("jet", 50000, 1990, 7, 1);
		people[1] = new Student("sure", "computer science");
		
		for(Person p : people) {
			System.out.println(p.getName() + ',' + p.getDescription());
		}
	}
}
