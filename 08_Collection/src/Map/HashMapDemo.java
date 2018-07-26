package Map;

import java.util.HashMap;

import com.jettjia.Person;

public class HashMapDemo {
	public static void main(String[] args) {
		// 定义男明星
		HashMap<Person, String> hmMan = new HashMap<>();
		hmMan.put(new Person("周杰伦", 35),  "上海");
		hmMan.put(new Person("李宗盛", 55),  "上海");
		
		// 定义女明星
		HashMap<Person, String> hmWoman = new HashMap<>();
		hmWoman.put(new Person("张志玲", 33), "台湾");
		hmWoman.put(new Person("刘涛", 37), "江西");
		
		// 定义双层HashMap
		HashMap<HashMap<Person, String>, String> hm = new HashMap<>();
		hm.put(hmMan, "男明星");
		hm.put(hmWoman, "女明星");
		
		// 遍历双列集合
		for(HashMap<Person, String> h : hm.keySet()) { // hm.keySet()代表的是双列集合中键的集合
			String value = hm.get(h); // 获取值对象
			// 遍历键的双列集合对象
			for (Person key : h.keySet()) { // h.keySet()获取集合总所有的Person键对象
				String value2 = h.get(key);
				System.out.println(key + "=" + value + "=" + value2);
			}
		}
	}
}
