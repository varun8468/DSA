package com.sunbeaminfo.ds.test;
public class Program {
	public static final int	SIZE = 11; 
	public static int getHashCode( int data ) {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + data;
		return result;
	}
	public static void main(String[] args) {
		for( int count = 1; count <= 300; ++ count ) {
			int data = count;
			int hashCode = Program.getHashCode(data);
			int slot = hashCode % SIZE;
			System.out.println(data+"	"+hashCode+"	"+slot);
		}
	}
}