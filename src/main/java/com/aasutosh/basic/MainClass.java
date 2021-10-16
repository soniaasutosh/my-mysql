package com.aasutosh.basic;

public class MainClass {

	public static void main(String[] args) {
		B a=new B();
		
		
	
		a.hi("Ram","Sham");
		
		//call(new A());
		
		call(new B());
		
		call(new C());
		
		
	}
	
	
	public static void call(A a) {
		a.hi("Ram");
		a.hello("Shaam");
	}

}
