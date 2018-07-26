package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

import javax.naming.directory.ModificationItem;

public class RelectionTest {
	public static void main(String[] args) {
		// read class name from command line args or user input
		String name;
		if (args.length > 0) {
			name = args[0];
		} else {
			Scanner in = new Scanner(System.in);
			System.out.println("Enter class name(e.g. java.util.Date):");
			name = in.next();
		}
		try {
			Class cl = Class.forName(name); // 返回描述类名为name的Class对象
			Class supercl = cl.getSuperclass(); // 返回超类的Class对象
			// 返回一个整型数值，用不同的位开关描述public和static这样的修饰符使用情况
			String modifiers = Modifier.toString(cl.getModifiers());
			if (modifiers.length() > 0) System.out.print(modifiers + " ");
			System.out.print("class " + name);
			// 如果超类不为null和Object，输出超类的信息
			if (supercl != null && supercl != Object.class) System.out.print(" extends " + supercl.getName());
			
			System.out.print("\n{\n");
			printConstructors(cl); // 打印构造器数组
			System.out.println();
			printMethods(cl); // 打印方法
			System.out.println();
			printFields(cl); // 打印public域
			System.out.println("}");
		} catch(ClassNotFoundException e) {
			
		}
	}
	
	/**
	 * 打印类中所有的构造器信息
	 * @param cl a lcass
	 */
	public static void printConstructors(Class cl) {
		Constructor[] constructors = cl.getDeclaredConstructors(); // 获得类中所有的构造器
		for (Constructor c : constructors) {
			String name = c.getName();
			System.out.print("  ");
			// 返回一个整型数值，用不同的位开关描述public和static这样的修饰符使用情况
			String modifiers = Modifier.toString(c.getModifiers());
			if (modifiers.length() > 0) System.out.print(modifiers + " ");
			System.out.print(name + "(");
			
			// print parameter types
			Class[] paramTypes = c.getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++) {
				if (j > 0) System.out.print(", ");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	
	/**
	 * 打印类中所有的方法
	 * @param cl a class
	 */
	public static void printMethods(Class cl) {
		Method[] methods = cl.getDeclaredMethods();
		for (Method m : methods) {
			Class retType = m.getReturnType();
			String name = m.getName();
			
			System.out.print("  ");
			// print modifiers, return type and method name
			String modifiers = Modifier.toString(m.getModifiers());
			if (modifiers.length() > 0) System.out.print(modifiers + " ");
			System.out.print(retType.getName() + " " + name + "(");
			// print parameter types
			Class[] paramTypes = m.getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++) {
				if (j > 0) System.out.print(", ");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	
	/**
	 * 打印类中所有的 public域
	 * @param cl a class
	 */
	public static void printFields(Class cl) {
		Field[] fields = cl.getDeclaredFields();
		for (Field f : fields) {
			Class type = f.getType();
			String name = f.getName();
			System.out.print("  ");
			String modifers = Modifier.toString(f.getModifiers());
			if (modifers.length() > 0) System.out.print(modifers + " ");
			System.out.println(type.getName() + " " + name + ";");
		}
	}
}
