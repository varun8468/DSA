package com.sunbeaminfo.ds.test;

import java.util.Arrays;

public class Program {
	private static void merge(int[] arr, int left, int mid, int right) {
		int i = left, j = mid + 1, k = 0;
		//Create temp array to keep data into sorted array
		int[] temp = new int[ right - left + 1 ];	
		while( i <= mid && j <= right ) {
			if( arr[ i ] < arr[ j ])
				temp[ k ++ ] = arr[ i ++ ];
			else
				temp[ k ++ ] = arr[ j ++ ];
		}
		while( i <= mid )
			temp[ k ++ ] = arr[ i ++ ];
		while( j <= right )
			temp[ k ++ ] = arr[ j ++ ];
		
		//Write data from sorted temp array into original array 
		for(i = left, k = 0; i <= right;  ++ i, ++ k )
			arr[ i ] = temp[ k ];
	}
	private static void mergeSort(int[] arr, int left, int right) {
		//Use divide and conquer technique
		if( left < right ) {
			//Use recursion until we get single element inside array
			int mid = ( left + right ) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			//Single element is by default sorted.
			// merge/combine sotred array
			merge( arr, left, mid, right );
		}
	}
	private static void printRecord(int[] arr) {
		if( arr != null )
			System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) {
		int[] arr = new int[ ] { 23, 29, 15, 19, 31, 7, 9, 5, 2 };
		Program.printRecord(arr);
		Program.mergeSort( arr, 0, arr.length - 1 );
		Program.printRecord(arr);
	}
	
}
