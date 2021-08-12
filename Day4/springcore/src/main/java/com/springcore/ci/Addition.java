package com.springcore.ci;

public class Addition {
	private int a,b;
	
	public Addition(int a, int b) {
		this.a= a;
		this.b= b;
		System.out.println("Constructor: int, int");
	}
	public Addition(double a, double b) {
		this.a= (int)a;
		this.b= (int)b;
		System.out.println("Constructor: double, double");
	}
	public Addition(String a, String b) {
		this.a= Integer.parseInt(a);
		this.b= Integer.parseInt(b);
		System.out.println("Constructor: String, String");
	}
	public void dosum() {
		System.out.println("a is  "+(this.a));
		System.out.println("b is  "+(this.b));
		System.out.println("sum is  "+(this.a+this.b));
	}
}
