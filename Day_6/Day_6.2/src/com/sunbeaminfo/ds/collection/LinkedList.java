package com.sunbeaminfo.ds.collection;

import java.util.Iterator;

import com.sunbeaminfo.ds.model.Entry;

public class LinkedList implements Iterable<Entry>, Iterator<Entry>{
	private Node head;
	private Node tail;
	public boolean empty( ) {
		return this.head == null;
	}
	public void addLast( Entry data ) {
		Node newNode = new Node(data);
		if( this.empty())
			this.head = newNode;
		else
			this.tail.next = newNode;
		this.tail = newNode;
	}
	Node trav;
	@Override
	public Iterator<Entry> iterator() {
		this.trav = this.head;
		return this;
	}
	@Override
	public boolean hasNext() {
		return this.trav != null;
	}
	@Override
	public Entry next() {
		Entry data = this.trav.data;
		this.trav  = this.trav.next;
		return data;
	}
}
