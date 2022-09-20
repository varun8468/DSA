package com.sunbeaminfo.ds;
public class Program {
	private static int factorial(int number) {
		int result = 1;
		for( int count = 1; count <= number; ++ count )
			result = result * count;
		return result;
	}
	private static int recFactorial(int number) {
		if( number == 0 )	//base condition
			return 1;
		return number * recFactorial(number - 1 );
	}
	public static void main(String[] args) {
		//fact( n ) = n * fact( n -1 );	// n > 0 ; n == 0 then return 1
		int number = 5;
		int result = Program.recFactorial( number );
		System.out.println("Result	:	"+result);

	}
	
	public static void main1(String[] args) {
		int number = 5;
		int result = Program.factorial( number );
		System.out.println("Result	:	"+result);
	}
}
