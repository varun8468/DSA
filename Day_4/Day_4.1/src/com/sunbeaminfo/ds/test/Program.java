package com.sunbeaminfo.ds.test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Program {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.addFirst(10);
		list.addFirst(20);
		list.addFirst(30);
		list.addFirst(40);
		list.addFirst(50);
		
		Integer element = null;
		while( !list.isEmpty()) {
			element = list.getFirst();
			System.out.println("Removed element is : "+element);
			list.removeFirst();
		}
	}
	public static void main3(String[] args) {
		Deque<Integer> stk = new ArrayDeque<>();
	
		stk.push(10);
		stk.push(20);
		stk.push(30);
		stk.push(40);
		stk.push(50);
		
		Integer element = null;
		while( !stk.isEmpty() ) {
			element = stk.peek();
			System.out.println("Popped element is	:	"+element);
			stk.pop();
		}
	}
	public static void main2(String[] args) {
		Stack<Integer> stk = new Stack<>();
		
		stk.push(10);
		stk.push(20);
		stk.push(30);
		stk.push(40);
		stk.push(50);
		
		Integer element = null;
		while( !stk.empty( ) ) {
			element = stk.peek();
			System.out.println("Popped element is	:	"+element);
			stk.pop();
		}
	}
	public static void main1(String[] args) {
		Stack<Integer> stk = new Stack<>();
		
		stk.push(10);
		stk.push(20);
		stk.push(30);
		stk.push(40);
		stk.push(50);
		
		for( Integer element : stk )
			System.out.println(element);
	}
}
