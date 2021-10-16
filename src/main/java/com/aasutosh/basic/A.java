package com.aasutosh.basic;

public interface A {

	default void hello(String a) {
		System.out.println("Hello "+a);
	}
	
	void hi(String a);

	
	
	
}
