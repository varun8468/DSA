package linkedList;

public class Program {
	
	public static void main(String[] args) {
		int result = advetisement(5);
		System.out.println(result);
	}

	private static int advetisement(int n) {
		int shared = 5;
		int liked=0;
		int cummu = 0;
		for(int i = 0; i<n; i++) {
			liked = shared/ 2;
			cummu = cummu + liked;
			shared = liked * 3;
		}
		return cummu;
	}
	
}