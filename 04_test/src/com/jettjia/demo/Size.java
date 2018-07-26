package com.jettjia.demo;

public enum Size {
	SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
	private String abbreviation;

	public static void main(String[] args) {
		String s = Size.SMALL.toString();
		System.out.println(s);
	}

	private Size(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getAbbreviation() {
		return abbreviation;
	}
}
