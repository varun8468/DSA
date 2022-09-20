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
	private static void convertInfixToPostfix(StringBuilder infix, StringBuilder postfix) {
		Stack<Character> stk = new Stack<>();
		for( int index = 0; index < infix.length(); ++ index ) {
			if( Character.isDigit(infix.charAt(index)))
				postfix.append(infix.charAt(index));
			else if( infix.charAt(index) == '(')
				stk.push(infix.charAt(index));
			else if( infix.charAt(index) == ')') {
				while( stk.peek() != '(' ) {
					postfix.append(stk.pop());	
				}
				stk.pop();	//To remove '(' from stack top
			}else {
				while( !stk.empty() && ( Program.priority( stk.peek()) >= Program.priority(infix.charAt(index)))) {
					postfix.append(stk.pop());
				}
				stk.push(infix.charAt(index));
			}
		}
		while( !stk.empty()) 
			postfix.append(stk.pop());
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
	public static int evaluatePostfixExpression( StringBuilder postfix ) {
		int result = 0, num1, num2;
		Stack<Integer> stk = new Stack<Integer>( );
		for( int index = 0; index < postfix.length(); ++ index ) {
			if( Character.isDigit(postfix.charAt(index)))
				stk.push(postfix.charAt(index) - '0');
			else {
				num2 = stk.pop();
				num1 = stk.pop();
				result = Program.calculate(num1, postfix.charAt(index), num2);
				stk.push(result);
			}
		}
		result = stk.pop();
		return result;
	}
	public static void main1(String[] args) {
		StringBuilder infix = new StringBuilder("5+3*9/(7-4)-6*2");
		StringBuilder postfix = new StringBuilder();
		System.out.println("Infix Expression	:	"+infix);	//5+3*9/(7-4)-6*2
		Program.convertInfixToPostfix( infix, postfix);
		System.out.println("Postfix Expression	:	"+postfix);	//539*74-/+62*-
	}
	public static void main(String[] args) {
		StringBuilder postfix = new StringBuilder("539*74-/+62*-");
		int result = Program.evaluatePostfixExpression(postfix);
		System.out.println("Result	:	"+result);
	}
}
