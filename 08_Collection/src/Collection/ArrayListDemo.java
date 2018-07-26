package Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListDemo {
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("a");
		arrayList.add("b");
		// 增
		arrayList.add("c");
		// 改
		arrayList.set(1, "z");
		// 查
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}
		System.out.println("======================");
		// 删
		Object object = arrayList.remove(0);
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}
		System.out.println("======================");
		
		System.out.println(object); // 获得删除返回的对象
		
		System.out.println("===========Iterator===========");

		// 迭代器遍历 - Iterator
		Iterator<String> it = arrayList.iterator(); // 获取遍历器
		while (it.hasNext()) { // 判断集合中是否有元素
			System.out.println(it.next());
		}
		
		System.out.println("===========ListIterator===========");
		
		// 迭代器遍历 - ListIterator
		ListIterator<String> lit = arrayList.listIterator(); //获取遍历器(List集合特有的)
		while(lit.hasNext()) {
			System.out.println(lit.next());
		}
	}
}
