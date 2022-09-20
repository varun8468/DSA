package com.sunbeaminfo.ds.test;

import java.util.ArrayDeque;
import java.util.Queue;
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
		}//end of elese
		this.balance( this.root, null );
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
	public void levelOrder( ) throws InvalidOperationException {
		if( this.empty() )
			throw new InvalidOperationException("Tree is empty.");
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.offer(this.root);
		while( !queue.isEmpty()) {
			Node trav = queue.poll();
			System.out.print(trav.data+"  ");
			if( trav.left != null )
				queue.offer(trav.left);
			if( trav.right != null )
				queue.offer(trav.right);
		}
		System.out.println();
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
	public Node findNode( int data, Node[] parent) {
		Node trav = this.root;
		parent[ 0 ] = null;	//If tree is empty / target node is root then parent must be null.
		while( trav != null ) {
			if( data == trav.data )
				return trav;
			parent[ 0 ] = trav;
			if( data < trav.data )	//if data is less than parent node
				trav = trav.left;	//visit left sub tree
			else	//if data is greater than parent node
				trav = trav.right;	//visit right sub tree
		}
		parent[ 0 ] = null;	//if node not found then parent must be null;
		return null;
	}
	public void deleteNode(int data ) throws InvalidOperationException {
		Node[]arr = new Node[1];
		Node target = this.findNode(data, arr );
		Node parent = arr[ 0 ];
		
		if( target == null ) 
			throw new InvalidOperationException("Element not found");
		if( target.left != null && target.right != null ) {
			parent = target;
			Node successor = target.right;
			while( successor.left != null ) {
				parent = successor;
				successor = successor.left;
			}
			//Copy data of successor into target node
			target.data = successor.data;
			target = successor;
		}
		if( target.left == null ) {
			if( target == this.root )
				this.root = target.right;
			else if( target == parent.left )
				parent.left = target.right;
			else
				parent.right = target.right;
		}else if( target.right == null ) {
			if( target == this.root )
				this.root = target.left;
			else if( target == parent.left )
				parent.left = target.left;
			else
				parent.right = target.left;
		}
		target = null;
	}
	public int height( ) {
		int height =  BSTree.height( this.root );
		return height;
	}
	private static int height(Node trav) {
		if( trav == null )
			return -1;
		int heightOfLeftSubTree = BSTree.height( trav.left ); 
		int heightOfRightSubTree = BSTree.height( trav.right );
		if( heightOfLeftSubTree > heightOfRightSubTree )
			return heightOfLeftSubTree + 1;
		return heightOfRightSubTree + 1;
	}
	public static int balanceFactor( Node node ) {
		return BSTree.height(node.left) - BSTree.height(node.right);
	}
	private void balance(Node node, Node parent) {
		if( node == null )
			return;
		balance(node.left, node);
		balance(node.right, node);
		
		int bf =  BSTree.balanceFactor(node);
		if( bf > 1 ) {
			if( BSTree.balanceFactor(node.left) > 0 )
				this.llCase( node, parent);
			else
				this.lrCase( node, parent);
		}else if( bf  < -1 ) {	
			if( BSTree.balanceFactor(node.right) > 0 )
				this.rlCase( node, parent);
			else
				this.rrCase( node, parent);
		}
	}
	private Node llCase(Node node, Node parent) {
		Node leftSubTree = node.left;
		node.left = leftSubTree.right;
		leftSubTree.right = node;
		if( node == this.root )
			this.root = leftSubTree;
		else if( node == parent.left )
			parent.left = leftSubTree;
		else
			parent.right = leftSubTree;
		return leftSubTree;
	}	
	private Node rrCase(Node node, Node parent) {
		Node rightSubTree = node.right;
		node.right = rightSubTree.left;
		rightSubTree.left = node;
		if( node == this.root )
			this.root = rightSubTree;
		else if( node == parent.left )
			parent.left = rightSubTree;
		else
			parent.right = rightSubTree;
		return rightSubTree;
	}
	private Node lrCase(Node node, Node parent) {
		node.left = this.rrCase(node.left, node);
		node = llCase(node, parent);
		return node;
	}
	private Node rlCase(Node node, Node parent) {
		node.right = llCase(node.right, node);
		node = rrCase(node, parent);
		return node;
	}
}
public class Program {
	public static void main(String[] args) {
		try {
			BSTree tree = new BSTree();
			//21,26,30,9,4,14,28,18,15,10,2,3,7
			
			tree.addNode( 21 );
			tree.addNode( 26 );
			tree.addNode( 30 );
			tree.addNode( 9 );
			tree.addNode( 4 );
			tree.addNode( 14 );
			tree.addNode( 28 );
			tree.addNode( 18 );
			tree.addNode( 15 );
			tree.addNode( 10 );
			tree.addNode( 2 );
			tree.addNode( 3 );
			tree.addNode( 7 );
			
			//tree.preorder();
			//tree.nonRecPreorder();
			
			//tree.inorder( );
			//tree.nonRecInorder();
			
			//tree.postorder( );
			//tree.nonRecPostorder();
			
			//tree.levelOrder();
			
			//tree.deleteNode( 90 );
			
			//System.out.println("Height of tree	:	"+tree.height());
			//tree.preorder();	//14  4  3  2  9  7  10  21  15  18  28  26  
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
