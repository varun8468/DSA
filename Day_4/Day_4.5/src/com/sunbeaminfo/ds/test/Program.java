package com.sunbeaminfo.ds.test;
class Employee{
	private String name;
	private int empid;
	private float salary;
	public Employee(String name, int empid, float salary) {
		this.name = name;
		this.empid = empid;
		this.salary = salary;
	}
	public float getSalary() {
		return salary;
	}
	@Override
	public String toString() {
		return String.format("%-15s%-5d%-10.2f", this.name, this.empid, this.salary);
	}
}
public class Program {
	public static Employee[] getEmployees( ) {
		Employee[] arr = new Employee[ 5 ];
		arr[ 0 ] = new Employee("Nitin", 15, 30000.50f);
		arr[ 1 ] = new Employee("Amit", 13, 10000.45f);
		arr[ 2 ] = new Employee("Rahul", 11, 50000.35f);
		arr[ 3 ] = new Employee("Sachin", 14, 20000.00f);
		arr[ 4 ] = new Employee("Rajiv", 12, 40000.50f);
		return arr;
	}
	private static void printRecord(Employee[] arr) {
		if( arr != null ) {
			for (Employee employee : arr)
				System.out.println(employee);
			System.out.println();
		}
	}
	public static void sort( Employee[] arr ) {
		for( int i = 0; i < arr.length - 1; ++ i ) {
			for( int j = 0; j < arr.length-1-i; ++ j ) {
				if( arr[ j ].getSalary() > arr[ j + 1 ].getSalary()) {
					Employee temp = arr[ j ];
					arr[ j ] = arr[ j + 1 ];
					arr[ j + 1 ] = temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		Employee[] arr = Program.getEmployees();
		Program.printRecord( arr );
		Program.sort(arr);
		Program.printRecord( arr );
	}
}
