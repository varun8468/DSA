package com.sunbeaminfo.ds.test;

import java.util.Scanner;

class StackUnderflowException extends Exception{
	private static final long serialVersionUID = -1272360365840449505L;
	public StackUnderflowException(String message) {
		super(message);
	}	
}
class StackOverflowException extends Exception{
	private static final long serialVersionUID = -1265437481034542167L;
	public StackOverflowException(String message) {
		super(message);
	}	
}
class Stack{
	private int top = -1;
	private Integer[] arr;
	public Stack( ) {
		this( 5 );	//Constructor chaining
	}
	public Stack( int size ) {
		this.arr = new Integer[ size ];
	}
	public boolean empty( ) {
		return this.top == -1;	
	}
	public boolean full( ) {
		return this.top == this.arr.length - 1;	
	}
	public void push( Integer element ) throws StackOverflowException {
		if( this.full())
			throw new StackOverflowException("Stack is full");
		this.top = this.top + 1;
		this.arr[ this.top ] = element;
	}
	public Integer peek( ) throws StackUnderflowException {
		if( this.empty())
			throw new StackUnderflowException("Stack is empty");
		return this.arr[ this.top ];
	}
	public void pop( ) throws StackUnderflowException {
		if( this.empty( ) )
			throw new StackUnderflowException("Stack is empty");
		this.arr[ this.top ] = null;
		this.top = this.top - 1;
	}
}
public class Program {
	private static Scanner sc = new Scanner(System.in);
	public static void acceptRecord( int[] element ) {
		System.out.print("Enter element	:	");
		element[ 0 ] = sc.nextInt();
	}
	public static void printRecord( int[] element ) {
		System.out.println("Popped element is : "+element[ 0 ]);
	}
	public static int menuList( ) {
		System.out.println("0.Exit");
		System.out.println("1.Push");
		System.out.println("2.Pop");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
	public static void main(String[] args) {
		int choice;
		int[] element = new int[ 1 ];
		Stack stk = new Stack(  );
		while( ( choice = Program.menuList( ) ) != 0 ) {
			try {
				switch( choice ) {
				case 1:
					Program.acceptRecord(element);
					stk.push(element[ 0 ] );
					break;
				case 2:
					element[ 0 ] = stk.peek();
					Program.printRecord(element);
					stk.pop();
					break;
				}
			} catch (StackOverflowException | StackUnderflowException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}