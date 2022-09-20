package com.sunbeaminfo.ds.test;

import java.util.Arrays;

public class Program {
	public static void swap( int[] arr, int i, int j ) {
		int temp = arr[ i ];
		arr[ i ] = arr[ j ];
		arr[ j ] = temp;
	}
	private static void quickSort(int[] arr, int left, int right) {
		if( left < right ) { //It means that there are more than one element is exist for sorting
			int pivot = arr[ left ];
			int i = left, j = right;
			while( i < j ) {
				while( arr[ i ] <= pivot && i < right )
					++ i;
				while( arr[ j ] > pivot && j > 0 )
					-- j ;
				if( i < j )
					swap(arr, i, j);
			}
			swap(arr, left, j);
			quickSort(arr, left, j - 1 );
			quickSort(arr, j + 1, right );
		}	
	}
	private static void printRecord(int[] arr) {
		if( arr != null )
			System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) {
		int[] arr = new int[ ] { 23, 29, 15, 19, 31, 7, 9, 5, 2 };
		Program.printRecord(arr);
		Program.quickSort( arr, 0, arr.length - 1 );
		Program.printRecord(arr);
		
		//Arrays.sort( ); -> primitive -> DualPivotQuickSort Algo
		//Arrays.sort( ); -> non primitive -> Iterative MergeSort Algo
	}
}
