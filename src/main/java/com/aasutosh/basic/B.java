package com.aasutosh.basic;

public class B implements A{

	@Override
	public void hi(String a) {
		System.out.println("hi "+ a+" B KA");
		
	}
	
	// Overloading
	public  void hi(String a, String b) {
		System.out.println("hi "+ a+" "+ b+ " APNA B KA");
		
	}

}
