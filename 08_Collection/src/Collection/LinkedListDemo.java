package Collection;
import java.util.LinkedList;
public class LinkedListDemo {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addFirst("a"); // 元素插入此列表的开头
		list.addFirst("b");
		list.addFirst("c");
		list.addLast("d");
		// 获得
		System.out.println(list.get(1));
		
		// 删除
		System.out.println(list.removeFirst());
	}
}
