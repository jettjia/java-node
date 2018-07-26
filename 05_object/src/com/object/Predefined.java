package com.object;

import java.time.LocalDate;

/**
 * 预定义类
 */
public class Predefined {

	public static void main(String[] args) {
		LocalDate date = LocalDate.now(); // 当前时间
		int year = date.getYear(); // 当前年
		int month = date.getMonthValue(); //当前月
		int day = date.getDayOfMonth(); // 当前天
		System.out.println(date);
	}

}
