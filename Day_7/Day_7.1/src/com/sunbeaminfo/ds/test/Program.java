package com.sunbeaminfo.ds.test;

import java.util.Stack;

class Node{
	Node left;	//null
	int data;
	Node right;	//null
	public Node( int data ) {
		this.data = data;
	}
}
class InvalidOperationException extends Exception{
	private static final long serialVersionUID = -8724484729031480234L;
	public InvalidOperationException(String message) {
		super(message);
	}
}
class BSTree{
	private Node root;	//null;
	public boolean empty( ) {
		return this.root == null;
	}
	public void addNode( int data ) {
		Node newNode = new Node( data );
		if( this.empty() )
			this.root = newNode;
		else {
			Node trav = this.root;
			while( true ) {
				if( data < trav.data ) {
					if( trav.left == null ) {
						trav.left = newNode;
						break;
					}
					trav = trav.left;
				}else{
					if( trav.right == null ) {
						trav.right = newNode;
						break;
					}
					trav = trav.right;
				}
			}
		}
	}
	public void nonRecPreorder( ) throws InvalidOperationException {
		if( this.empty() )
			throw new InvalidOperationException("Tree is empty.");
		Stack<Node> stk = new Stack<>();
		stk.push(this.root);
		while( !stk.empty()) {
			Node trav = stk.pop();
			System.out.print(trav.data+"  ");
			if( trav.right != null )
				stk.push(trav.right);
			if( trav.left != null )
				stk.push(trav.left);
		}
		System.out.println();
		
	}
	public void nonRecInorder( ) throws InvalidOperationException {
		if( this.empty() )
			throw new InvalidOperationException("Tree is empty.");
		
		Node trav = this.root;
		Stack<Node> stk = new Stack<Node>();
		while( trav != null || !stk.empty( ) ) {
			while( trav != null ) {
				stk.push(trav);
				trav = trav.left;
			}
			trav = stk.pop();
			System.out.print(trav.data+" ");
			trav = trav.right;
		}
	}
	public void nonRecPostorder( ) throws InvalidOperationException {
		if( this.empty() )
			throw new InvalidOperationException("Tree is empty.");
		Node trav = this.root;
		Stack<Node> stk = new Stack<Node>();
		do {
			while( trav != null ) {
				if( trav.right != null )
					stk.push(trav.right);
				stk.push(trav);
				trav = trav.left;
			}
			trav = stk.pop();
			if( !stk.empty() &&  trav.right != null && trav.right == stk.peek()) {
				stk.pop();
				stk.push(trav);
				trav = trav.right;
			}else {
				System.out.print(trav.data+"  ");
				trav = null;
			}
		}while( !stk.empty());
	}
	//Overloaded method
	public void preorder( ) {
		this.preorder( this.root );
		System.out.println();
	}
	private void preorder(Node trav) {	
		if( trav == null )
			return;
		System.out.print( trav.data+"  ");
		this.preorder( trav.left);
		this.preorder( trav.right);
	}
	
	//Overloaded method
	public void inorder() {
		this.inorder( this.root );
		System.out.println();
	}
	private void inorder(Node trav) {
		if( trav == null )
			return;
		this.inorder( trav.left );
		System.out.print(trav.data+"  ");
		this.inorder( trav.right);
	}
	//Overloaded method
	public void postorder() {
		this.postorder( this.root );
		System.out.println();
	}
	private void postorder(Node trav) {
		if( trav == null )
			return;
		this.postorder(trav.left);
		this.postorder(trav.right);
		System.out.print(trav.data+"  ");
	}
}
public class Program {
	public static void main(String[] args) {
		try {
			BSTree tree = new BSTree();
			
			tree.addNode( 90 );
			tree.addNode( 70 );
			tree.addNode( 150 );
			tree.addNode( 50 );
			tree.addNode( 80 );
			tree.addNode( 120 );
			tree.addNode( 180 );
			tree.addNode( 40 );
			
			//tree.preorder();
			//tree.nonRecPreorder();
			
			//tree.inorder( );
			//tree.nonRecInorder();
			
			//tree.postorder( );
			tree.nonRecPostorder();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
