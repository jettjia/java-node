package com.object;

import java.time.LocalDate;

public class MyClass {
	public static int value = 33;
	
	public static void main(String[] args) {
		new MyClass().printValue();
	}
	
	public void printValue() {
		int value = 3;
		System.out.println(this.value);
	}
}
