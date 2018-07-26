package Employee;

/**
 * Manager 测试类
 */
public class ManagerTest {
	public static void main(String[] args) {
		// 构造 Manager类对象
		Manager boss = new Manager("wangwu", 50000, 1970, 7, 1);
		boss.setBonus(5000);
		
		Employee[] staff = new Employee[3];
		staff[0] = boss;
		staff[1] = new Employee("lisi", 400000, 1980, 8, 1);
		staff[2] = new Employee("zhangsan", 30000, 1988, 8, 8);
		
		for(Employee e : staff) {
			System.out.println(e.getName() + "," + e.getSalary());
		}
	}
}
