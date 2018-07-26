package Collection;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import com.jettjia.Person;

public class TreeSetDemo {
	public static void main(String[] args) {
		TreeSet<Person> ts = new TreeSet<>();
		ts.add(new Person("李四", 13));
		ts.add(new Person("张三", 23));
		ts.add(new Person("王五", 43));
		ts.add(new Person("赵六", 33));
		
		System.out.println('张' + 0);
		System.out.println('李' + 0);
		System.out.println('王' + 0);
		System.out.println('赵' + 0);
		
		System.out.println(ts);
	}
}
