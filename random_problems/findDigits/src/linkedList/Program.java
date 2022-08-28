package linkedList;

public class Program {
	private static int digit(int n) {
		int temp = n;
		int count = 0;
	    while(n>0){
	        int rem = n%10;
	        if(temp%rem==0)
	        	count++;
	        n = n/10;
	    }
		return count;
	}
	public static void main(String[] args) {
		int result = digit(12);
		System.out.println(result);
	}

	
	
}