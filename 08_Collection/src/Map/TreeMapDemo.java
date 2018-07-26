package Map;

import java.util.Comparator;
import java.util.TreeMap;

import com.jettjia.Person;

public class TreeMapDemo {
	public static void main(String[] args) {
//		demo1();
		TreeMap<Person, String> tm = new TreeMap<>(new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				int num = p1.getName().compareTo(p2.getName()); // 按照姓名比较
				return num == 0 ? p1.getAge() - p2.getAge() : num;
			}
		});
		tm.put(new Person("zhangsan", 23), "上海");
		tm.put(new Person("lisi", 24),  "北京");
		tm.put(new Person("wagnwu", 25),  "深圳");
		System.out.println(tm);
	}
	
	public static void demo1() {
		TreeMap<Person, String> tm = new TreeMap<>();
		tm.put(new Person("zhangsan", 23), "上海");
		tm.put(new Person("lisi", 24),  "北京");
		tm.put(new Person("wagnwu", 25),  "深圳");
		System.out.println(tm);
	}
}
