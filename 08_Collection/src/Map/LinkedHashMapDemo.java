package Map;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo {
	public static void main(String[] args) {
		LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
		lhm.put("zhangsan", 23);
		lhm.put("lisi", 24);
		lhm.put("wangwu", 25);
		System.out.println(lhm);
	}
}
