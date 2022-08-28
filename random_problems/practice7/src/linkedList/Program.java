package linkedList;

public class Program {
	
	public static void main(String[] args) {
		String result = catAndMouse(1, 2, 3);
		System.out.println(result);
	}

	private static String catAndMouse(int x, int y, int z) {
		int d1= 0;
		int d2= 0;
		if(x>z)
			d1=x-z;
		else d1=z-x;
		
		if(y>z)
			d2=y-z;
		else d2 = z-y;
		
		if(d1==d2)
			return "Mouse C";
		else if(d1<d2)
			return "Cat A";
		else
			return "Cat B";
		
	}
	
}