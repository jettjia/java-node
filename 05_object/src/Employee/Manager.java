package Employee;

/**
 * 子类（经理类）
 */
public class Manager extends Employee {
	private double bonus;
	
	// 子类Manager构造方法
	public Manager(String name, double salary, int year, int month, int day) {
		// 调用超类的构造器
		super(name, salary, year, month, day);
		bonus = 0;
	}
	
	// 获得bonus方法
	public double getSalary() {
		// 调用超类的getSalary()方法，获得薪水
		double superSalary = super.getSalary();
		return superSalary + bonus;
	}
	
	// 设置bonus方法
	public void setBonus(double b) {
		bonus = b;
	}
}
