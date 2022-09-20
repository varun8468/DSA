package com.sunbeam.ds;
class Employee{
	private String name;
	private int empid;
	private float salary;
	public Employee(String name, int empid, float salary) {
		this.name = name;
		this.empid = empid;
		this.salary = salary;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empid;
		return result;
	}
}
public class Program {
	public static void main(String[] args) {
		Employee e1 = new Employee("ABC", 23, 15000.50f);
		//System.out.println("e1	:	"+System.identityHashCode(e1));
		System.out.println("e1	:	"+e1.hashCode());
		
		Employee e2 = new Employee("ABC", 23, 15000.50f);
		//System.out.println("e2	:	"+System.identityHashCode(e2));
		System.out.println("e2	:	"+e2.hashCode());
	}
	public static void main1(String[] args) {
		String s1 = new String("SunBeam");
		System.out.println(s1+"	"+s1.hashCode());	//-193341445
		
		String s2 = new String("SunBeam");
		System.out.println(s2+"	"+s2.hashCode());	//-193341445
	}
}
