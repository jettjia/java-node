package interfaces;

import java.util.Arrays;

public class EmployeeSortTest {
	public static void main(String[] args) {
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("jack", 5000);
		staff[1] = new Employee("tone", 7000);
		staff[2] = new Employee("harry", 3000);
		
		Arrays.sort(staff);
		for (Employee e : staff) {
			System.out.println(e.getName() + ": " + e.getSalary());
		}
	}
}
