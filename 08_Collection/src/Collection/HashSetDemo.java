package Collection;
import java.util.HashSet;

import com.jettjia.Person;

public class HashSetDemo {
	public static void main(String[] args) {
		System.out.println("============ demo1 ============");
		HashSet<Person> hs = new HashSet<>();
		hs.add(new Person("张三", 23));
		hs.add(new Person("张三", 23));
		hs.add(new Person("李四", 24));
		hs.add(new Person("李四", 24));
		hs.add(new Person("李四", 24));
		System.out.println(hs.size());
		System.out.println(hs.toString());
		
		System.out.println("============ demo2 ============");
		HashSet<String> hStrings = new HashSet<>();
		boolean b1 = hStrings.add("a");
		boolean b2 = hStrings.add("a");
		System.out.println(b1); // true
		System.out.println(b2); // false 向set集合中存储重复的元素，报错
		
		hStrings.add("b");
		hStrings.add("c");
		System.out.println(hStrings); // [a, b, c]; HashSet的继承体系中有重写toString方法
		
		//只要能用迭代器迭代的,就可以使用增强for循环遍历
		for(String s : hStrings) {
			System.out.println(s);
		}
	}
}
