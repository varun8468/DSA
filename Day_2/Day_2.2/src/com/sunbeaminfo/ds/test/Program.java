package com.sunbeaminfo.ds.test;
import java.util.Iterator;
import java.util.Scanner;
class Node{
	int data;
	Node next;
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
class LinkedList implements Iterable<Integer>, Iterator<Integer>{
	private Node head;
	public boolean empty( ) {
		return this.head == null;
	}
	/* public void addFirst(int data) {
		Node newNode = new Node( data );
		if( this.empty()) {
			this.head = newNode;
		}else {
			newNode.next = this.head;
			this.head = newNode;
		}
	} */
	
	public void addFirst(int data) {
		Node newNode = new Node( data );
		if( !this.empty())
			newNode.next = this.head;
		this.head = newNode;
	}
	public void addLast(int data) {
		Node newNode = new Node( data );
		if( this.empty() )
			this.head = newNode;
		else {
			Node trav  = this.head;
			while( trav.next != null )
				trav = trav.next;
			trav.next  = newNode;
		}
	}
	public int getCount( ) {
		int count = 0;
		Node trav = this.head;
		while( trav != null ) {
			++ count;
			trav = trav.next;
		}
		return count;		
	}
	public void addAtPosition(int data, int position) {
		if( position <= 0 || position > ( this.getCount() + 1 ) )
			throw new InvalidOperationException("Invalid position");
		if( position == 1 )
			this.addFirst(data);
		else if( position == this.getCount() + 1 )
			this.addLast(data);
		else {
			Node trav = this.head;
			for( int count = 1; count < position - 1; ++ count )
				trav = trav.next;
			Node newNode = new Node( data );
			newNode.next = trav.next;
			trav.next = newNode;
		}
	}
	public void removeFirst( ) throws InvalidOperationException{
		if( this.empty())
			throw new InvalidOperationException("LinkedList is empty");
		this.head = this.head.next;
	}
	public void removeLast( ) throws InvalidOperationException{
		if( this.empty())
			throw new InvalidOperationException("LinkedList is empty");
		if( this.head.next == null )
			this.head = null;
		else {
			Node trav  = this.head;
			while( trav.next.next != null )
				trav = trav.next;
			trav.next = null;
		}
	}
	public void removeFromPosition(int position) throws InvalidOperationException{
		if( position <= 0 || position > this.getCount( ) )
			throw new InvalidOperationException("Invalid position.");
		if( position == 1 )
			this.removeFirst();
		else if( position == this.getCount( ) )
			this.removeLast();
		else {
			Node trav = this.head;
			for( int count = 1; count < position - 1; ++ count )
				trav = trav.next;
			Node temp = trav.next;
			trav.next = temp.next;
			temp = null;
		}
	}
	public void clear( ) {
		while( !this.empty() )
			this.removeFirst();
	}
	Node trav;
	@Override
	public Iterator<Integer> iterator() {
		this.trav = this.head;
		return this;
	}
	@Override
	public boolean hasNext() {
		return this.trav != null;
	}
	@Override
	public Integer next() {
		int data = this.trav.data;
		this.trav = this.trav.next;
		return data;
	}
}
public class Program {
	private static Scanner sc = new Scanner(System.in);
	public static void acceptRecord( int[] data ) {
		System.out.print("Enter data	:	");
		data[ 0 ] = sc.nextInt();
	}
	public static void acceptPosition( int[] position ) {
		System.out.print("Enter position	:	");
		position[ 0 ] = sc.nextInt();
	}
	public static void iterateLinkedList( LinkedList list ) {
		for( int element : list )
			System.out.print(element+"	");
		System.out.println();
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
		while( ( choice = Program.menuList( ) ) != 0 ){
			try {
				switch( choice ) {
				case 1:
					Program.acceptRecord( data );
					list.addFirst( data[ 0 ] );
					break;
				case 2:
					Program.acceptRecord(data);
					list.addLast( data[ 0 ] );
					break;
				case 3:
					Program.acceptRecord(data);
					Program.acceptPosition(position);
					list.addAtPosition(data[ 0 ], position[ 0 ]);
					break;
				case 4:
					list.removeFirst();
					break;
				case 5:
					list.removeLast();
					break;	
				case 6:
					Program.acceptPosition(position);
					list.removeFromPosition(position[ 0 ] );
					break;	
				case 7:
					Program.iterateLinkedList(list);
					break;
				}
			} catch (InvalidOperationException e) {
				System.out.println(e.getMessage());
			}
		}
		list.clear();
	}
}