package com.sunbeaminfo.ds.test;

import java.util.Arrays;

public class Program {
	public static void swap( int[] arr, int i, int j ) {
		int temp = arr[ i ];
		arr[ i ] = arr[ j ];
		arr[ j ] = temp;
	}
	public static void selectionSort( int[] arr ) {
		for( int i = 0; i < arr.length - 1; ++ i ) {
			for( int j = i + 1; j < arr.length; ++ j ) {
				if( arr[ i ] > arr[ j ] )
					Program.swap(arr, i, j);
			}
		}
	}
	public static int[] mergeSort( int[] arr1, int[] arr2 ) {
		Program.selectionSort(arr1);	//[30, 45, 50, 60, 90]
		Program.selectionSort(arr2);	//[10, 20, 25, 40, 80]
		
		int i = 0, j = 0, k = 0;
		int[] arr = new int[ arr1.length + arr2.length ];
		while( i < arr1.length && j < arr2.length) {
			if( arr1[ i ] < arr2[ j ] )
				arr[ k ++ ] = arr1[ i ++ ];
			else
				arr[ k ++ ] = arr2[ j ++ ];	
		}
		while( i < arr1.length )
			arr[ k ++ ] = arr1[ i ++ ];
		while( j < arr2.length )
			arr[ k ++ ] = arr2[ j ++ ];
		return arr;
	}
	private static void printRecord(int[] arr) {
		if( arr != null )
			System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) {
		int[] arr1 = new int[ ] { 50, 30, 90, 45, 60 };
		int[] arr2 = new int[ ] { 40, 10, 80, 25, 20 };
		int[] arr = Program.mergeSort(arr1, arr2);
		Program.printRecord( arr );
	}
}
