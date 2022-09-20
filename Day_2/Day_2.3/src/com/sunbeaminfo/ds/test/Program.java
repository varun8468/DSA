package com.sunbeaminfo.ds.test;

class Test{
	public int number;
	private Test( int number ) {
		this.number = number;
	}
	public int getNumber() {
		return number;
	}
	public static Test getInstance( int number ) {
		Test t = new Test( number );
		return t;
	}
}
public class Program {
	public static void main(String[] args) {
		Test t1 = Test.getInstance(10);
		System.out.println(t1.getNumber());
		
		t1 = Test.getInstance(20);
		System.out.println(t1.getNumber());
	}
}