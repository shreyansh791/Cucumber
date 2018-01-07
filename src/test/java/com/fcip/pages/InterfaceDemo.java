package com.fcip.pages;

public class InterfaceDemo {
	public static void demo() {
		try {
			System.out.println("hello");
			System.exit(0);
		} finally {
			System.out.println("finally");
		}
	}

	public static void main(String[] args) {
		demo();
	}
}
