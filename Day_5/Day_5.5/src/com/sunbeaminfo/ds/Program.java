package com.sunbeaminfo.ds;
public class Program {
	private static int number = 1;
	public static void print( ) {
		if( number > 10 )
			return;
		System.out.println("Number	:	"+ number ++ );
		Program.print();//Direct recursion
	}
	public static void main(String[] args) {
		Program.print();
	}
}
