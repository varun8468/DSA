package com.sunbeaminfo.ds.test;
public class Program {
	public static void main(String[] args) {
		int number = 123456789;
		String strNumber = String.valueOf(number);
		StringBuilder sb = new StringBuilder(strNumber);
		sb.reverse();
		strNumber = sb.toString();
		number =  Integer.parseInt(strNumber);
		System.out.println(number);
	}
}
