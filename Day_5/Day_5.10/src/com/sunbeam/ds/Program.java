package com.sunbeam.ds;
public class Program {
	public static int binarySearch( int[] arr, int key ){
		int left = 0;
		int right = arr.length - 1;
		while( left <= right ){
		    int mid = ( left + right ) / 2 ;
		    if( key == arr[ mid ])
		        return mid;
		    else if( key > arr[ mid ] )
		        left = mid + 1;
		    else
		        right = mid - 1;
		}
		return -1;
    }
    public static void main( String[] args ){
        int key = 123;
        int[] arr = new int[ ]{ 10, 20, 30, 40, 50, 60, 70 };
        int index = Program.binarySearch( arr, key );
        if( index != -1)
            System.out.println(key+" found at index "+index);
        else
            System.out.println(key+" not found");
    }
}
