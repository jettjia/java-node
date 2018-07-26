package com.jettjia;

public class Person implements Comparable<Person> {
	private String name;
	private int age;
	
	public Person() {
		super();
	}
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true; // 调用的对象和传入的对象是同一个对象，返回 true
		if (obj == null) return false; // 传入的对象为null， 返回 false
		if(getClass() != obj.getClass()) return false; // 判断两个对象的字节码是否相同，不同返回false
		Person other = (Person) obj; //向下转型
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (name.equals(other.name))
			return false;
		return true;
	}
	
	public int compareTo(Person o) {
		int length = this.name.length() - o.name.length(); //比较字段长度为主要条件
		int num = length == 0 ? this.name.compareTo(o.name) : length; //比较内容为次要条件
		return num == 0 ? this.age - o.age : num;
	}
}
