package equals;

import java.time.LocalDate;
import java.util.Objects;

class Employee {
	private String name;
	private double salary;
	private LocalDate hireDay;

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

	// 百分比增加工资方法
	public void raiseSalary(double byPercent) {
		double raise = byPercent * salary / 100;
		salary += raise;
	}

	// Rewrite equals
	public boolean equals(Object otherObject) {
		// 快速检查对象是否相同
		if (this == otherObject)
			return true;

		// 如果显式参数为空，则返回false
		if (otherObject == null)
			return false;

		// 如果类不匹配，它们就不能相等
		if (getClass() != otherObject.getClass())
			return false;

		// now we know otherObject is a non-null Employee
		Employee other = (Employee) otherObject;

		return Objects.equals(name, other.name) 
				&& salary == other.salary 
				&& Objects.equals(hireDay, other.hireDay);
	}

	// 重写 hashCode
	public int hashCode() {
		return Objects.hash(name, salary, hireDay);
	}

	public String toString() {
		return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
	}
}
