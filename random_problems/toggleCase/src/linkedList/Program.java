package linkedList;

public class Program {
	private static void toggleCase(StringBuilder sb) {
		for(int i = 0; i<sb.length();i++) {
			char ch = sb.charAt(i);
			if(ch >= 'a' && ch<='z') {
				char uch = (char) ('A'+ch-'a');
				sb.setCharAt(i, uch);
			}
			else if(ch>'A' && ch<'Z'){
				char lch = (char) ('a'+ch-'A');
				sb.setCharAt(i, lch);
			}
		}
		
	}
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder("VaruN");
		toggleCase(sb);
		System.out.println(sb);
	}

	
	
}