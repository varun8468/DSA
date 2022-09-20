package com.sunbeaminfo.ds.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.sunbeaminfo.ds.model.Account;
import com.sunbeaminfo.ds.model.Customer;
import com.sunbeaminfo.ds.model.Entry;

public class Hashtable {
	private int size;
	private LinkedList[] buckets;
	public Hashtable() {
		this( 7 );	//Constructor Chaining
	}
	public Hashtable( int size ) {
		this.size = size;
		this.buckets = new LinkedList[ this.size ];
	}	
	/* public void put( Account key, Customer value ) {
		Entry entry = new Entry(key, value);
		int hashCode = key.hashCode();
		int slot = hashCode % this.size;
		if( buckets[ slot ] == null )
			buckets[ slot ] = new LinkedList();
		buckets[ slot ].addLast(entry);
	} */
	public void put( Account key, Customer value ) {
		int slot = key.hashCode() % this.size;
		if( buckets[ slot ] == null )
			buckets[ slot ] = new LinkedList();
		if( buckets[ slot ] != null ) {
			for( Entry entry : buckets[ slot ] ) {
				if( entry.getKey().equals(key))
					entry.setValue(value);
			}
		}
		else
			buckets[ slot ].addLast(new Entry(key, value));
	}
	public Customer get(Account key) {
		int slot = key.hashCode() % this.size;
		if( buckets[ slot ] != null ) {
			for( Entry entry : buckets[ slot ] ) {
				if( entry.getKey().equals(key))
					return entry.getValue();
			}
		}
		return null;
	}
	public Set<Account> keySet( ){
		Set<Account> keys = new HashSet<>();
		for( int index = 0; index < buckets.length; ++ index ) {
			if( this.buckets[ index ]  != null ) {
				for( Entry entry : this.buckets[ index ] )
					keys.add(entry.getKey());
			}
		}
		return keys;
	}
	public Collection<Customer> values( ){
		Collection<Customer> values = new ArrayList<Customer>();
		for( int index = 0; index < buckets.length; ++ index ) {
			if( this.buckets[ index ]  != null ) {
				for( Entry entry : this.buckets[ index ] )
					values.add(entry.getValue());
			}
		}
		return values;
	}
	public Set<Entry> entrySet( ){
		Set<Entry> entries = new HashSet<>();
		for( int index = 0; index < buckets.length; ++ index ) {
			if( this.buckets[ index ]  != null ) {
				for( Entry entry : this.buckets[ index ] )
					entries.add(entry);
			}
		}
		return entries;
	}
}
