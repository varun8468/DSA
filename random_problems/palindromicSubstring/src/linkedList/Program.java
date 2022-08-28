package linkedList;

public class Program {
	public static void main(String[] args) {
		String s = "aba";
		for(int i=0; i<s.length();i++) {
			for(int j=i+1; j<=s.length();j++) {
				String ss = s.substring(i,j);
				if(isPalindrome(ss))
					System.out.println(ss);
			}
		}
	}

	private static boolean isPalindrome(String ss) {
		int i=0;
		int j=ss.length()-1;
		while(i<j) {
			if(ss.charAt(i)!=ss.charAt(j))
				return false;
			else {
				i++;
				j--;
			}
			
		}
		return true;
	}
	
}
