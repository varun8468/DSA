package com.sunbeaminfo.ds.test;

import java.util.Scanner;

class QueueOverflowException extends Exception{
	private static final long serialVersionUID = 5096460955947227208L;
	public QueueOverflowException(String message) {
		super(message);
	}
}
class QueueUnderflowException extends Exception{
	private static final long serialVersionUID = 3435302657571197207L;
	public QueueUnderflowException(String message) {
		super(message);
	}
}
class CircularQueue{
	private int rear = -1;
	private int front = -1;
	private Integer[ ] arr;
	public CircularQueue() {
		this( 5 );
	}
	public CircularQueue(int size) {
		this.arr = new Integer[ size ];
	}
	public boolean empty( ) {
		return this.rear == -1;
	}
	public boolean full( ) {
		return ( ( this.rear + 1 ) % this.arr.length ) == this.front;
	}
	public void enqueue(Integer element ) throws QueueOverflowException {
		if( this.full())
			throw new QueueOverflowException("Circular queue is full.");
		if( this.rear == -1 )
			this.front = 0;
		this.rear = ( this.rear + 1 ) % this.arr.length; 
		this.arr[ this.rear ] = element;
	}
	public Integer peek( ) throws QueueUnderflowException {
		if( this.empty())
			throw new QueueUnderflowException("Circular queue is empty");
		return this.arr[ this.front ];
	}
	public void dequeue( ) throws QueueUnderflowException {
		if( this.empty())
			throw new QueueUnderflowException("Circular queue is empty");
		if( this.rear == this.front ) {
			this.arr[ this.front ] = null;
			this.rear = this.front = -1;
		}else {
			this.arr[ this.front ] = null;
			this.front = ( this.front + 1 ) % this.arr.length;
		}
	}
}
public class Program {
	private static Scanner sc = new Scanner(System.in);
	private static void acceptRecord(int[] element) {
		System.out.print("Enter element	:	");
		element[ 0 ] = sc.nextInt();
	}
	private static void printRecord(int[] element) {
		System.out.println("Removed element is	:	"+element[ 0 ]);
	}
	public static int menuList( ) {
		System.out.println("0.Exit");
		System.out.println("1.Insert element");
		System.out.println("2.Remove element");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
	public static void main(String[] args) {
		int choice;
		int[] element = new int[ 1 ];
		CircularQueue queue = new CircularQueue();
		while( ( choice = Program.menuList( ) ) != 0 ) {
			try {
				switch( choice ) {
				case 1:
					Program.acceptRecord( element );
					queue.enqueue( element[ 0 ] );	//queue.enqueue( Integer.valueOf(element[ 0 ]) );
					break;
				case 2:
					element[ 0 ] = queue.peek();
					Program.printRecord( element );
					queue.dequeue();
					break;
				}
			} catch (QueueOverflowException | QueueUnderflowException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}