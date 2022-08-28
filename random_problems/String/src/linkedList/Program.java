package linkedList;

import java.util.Scanner;

public class Program {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter no ");
		int number = sc.nextInt();
		String num = String.valueOf(number);
		StringBuffer sb = new StringBuffer(num);
		sb.reverse();
		num = sb.toString();
		int revnumber = Integer.parseInt(num);
		System.out.println(revnumber);
	}
	
}