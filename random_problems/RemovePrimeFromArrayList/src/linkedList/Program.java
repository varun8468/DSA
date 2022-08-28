package linkedList;

import java.util.ArrayList;

public class Program {
	
	private static void solution(ArrayList<Integer> list) {
		for(int i = list.size()-1;i>0;i--) {
			int val = list.get(i);
			if(isPrime(val))
				list.remove(i);
		}
		
	}
	private static boolean isPrime(int val) {
		for(int div=2; div*div<=val;div++) {
			if(val%div==0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(7);
		list.add(18);
		list.add(3);
		list.add(14);
		list.add(19);
		list.add(31);
		list.add(72);
		list.add(7);
		System.out.println(list);
		solution(list);
		System.out.println(list);
	}

	
	
}
