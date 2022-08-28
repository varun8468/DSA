package linkedList;

public class Program {
	private static String kangaroos(int x1, int v1, int x2, int v2) {
		while(x1!=x2) {
			if(x1>x2) {
				if(v2<v1)
					return "No";
				x1= x1+v1;
				x2= x2+v2;
				if(x1==x2)
					return "Yes";
			}
		}
		
		return null;
	}
	public static void main(String[] args) {
		
		String res = kangaroos(2, 1, 1, 2);
		System.out.println(res);
	}

	
	
}