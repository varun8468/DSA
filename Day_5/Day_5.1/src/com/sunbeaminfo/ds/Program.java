package com.sunbeaminfo.ds;
import java.util.Scanner;
class QueueOverflowException extends Exception{
	private static final long serialVersionUID = -7276941476973339716L;
	public QueueOverflowException(String message) {
		super(message);
	}
}
class QueueUnderflowException extends Exception{
	private static final long serialVersionUID = -5328018940676138421L;
	public QueueUnderflowException(String message) {
		super(message);
	}
}
class Deque{
	private int rear = -1;
	private int front = -1;
	private Integer[] arr;
	public Deque() {
		this( 5 );
	}
	public Deque(int size) {
		this.arr = new Integer[ size ];
	}
	public boolean empty( ) {
		return this.rear == -1;
	}
	public boolean full( ) {
		return ( this.rear + 1 ) % this.arr.length == this.front;
	}
	public void enqueueRear(Integer element ) throws QueueOverflowException {
		if( this.full())
			throw new QueueOverflowException("Queue is full");
		if( this.rear == -1 )
			this.front = 0;
		this.rear = ( this.rear + 1 ) % this.arr.length;
		this.arr[ this.rear ] = element;
	}
	public Integer peekFront( ) throws QueueUnderflowException {
		if( this.empty())
			throw new QueueUnderflowException("Queue is empty.");
		return this.arr[ this.front ];
	}
	public Integer peekRear( ) throws QueueUnderflowException {
		if( this.empty())
			throw new QueueUnderflowException("Queue is empty.");
		return this.arr[ this.rear ];
	}
	public void dequeueFront() throws QueueUnderflowException {
		if( this.empty())
			throw new QueueUnderflowException("Queue is empty.");
		this.arr[ this.front ] = null;
		if( this.rear == this.front ) 
			this.rear = this.front = -1;
		else	
			this.front = ( this.front + 1 ) % this.arr.length;
	}
	public void enqueueFront(Integer element) throws QueueOverflowException {
		if( this.full())
			throw new QueueOverflowException("Queue is full");
		if( this.rear == -1 ) 
			this.rear = this.front = 0;
		else 
			this.front = ( this.front - 1 + this.arr.length ) % this.arr.length;
		this.arr[ this.front ] = element;
	}
	public void dequeueRear( ) throws QueueUnderflowException {
		if( this.empty())
			throw new QueueUnderflowException("Queue is empty.");
		this.arr[ this.rear ] = null;
		if( this.rear == this.front )	
			this.rear = this.front = -1;
		else 
			this.rear = ( this.rear - 1 +  this.arr.length ) % this.arr.length;
	}
}
public class Program {
	public static Scanner sc = new Scanner(System.in);
	public static void acceptRecord( int[] element ) {
		System.out.print("Enter element	:	");
		element[ 0 ] = sc.nextInt();
	}
	public static void printRecord( int[] element ) {
		System.out.println("Removed element is : "+element[ 0 ]);
	}
	public static int menuList( ) {
		System.out.println("0.Exit");
		System.out.println("1.Enqueue(Rear)");
		System.out.println("2.Dequeue(Front)");
		System.out.println("3.Enqueue(Front)");
		System.out.println("4.Dequeue(Rear)");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
	public static void main(String[] args) {
		int choice;
		int[] element = new int[ 1 ];
		Deque que = new Deque();
		while( ( choice = Program.menuList( ) ) != 0 ) {
			try {
				switch( choice ) {
				case 1:
					Program.acceptRecord(element);
					que.enqueueRear( element[ 0 ] );
					break;
				case 2:
					element[ 0 ] = que.peekFront();
					Program.printRecord(element);
					que.dequeueFront( );
					break;
				case 3:
					Program.acceptRecord(element);
					que.enqueueFront( element[ 0 ] );
					break;
				case 4:
					element[ 0 ] = que.peekRear();
					Program.printRecord(element);
					que.dequeueRear();
					break;
				}
			} catch (QueueOverflowException | QueueUnderflowException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
