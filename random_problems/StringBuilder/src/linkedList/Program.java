package linkedList;

public class Program {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("Varun Patle");
		sb.setCharAt(sb.length()-1, 'o');
		System.out.println(sb);
		sb.insert(sb.length()-2, "hiii!!!");
		System.out.println(sb);
		sb.delete(9, sb.length()-2);
		sb.append('h');
		System.out.println(sb);
	}
	
}
