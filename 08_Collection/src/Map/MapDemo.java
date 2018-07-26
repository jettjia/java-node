package Map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapDemo {
	/**
	 * Map集合的功能概述
	 * a.添加
	 * 		V put(K key, V value) 添加元素
	 * 			如果键是第一次存储，就直接存储元素，返回null
	 * 			如果键不是第一次存在，就用值把以前的值替换掉，返回以前的值
	 * b.删除
	 * 		void clear()	移除所有的键值对元素
	 * 		V remove(Object key) 根据键删除键值元素，并把值返回
	 * c.判断
	 * 		boolean containsKey(Object key) 判断集合是否包含指定的键
	 * 		boolean containsValue(Object key) 判断集合是否包含指定的值
	 * 		boolean isEmpty() 判断集合是否为空
	 * d.获取
	 * 		V get(Object key) 根据键获取值
	 * 		Set<K> keySet() 获取集合中所有键的集合
	 * 		Collection<V> values() 获取集合中所有值的集合
	 * e.长度
	 * 		size() 返回集合中的键值对的个数
	 */
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("zhangsan", 23);
		map.put("lisi", 24);
		map.put("wangwu", 25);
		
		// 获取value
		Collection<Integer> c = map.values();
		System.out.println(c);
		
		// 删除
		Integer val = map.remove("zhangsan"); // 根据键删除元素,返回键对应的值
		System.out.println(val);
		
		// 判断
		System.out.println(map.containsKey("lisi")); // true, 判断是否包含传入的键
		System.out.println(map.containsValue(50)); // false, 判断是否包含传入的值
		
		// 迭代 Map 没有 iterator
		// 遍历方式1 - 增强for
		for(String key : map.keySet()) {
			System.out.println(key + "=" + map.get(key));
		}
		// 遍历方式2 - Entry
		for(Entry<String, Integer> en : map.entrySet()) {
			System.out.println(en.getKey() + "=" + en.getValue());
		}
		
	}
}
