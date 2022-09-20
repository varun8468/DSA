package com.sunbeam.ds;
public class Program {
	public static final int SIZE = 7;
	public static int getHashCode( int element ){
	    final int PRIME = 31;
	    int result = 1;
	    result = result * PRIME * PRIME + element;
	    return result;
	}
	public static void main( String[] args ){
    	int x = 19;
    	int hashCode = Program.getHashCode(x);//980
    	int slot = hashCode % SIZE;	//0
    	System.out.println( x+"	"+hashCode+"	"+slot);	//980
    	
    	int y = 19;
    	hashCode = Program.getHashCode(y);//980
    	slot = hashCode % SIZE;	//0
    	System.out.println( y+"	"+hashCode+"	"+slot);	
    }
	public static void main3( String[] args ){
    	int x = 19;
    	int hashCode = Program.getHashCode(x);//980
    	int slot = hashCode % SIZE;	//0
    	System.out.println( x+"	"+hashCode+"	"+slot);	//980
    	
    	int y = 26;
    	hashCode = Program.getHashCode(y);//987
    	slot = hashCode % SIZE;	//0
    	System.out.println( y+"	"+hashCode+"	"+slot);	
    }
	public static void main2(String[] args) {
		for( int count = 1; count <= 30; ++ count ) {
			int data = count;
			int hashCode = Program.getHashCode(data);
			int slot = hashCode % SIZE;
			System.out.println(data+"	"+hashCode+"	"+slot);
		}
	}
    public static void main1( String[] args ){
    	int x = 10;
    	int hashCode = Program.getHashCode(x);//971
    	int slot = hashCode % SIZE;	//5
    	System.out.println( x+"	"+hashCode+"	"+slot);	//980
    	
    	int y = 15;
    	hashCode = Program.getHashCode(y);//976
    	slot = hashCode % SIZE;	//3
    	System.out.println( y+"	"+hashCode+"	"+slot);	
    }
}
