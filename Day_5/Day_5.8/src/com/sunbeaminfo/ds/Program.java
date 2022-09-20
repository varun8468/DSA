package com.sunbeaminfo.ds;
public class Program {
	private static double pow(double base, int index) {
		if( index == 0 )
			return 1;
		return base * pow( base, index - 1);
	}
	public static void main(String[] args) {
		double result = Program.pow( 5.0, 2 );
		System.out.println("Result	:	"+result);
	}	
}
