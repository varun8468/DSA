package com.sunbeaminfo.ds;
public class Program {
	private static int number = 1;
	public static void first( ) {
		if( number > 10 )
			return;
		System.out.println("Number	:	"+ number ++);
		Program.next();
	}
	public static void next( ) {
		if( number > 10 )
			return;
		System.out.println("Number	:	"+ number ++);
		Program.first();
	}
	public static void main(String[] args) {
		Program.first();
	}
}
