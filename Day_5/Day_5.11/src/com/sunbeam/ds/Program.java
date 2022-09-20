package com.sunbeam.ds;
public class Program {
	public static int binarySearch( int[] arr, int left, int right, int key ){
		if( left > right )
			return -1;
		int mid = ( left + right ) / 2;
		if( key == arr[ mid ] )
			return mid;
		else if( key > arr[ mid ] )
			return binarySearch(arr, mid + 1, right, key);
		else
			return binarySearch(arr, left, mid - 1, key);
    }
    public static void main( String[] args ){
        int key = 10;
        int[] arr = new int[ ]{ 10, 20, 30, 40, 50, 60, 70 };
        int index = Program.binarySearch( arr, 0, arr.length - 1, key );
        if( index != -1)
            System.out.println(key+" found at index "+index);
        else
            System.out.println(key+" not found");
    }
}
