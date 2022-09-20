package com.sunbeaminfo.ds.test;

import java.util.Arrays;

public class Program {
	public static void swap( int[] arr, int i, int j ) {
		int temp = arr[ i ];
		arr[ i ] = arr[ j ];
		arr[ j ] = temp;
	}
	private static void sort(int[] arr) {
		for( int i = 0; i < arr.length - 1; ++ i ) {
			for( int j = i + 1; j < arr.length; ++ j ) {
				if( arr[ i ]  > arr[ j ] )
					Program.swap(arr, i, j);
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
		int[] arr = new int[ ] { 23, 29, 15, 19, 31, 7, 9,  5, 2 };
		Program.printRecord( arr );
		Program.sort( arr );
		Program.printRecord( arr );
	}
}
