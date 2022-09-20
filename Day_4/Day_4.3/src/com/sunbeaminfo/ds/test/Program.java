package com.sunbeaminfo.ds.test;

import java.util.Stack;

public class Program {
	public static int priority( char operator ) {
		switch( operator ) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		}
		return 0;
	}
	private static void convertInfixToPrefix(StringBuilder infix, StringBuilder prefix) {
		Stack<Character> stk = new Stack<>();
		for( int index = infix.length() - 1; index >= 0; -- index ) {
			if( Character.isDigit( infix.charAt(index) ) )
				prefix.append(infix.charAt(index));
			else if( infix.charAt(index) == ')' )
				stk.push( infix.charAt(index) );
			else if( infix.charAt(index) == '(') {
				while( stk.peek() != ')')
					prefix.append(stk.pop());
				stk.pop();	//To remove ')' from stack
			}else {
				while( !stk.empty() && ( Program.priority(stk.peek()) > Program.priority(infix.charAt(index))) ) {
					prefix.append(stk.pop());
				}
				stk.push( infix.charAt(index) );
			}
		}
		while( !stk.empty())
			prefix.append(stk.pop());
		
		prefix.reverse();
	}
	public static int calculate( int num1, char operator, int num2 ) {
		switch( operator ) {
		case '+':	return num1 + num2;
		case '-':	return num1 - num2;
		case '*':	return num1 * num2;
		case '/':	return num1 / num2;
		}
		return 0;
	}
	public static int evaluatePrefixExpression( StringBuilder prefix ) {
		int result = 0, num1, num2;
		Stack<Integer> stk = new Stack<Integer>( );
		for( int index = prefix.length() - 1; index >= 0; -- index ) {
			if( Character.isDigit( prefix.charAt(index)))
				stk.push(prefix.charAt(index) - '0' );
			else {
				num1 = stk.pop();
				num2 = stk.pop();
				result = Program.calculate(num1, prefix.charAt(index), num2);
				stk.push(result);
			}
		}
		result = stk.pop();
		return result;
	}
	public static void main1(String[] args) {
		StringBuilder infix = new StringBuilder("5+3*9/(7-4)-6*2");
		StringBuilder prefix = new StringBuilder();
		System.out.println("Infix Expression	:	"+infix);	//5+3*9/(7-4)-6*2
		Program.convertInfixToPrefix( infix, prefix);
		System.out.println("Prefix Expression	:	"+prefix);	//-+5/*39-74*62
	}
	public static void main(String[] args) {
		StringBuilder prefix = new StringBuilder("-+5/*39-74*62");
		int result = Program.evaluatePrefixExpression(prefix);
		System.out.println("Result	:	"+result);	//2
	}
	public static void main3(String[] args) {
		char ch = '3';
		int number = ch - '0' ;
		System.out.println(number);	//3
	}
}
