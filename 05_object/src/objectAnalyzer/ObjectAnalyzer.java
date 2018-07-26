package objectAnalyzer;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ObjectAnalyzer {
	private ArrayList<Object> visited = new ArrayList<>();
	
	/**
	 * Converts an object to a string representation that lists all fields
	 * @param obj an object
	 * @return a string with the object's class name and all field names and values
	 */
	public String toString(Object obj) {
		if (obj == null) return "null";
		if(visited.contains(obj)) return "..."; // contains() 当且仅当此字符串包含指定的 char 值序列时，返回 true
		visited.add(obj);
		Class cl = obj.getClass();
		if (cl == String.class) return (String)obj;
		if (cl.isArray()) {
			String r = cl.getComponentType() + "[{"; // getComponentType() 取得一个数组的Class对象
			for (int i = 0; i < Array.getLength(obj); i++) {
				if (i > 0) r += ",";
				Object val = Array.get(obj, i); // get()访问域的值
				if (cl.getComponentType().isPrimitive()) r += val; // isPrimitive()确定指定的Class对象表示一个基本类型
				else r += toString(val);
			}
			return r + "}";
		}
		
		String r = cl.getName();
		// inspect the fields of this class and all superclasses
		do {
			r += "{";
			Field[] fields = cl.getDeclaredFields(); //获得所有的数据域
			AccessibleObject.setAccessible(fields, true); // 将所有的域设置为可以访问
			// get the names and values of all fields
			for (Field f : fields) {
				if (!Modifier.isStatic(f.getModifiers())) {
					if (!r.endsWith("[")) r += ",";
					r += f.getName() + "=";
					try {
						Class t = f.getType();
						Object val = f.get(obj);
						if (t.isPrimitive()) r += val;
						else r += toString(val);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			r += "}";
			cl = cl.getSuperclass();
		}while(cl != null);
		return r;
	}
}
