package linkedList;

public class Program {
	
	public static void main(String[] args) {
		
		int result = utopianTree(5);
		System.out.println(result);
		
	}

	private static int utopianTree(int n) {
		int height = 1;
		for(int i = 1; i<=n; i++) {
			if(i%2!=0)
				height = height * 2;
			else
				height = height + 1;
		}
		return height;
	}
	
}