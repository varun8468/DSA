package com.sunbeaminfo.ds.test;

import java.util.Arrays;

public class Program {
	public static void swap( int[] arr, int i, int j ) {
		int temp = arr[ i ];
		arr[ i ] = arr[ j ];
		arr[ j ] = temp;
	}
	private static void sort(int[] arr) {
		//Use i for forward movement
		for( int i = 1; i < arr.length; ++ i ) {
			int key = arr[ i ];	//15
			//Use j for backward movement
			int j = i - 1; //1
			while( j >= 0 && arr[ j ] > key ) {
				arr[ j + 1 ] = arr[ j ];
				-- j;
			}
			arr[ j + 1 ] = key;
		}
	}
	private static void printRecord(int[] arr) {
		if( arr != null ) {
			System.out.println(Arrays.toString(arr));
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int[] arr = new int[ ] { 23, 29, 15, 19, 31, 7, 9,  5, 2 };
		Program.printRecord( arr );
		Program.sort( arr );
		Program.printRecord( arr );
	}
}
