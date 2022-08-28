package linkedList;

import java.util.Stack;

public class Program {
	private static void convertToPostfix(StringBuilder infix, StringBuilder postfix) {
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
	
	private static int priority(Character operator) {
		switch(operator) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;	
		}
		return 0;
	}
	private static int evaluatePostfixExpr(StringBuilder postfix) {
		int result=0, num1, num2;
		Stack<Integer> stk = new Stack<Integer>();
		for(int i = 0; i< postfix.length(); ++i) {
			if(Character.isDigit(postfix.charAt(i)))
				stk.push(postfix.charAt(i)-'0');
			else {
				num2 = stk.pop();
				num1 = stk.pop();
				result = Program.calculate(num1, postfix.charAt(i), num2);
				stk.push(result);
			}
		}
		result = stk.pop();
		return result;
	}

	private static int calculate(int num1, char operator, int num2) {
		switch(operator) {
		case '+': return num1+num2;
		case '-': return num1-num2;
		case '*': return num1*num2;
		case '/': return num1/num2;
		}
		return 0;
	}

	public static void main1(String[] args) {
		StringBuilder infix = new StringBuilder("5+3*9/(7-4)-6*2");
		StringBuilder postfix = new StringBuilder();
		System.out.println("infix string : "+ infix);
		Program.convertToPostfix(infix , postfix);
		System.out.println("infix string : "+ postfix);
	}
	public static void main(String[] args) {
		StringBuilder postfix = new StringBuilder("539*74-/+62*-");
		int result = Program.evaluatePostfixExpr(postfix);
		System.out.println(result);
	}

	

	

	
}