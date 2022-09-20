package com.sunbeaminfo.ds.test;
import java.util.Scanner;

class Node{
	int data;
	Node next;	//null
	public Node( int data ) {
		this.data = data;
	}
}
class LinkedList{
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
}
public class Program {
	private static Scanner sc = new Scanner(System.in);
	private static void acceptRecord(int[] data) {
		System.out.print("Enter data	:	");
		data[ 0 ] = sc.nextInt();
	}
	public static int menuList( ) {
		System.out.println("0.Exit");
		System.out.println("1.Add first.");
		System.out.println("2.Add last.");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
	public static void main(String[] args) {
		int choice;
		int[] data = new int[1];
		LinkedList list = new LinkedList();
		while( ( choice = Program.menuList( ) ) != 0 ) {
			switch( choice ) {
			case 1:
				Program.acceptRecord( data );
				list.addFirst( data[ 0 ] );
				break;
			case 2:
				Program.acceptRecord( data );
				list.addLast( data[ 0 ]);
				break;
			}
		}
	}
}













