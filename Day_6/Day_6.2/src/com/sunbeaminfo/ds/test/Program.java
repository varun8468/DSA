package com.sunbeaminfo.ds.test;

import java.util.Collection;
import java.util.Set;

import com.sunbeaminfo.ds.collection.Hashtable;
import com.sunbeaminfo.ds.model.Account;
import com.sunbeaminfo.ds.model.Customer;
import com.sunbeaminfo.ds.model.Entry;

public class Program {
	public static void main(String[] args) {
		Hashtable ht = new Hashtable();
		ht.put( new Account(3241,"Saving", 50000.50f), new Customer("Nitin","nitin@sunbeaminfo.com","11111") );
		ht.put( new Account(1983,"Current", 50000.50f), new Customer("Prashant","prashant@sunbeaminfo.com","22222") );
		ht.put( new Account(4059,"Loan", 50000.50f), new Customer("Nilesh","nilesh@sunbeaminfo.com","33333") );
		ht.put( new Account(2951,"Pention", 50000.50f), new Customer("Amit","amit@sunbeaminfo.com","44444") );
		ht.put( new Account(9835,"PPF", 50000.50f), new Customer("Rahul","rahul@sunbeaminfo.com","55555") );
		ht.put( new Account(6723,"Joint", 50000.50f), new Customer("Sarang","sarang@sunbeaminfo.com","66666") );
		
		
		//Program.printKeys( ht );
		//Program.printValues( ht );
		//Program.printEntries( ht );
		
		Program.find( ht, 4059 );
	}

	private static void find(Hashtable ht, int accNumber) {
		Account key = new Account(accNumber);
		Customer value = ht.get( key );
		System.out.println(value);
	}

	private static void printEntries(Hashtable ht) {
		Set<Entry> entries = ht.entrySet();
		entries.forEach(System.out::println);
	}

	private static void printValues(Hashtable ht) {
		Collection<Customer> values = ht.values();
		values.forEach(System.out::println);
	}

	private static void printKeys(Hashtable ht) {
		Set<Account> keys = ht.keySet();
		keys.forEach(System.out::println);
	}
}