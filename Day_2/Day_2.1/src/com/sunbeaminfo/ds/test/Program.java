package com.sunbeaminfo.ds.test;
import java.util.Iterator;
import java.util.Scanner;

class Node{
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
class LinkedList implements Iterable<Integer>, Iterator<Integer>{
	private Node head;	//null
	private Node tail;	//null
	public boolean empty() {
		return this.head == null;
	}
	/* public void addFirst(int data ) {
		Node newNode = new Node( data );
		if( this.empty()) { 
			this.tail = newNode;
			this.head = newNode;
		}else {
			newNode.next = this.head;
			this.head = newNode;
		}
	} */
	public void addFirst(int data ) {
		Node newNode = new Node( data );
		if( this.empty()) 
			this.tail = newNode;
		else 
			newNode.next = this.head;
		this.head = newNode;
	}
	/*public void addLast(int data) {
		Node newNode = new Node( data );
		if( this.empty()) {
			this.head = newNode;
			this.tail = newNode;
		}else {
			this.tail.next = newNode;
			this.tail = newNode;
		}
		
	}*/
	public void addLast(int data) {
		Node newNode = new Node( data );
		if( this.empty())
			this.head = newNode;
		else
			this.tail.next = newNode;
		this.tail = newNode;
	}
	public Node find( int data ){
		Node trav = this.head;
		while( trav != null ) {
			if( trav.data == data )
				return trav;
			trav = trav.next;
		}
		return null;
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
	public void removeFirst() throws InvalidOperationException{
		if( this.empty())
			throw new InvalidOperationException("LinkedList is empty");
		if( this.head == this.tail )
			this.head = this.tail = null;
		else
			this.head = this.head.next;
	}
	public void removeLast() throws InvalidOperationException{
		if( this.empty())
			throw new InvalidOperationException("LinkedList is empty");
		if( this.head == this.tail )
			this.head = this.tail = null;
		else {
			Node trav = this.head;
			while( trav.next != this.tail )
				trav = trav.next;
			this.tail = trav;
			this.tail.next = null;
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
	public void reverse( ) {
		if( this.empty())
			throw new InvalidOperationException("LinkedList is empty");
		Node trav = this.head;
		Node current;
		Node previous = null;
		while( trav != null ) {
			current = trav;
			trav  = trav.next;
			current.next = previous;
			previous = current;
		}
		this.tail = this.head;
		this.head = previous;
	}
	public void printList() throws InvalidOperationException{
		if( this.empty())
			throw new InvalidOperationException("LinkedList is empty");
		Node trav = this.head;
		while( trav != null ) {
			int data = trav.data;
			System.out.print(data+"	");
			trav = trav.next;
		}
		System.out.println();
	}
	public void clear( ) {
		while( !this.empty() )
			this.removeFirst();
	}
	private Node trav;
	@Override
	public Iterator<Integer> iterator() {
		this.trav = this.head;
		return this;
		//return new LinkedListIterator(this.head);
	}
	 
	@Override
	public boolean hasNext() {
		return this.trav != null;
	}
	@Override
	public Integer next() {
		int data = trav.data;
		trav = trav.next;
		return data;
	}
}
/* class LinkedListIterator implements Iterator<Integer>{
	private Node trav;
	public LinkedListIterator(Node head) {
		this.trav = head;
	}
	@Override
	public boolean hasNext() {
		return this.trav != null;
	}

	@Override
	public Integer next() {
		int data = this.trav.data;
		trav = trav.next;
		return data;
	}
} */
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
	public static void iterateList(LinkedList list ) {
		Integer element;
		Iterator<Integer> itr = list.iterator();
		while( itr.hasNext()) {
			element = itr.next();
			System.out.print(element+"	");
		}
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
		System.out.println("7.Reverse List");
		System.out.println("8.Print List");
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
					list.addLast( data[ 0 ]);
					break;
				case 3:
					Program.acceptRecord( data );
					Program.acceptPosition(position);
					list.addAtPosition( data[ 0 ], position[0]);
					break;
				case 4:
					list.removeFirst( );
					break;
				case 5:
					list.removeLast( );
					break;
				case 6:
					Program.acceptPosition(position);
					list.removeFromPosition( position[ 0 ] );
					break;
				case 7:
					list.reverse( );
					break;
				case 8:
					//list.printList( );
					Program.iterateList( list );
					break;
				}
			} catch (InvalidOperationException e) {
				System.out.println(e.getMessage());
			}
		}
		list.clear();
	}
}