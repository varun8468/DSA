package com.sunbeaminfo.ds.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Program {
	private static Scanner sc = new Scanner(System.in);
	private static void acceptRecord(int[] arr) {
		if( arr != null ) {
			for( int index = 0; index < arr.length; ++ index ) {
				System.out.print("Enter element	:	");
				arr[ index ] = sc.nextInt(); 
			}
		}
	}
	private static void printRecord(int[] arr) {
		arr = Objects.requireNonNull(arr, "inside printRecord,arr must not be null.");
		for( int index = 0; index < arr.length; ++ index )
			System.out.println( arr[ index ]);
	}
	public static void main(String[] args) {
		int[] arr = new int[ 3 ];
		Program.acceptRecord( arr );
		//arr = null;
		Program.printRecord( arr );
	}
	public static void main2(String[] args) {
		//int[] arr = { 10, 20, 30 };
		//System.out.println(arr[ arr.length ]); //ArrayIndexOutOfBoundsException
		
		String str = "DAC";
		System.out.println( str.charAt(str.length())); //StringIndexOutOfBoundsException
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		System.out.println(list.get(list.size())); //IndexOutOfBoundsException
	}
	public static void main1(String[] args) {
		//int[] arr = new int[ -3 ]; //NegativeArraySizeException
		
		//int[] arr = { 10, 20, 30 };
		//System.out.println(arr[ arr.length ]); //ArrayIndexOutOfBoundsException
		
		Object[] arr = new String[ 2 ];
		arr[ 0 ] = new String("DAC");
		arr[ 1 ] = new StringBuilder("Dac"); //ArrayStoreException
	}
}
