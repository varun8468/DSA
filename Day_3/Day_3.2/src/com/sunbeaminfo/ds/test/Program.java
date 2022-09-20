package com.sunbeaminfo.ds.test;
import java.util.Iterator;
import java.util.Scanner;

class Node{
	Node prev;	//null
	int data;
	Node next;	//null
	public Node( int data ) {
		this.data = data;
	}
}

class InvalidOperationException extends RuntimeException{
	private static final long serialVersionUID = -8724484729031480234L;
	public InvalidOperationException(String message) {
		super(message);
	}
}

class LinkedList{
	private Node head;	//null
	private Node tail;	//null
	public boolean empty() {
		return this.head == null;
	}
	/* public void addFirst(int data) {
		Node newNode = new Node( data );
		if( this.empty()) {
			this.tail = newNode;
			this.head = newNode;
			this.head.prev = this.tail;
			this.tail.next = this.head;
		}else {
			newNode.next = this.head;
			this.head.prev = newNode;
			this.head = newNode;
			this.head.prev = this.tail;
			this.tail.next = this.head;
		}
	} */
	public void addFirst(int data) {
		Node newNode = new Node( data );
		if( this.empty()) 
			this.tail = newNode;	
		else {
			newNode.next = this.head;
			this.head.prev = newNode;
		}
		this.head = newNode;
		this.head.prev = this.tail;
		this.tail.next = this.head;
	} 
	/* public void addLast(int data) {
		Node newNode = new Node( data );
		if( this.empty()) {
			this.head = newNode;
			this.tail = newNode;
			this.head.prev = this.tail;
			this.tail.next = this.head;
		}else {
			this.tail.next = newNode;
			newNode.prev = this.tail;
			this.tail = newNode;
			this.head.prev = this.tail;
			this.tail.next = this.head;
		}
	} */
	
	public void addLast(int data) {
		Node newNode = new Node( data );
		if( this.empty())
			this.head = newNode;
		else {
			this.tail.next = newNode;
			newNode.prev = this.tail;	
		}
		this.tail = newNode;
		this.head.prev = this.tail;
		this.tail.next = this.head;
	} 
	public int getCount( ) {
		int count = 0;
		if( !this.empty()) {
			Node trav = this.head;
			do{
				++ count;
				trav = trav.next;
			}while( trav != this.head );
		}
		return count;		
	}
	public void addAtPosition( int data, int position ) throws InvalidOperationException{
		if( position <= 0 || position > getCount() + 1 )
			throw new InvalidOperationException("Invalid index");
		if( position == 1 )
			this.addFirst(data);
		else if( position == this.getCount( ) + 1 )
			this.addLast(data);
		else {
			Node trav = this.head;
			for( int count = 1; count < position - 1; ++ count )
				trav = trav.next;
			Node newNode = new Node( data );
			newNode.next = trav.next;
			trav.next.prev = newNode;
			trav.next = newNode;
			newNode.prev = trav;
		}
	}
	public void removeFirst() throws InvalidOperationException{
		if( this.empty())
			throw new InvalidOperationException("LinkedList is empty");
		if( this.head == this.tail )
			this.head = this.tail = null;
		else {
			this.head.prev = null;
			this.head = this.head.next;
			this.head.prev.next = null;
			this.head.prev = this.tail;
			this.tail.next = this.head;
		}
	}
	public void removeLast() throws InvalidOperationException{
		if( this.empty())
			throw new InvalidOperationException("LinkedList is empty");
		if( this.head == this.tail )
			this.head = this.tail = null;
		else {
			this.tail.next = null;
			this.tail = this.tail.prev;
			this.tail.next.prev = null;
			this.head.prev = this.tail;
			this.tail.next = this.head;
		}
	}
	public void removeFromPosition( int position ) throws InvalidOperationException {
		if( position <= 0 || position > this.getCount( ) )
			throw new InvalidOperationException("Invalid position.");
		if( position == 1 )
			this.removeFirst();
		else if( position == this.getCount())
			this.removeLast();
		else {
			Node trav = this.head;
			for( int count = 1; count < position - 1; ++ count )
				trav = trav.next;
			Node temp = trav.next;
			trav.next = temp.next;
			temp.next.prev = trav;
			
			temp.prev = null;
			temp.next = null;
			temp = null;
		}
	}
	public void printList( ) throws InvalidOperationException{
		if( this.empty())
			throw new InvalidOperationException("LinkedList is empty");
		Node trav = this.head;
		do{
			System.out.print(trav.data+"	");
			trav = trav.next;
		}while( trav != this.head );
		System.out.println();
	}
	public void clear( ) {
		while( !this.empty())
			this.removeFirst();
	}
}
public class Program {
	private static Scanner sc = new Scanner(System.in);
	private static void acceptRecord(int[] data) {
		System.out.print("Enter data	:	");
		data[ 0 ] = sc.nextInt();
	}
	private static void acceptPosition(int[] position) {
		System.out.print("Enter position	:	");
		position[ 0 ] = sc.nextInt();
	}
	public static int menuList( ) {
		System.out.println("0.Exit");
		System.out.println("1.Add first.");
		System.out.println("2.Add last.");
		System.out.println("3.Add at position.");
		System.out.println("4.Remove first.");
		System.out.println("5.Remove last.");
		System.out.println("6.Remove from position.");
		System.out.println("7.Print List");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
	public static void main(String[] args) {
		int choice;
		int[] data = new int[1];
		int[] position = new int[1];
		LinkedList list = new LinkedList();
		while( ( choice = Program.menuList( ) ) != 0 ) {
			try {
				switch( choice ) {
				case 1:
					Program.acceptRecord( data );
					list.addFirst( data[ 0 ] );
					break;
				case 2:
					Program.acceptRecord( data );
					list.addLast( data[ 0 ] );
					break;
				case 3:
					Program.acceptRecord( data );
					Program.acceptPosition(position);
					list.addAtPosition(data[ 0 ], position[ 0 ] );
					break;
				case 4:
					list.removeFirst( );
					break;
				case 5:
					list.removeLast( );
					break;
				case 6:
					Program.acceptPosition(position);
					list.removeFromPosition(position[ 0 ]);
					break;
				case 7:
					list.printList();
					break;
				}
			} catch (InvalidOperationException e) {
				System.out.println(e.getMessage());
			}
		}
		list.clear();
	}
}