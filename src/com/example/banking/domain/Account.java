package com.example.banking.domain;

public class Account extends Object{

	private String iban; // attribute/state/property/data
	protected double balance;
	private AccountStatus status = AccountStatus.ACTIVE;

	public Account(String iban, double balance) {
		super();
		this.iban = iban;
		this.balance = balance;
	}
	
	public Account(String iban, double balance, AccountStatus status) {
		this.iban = iban;
		this.balance = balance;
		this.status = status;
	}

	public AccountStatus getStatus() {
		return status;
	}


	public void setStatus(AccountStatus status) {
		this.status = status;
	}


	public String getIban() {
		return iban;
	}

	public double getBalance() {
		return balance;
	}

	public boolean deposit(double amount) {
		// validation
		if (amount <= 0)
			return false;
		// business logic
		this.balance += amount;
		return true;
	}

	public boolean withdraw(double amount) {
		System.out.println("Accountin withdraw i calisti");
		// validation
		if (amount <= 0)
			return false;
		// business rule
		if (amount > this.balance)
			return false;
		// business logic
		this.balance -= amount;
		return true;
	}

	public double withdrawAll() {
		var balance = this.balance;
		this.balance = 0.0;
		return balance;
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + ", status=" + status + "]";
	}

	
}
