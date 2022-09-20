package com.sunbeaminfo.ds.model;

public class Account{
	private int number;
	private String type;
	private float balance;
	public Account() {
	}
	public Account(int number) {
		this.number = number;
	}
	public Account(int number, String type, float balance) {
		this.number = number;
		this.type = type;
		this.balance = balance;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	@Override
	public boolean equals( Object object ) {
		if( object != null ) {
			Account other = (Account) object;
			if( this.number == other.number)
				return true;
		}
		return false;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		return result;
	}
	@Override
	public String toString() {
		return String.format("%-5d%-15s%-10.2f", this.number, this.type, this.balance);
	}
}