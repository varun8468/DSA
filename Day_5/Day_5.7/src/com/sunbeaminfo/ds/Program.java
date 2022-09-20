package com.sunbeaminfo.ds;
public class Program {
	private static double pow(double base, int index) {
		double result = 1;
		for( int count = 1; count <= index; ++ count )
			result = result * base;
		return result;
	}
	public static void main(String[] args) {
		double result = Program.pow( 5.0, 2 );
		System.out.println("Result	:	"+result);
	}

	
}
