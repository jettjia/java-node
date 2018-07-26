package Employee;

import java.time.LocalDate;

/**
 * 超类（雇员类）
 */
class Employee {
	private static int nextId =1;
	
	private String name;
	private double salary;
	private LocalDate hireDay;
	private int id;

	// 构造函数
	public Employee(String n, double s, int year, int month, int day) {
		name = n;
		salary = s;
		hireDay = LocalDate.of(year, month, day);
	}
	
	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public LocalDate getHireDay() {
		return hireDay;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId() {
		id = nextId;
		nextId++;
	}
	
	public static int getNextId() {
		return nextId;
	}
	
	// 百分比增加工资方法
	public void raiseSalary(double byPercent) {
		double raise = byPercent * salary / 100;
		salary += raise;
	}
	
	// main方法 用于单元测试
	public static void main(String[] args) {
		Employee e = new Employee("harry", 50000, 1982, 8, 2);
		System.out.println("id="+ e.getId() +",name=" + e.getName() + ",salary=" + e.getSalary() + ",hire=" + e.getHireDay());
	}
}
