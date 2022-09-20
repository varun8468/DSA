package com.sunbeaminfo.ds;
import java.util.Scanner;

//Explore java.util.PriorityQueue<E> class
//Expore java.util.concurrent.BlockingQueue<E>
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
class PriorityQueue{
	private int rear = -1;
	private int front = -1;
	private Integer[] arr;
	public PriorityQueue() {
		this( 5 );
	}
	public PriorityQueue(int size) {
		this.arr = new Integer[ size ];
	}
	public boolean empty( ) {
		return this.rear == -1;
	}
	public boolean full( ) {
		return ( this.rear + 1 ) % this.arr.length == this.front;
	}
	public void enqueue(Integer element ) throws QueueOverflowException {
		if( this.full())
			throw new QueueOverflowException("Queue is full");
		if( this.rear == -1 ) {
			this.rear = this.front = 0;
			this.arr[ this.rear ] = element;
		}else {
			int index = this.rear;
			while( element > this.arr[ index ] ) {
				//Shift element by one position
				this.arr[ ( index + 1 ) % this.arr.length ] = this.arr[ index ];
				//move index aniticlockwise by one position
				index = ( index - 1 + this.arr.length ) % this.arr.length;
				//if all elements are shifted then come out of loop
				if( ( index + 1 ) % this.arr.length == this.front )
					break;
			}
			//Shift index at insertion place
			index = ( index + 1 ) % this.arr.length;
			this.arr[ index ] = element;
			//adjust rear variable
			this.rear = ( this.rear + 1 ) % this.arr.length;
		}
	}
	public Integer peek( ) throws QueueUnderflowException {
		if( this.empty())
			throw new QueueUnderflowException("Queue is empty.");
		return this.arr[ this.front ];
	}
	public void dequeue() throws QueueUnderflowException {
		if( this.empty())
			throw new QueueUnderflowException("Queue is empty.");
		this.arr[ this.front ] = null;
		if( this.rear == this.front ) 
			this.rear = this.front = -1;
		else	
			this.front = ( this.front + 1 ) % this.arr.length;
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
		System.out.println("1.Enqueue");
		System.out.println("2.Dequeue");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
	public static void main(String[] args) {
		int choice;
		int[] element = new int[ 1 ];
		PriorityQueue que = new PriorityQueue();
		while( ( choice = Program.menuList( ) ) != 0 ) {
			try {
				switch( choice ) {
				case 1:
					Program.acceptRecord(element);
					que.enqueue( element[ 0 ] );
					break;
				case 2:
					element[ 0 ] = que.peek();
					Program.printRecord(element);
					que.dequeue( );
					break;
				}
			} catch (QueueOverflowException | QueueUnderflowException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
