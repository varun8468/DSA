package linkedList;

import java.util.Arrays;

public class Program {
	
	public static void main(String[] args) {
		int n = 10;
		char [] arreglo = new char [n];
	    Arrays.fill(arreglo, ' ');
	    int i = 0;
	    for (i = 1; i <= n; i++){
	        arreglo[n-i] = '#';
	        System.out.println(arreglo);
	    }
	}

	
	
}