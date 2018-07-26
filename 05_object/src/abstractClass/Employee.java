package abstractClass;

import java.time.LocalDate;

public class Employee extends Person {
	private double salary;
	private LocalDate hireDay;

	// 构造方法
	public Employee(String name, double salary, int year, int month, int day) {
		super(name);
		this.salary = salary;
		hireDay = LocalDate.of(year, month, day);
	}

	// 获得工资
	public double getSalary() {
		return salary;
	}

	// 获得年月日
	public LocalDate getHireDay() {
		return hireDay;
	}

	// 实现抽象类Person中的 getDescription方法，必须
	public String getDescription() {
		return String.format("an employee with a salary of $%.2f", salary);
	}

	// 百分比增加工资方法
	public void raiseSalary(double byPercent) {
		double raise = byPercent * salary / 100;
		this.salary += raise;
	}
}
