package com.backend.testing;

public class A {

	public static A a() {
		System.out.println("execute given a");
		return new A();
	}
	
	public static A b() {
		System.out.println("execute when b");
		return new A();
	}
	
	public static B c() {
		System.out.println("execute then c");
		return new B();
	}
	
	
}
