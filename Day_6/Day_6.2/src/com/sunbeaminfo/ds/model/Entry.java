package com.sunbeaminfo.ds.model;

public class Entry{
	private Account key;
	private Customer value;
	public Entry() {
	}
	public Entry(Account key, Customer value) {
		this.key = key;
		this.value = value;
	}
	public Account getKey() {
		return key;
	}
	public void setKey(Account key) {
		this.key = key;
	}
	public Customer getValue() {
		return value;
	}
	public void setValue(Customer value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return this.key+"	"+this.value;
	}
}