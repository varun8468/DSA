package com.sunbeaminfo.ds.test;

import java.util.Arrays;

public class Program {
	public static void swap( int[] arr, int i, int j ) {
		int temp = arr[ i ];
		arr[ i ] = arr[ j ];
		arr[ j ] = temp;
	}
	private static void sort(int[] arr) {
		boolean sorted = false;
		for( int i = 0; i < arr.length - 1 && !sorted; ++ i ) {
			sorted = true;
			for( int j = 0; j < arr.length - 1 - i; ++ j ) {
				if( arr[ j ] > arr[ j + 1 ] ) {
					sorted  = false;
					Program.swap(arr, j, j + 1 );
				}
			}
		}
	}
	private static void printRecord(int[] arr) {
		if( arr != null ) {
			System.out.println(Arrays.toString(arr));
			System.out.println();
		}
	}
	public static void main(String[] args) {
		//int[] arr = new int[ ] { 10, 20, 30, 40, 50 };
		int[] arr = new int[ ] { 23, 29, 15, 19, 31, 7, 9,  5, 2 };
		Program.printRecord( arr );
		Program.sort( arr );
		Program.printRecord( arr );
	}
}
