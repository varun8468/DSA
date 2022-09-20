package com.sunbeaminfo.ds;
public class Program {
	public static int fib( int number ) {
		if( number == 0 || number == 1 )
			return 1;
		return fib( number - 1 ) + fib( number - 2 );
	}
	public static void main(String[] args) {
		for( int count = 0; count < 10; ++ count )
			System.out.print( fib(count)+"	");
	}	
}
