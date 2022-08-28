package linkedList;

public class Program {
	public static void main(String[] args) {
		String str = "aaabbbccddee";
		System.out.println(compression1(str));
		System.out.println(compression2(str));
	}

	private static String compression2(String str) {
		String s = str.substring(0,1);
		int count=1;
		for(int i = 1; i< str.length(); i++) {
			char curr = str.charAt(i);
			char prev = str.charAt(i-1);
			if(curr == prev)
				count++;
			else {
				if(count>1) {
					s+=count;
					count = 1;
				}
				s+=curr;
			}
		}
		if(count>1) {
			s+=count;
		}
		return s;
	}

	public static String compression1(String str) {
		String s = str.substring(0,1);
		for(int i = 1; i< str.length(); i++) {
			char curr = str.charAt(i);
			char prev = str.charAt(i-1);
			if(curr!=prev)
				s+=curr;
		}
		return s;
	}

	
	
}
