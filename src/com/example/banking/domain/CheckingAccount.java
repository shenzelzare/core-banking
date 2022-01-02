package com.example.banking.domain;

public class CheckingAccount extends Account {

	private double overdraftAmount;

	public CheckingAccount(String iban, double balance, AccountStatus status, double overdraftAmount) {
		super(iban, balance, status);
		this.overdraftAmount = overdraftAmount;
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}

	public void setOverdraftAmount(double overdraftAmount) {
		this.overdraftAmount = overdraftAmount;
	}

	@Override
	public boolean deposit(double amount) {
		// TODO Auto-generated method stub
		return super.deposit(amount);
	}

	@Override
	public boolean withdraw(double amount) {
		System.out.println("Checkaccountin withdraw i calisti");
		//Validation
		if(amount<=0.0) return false;
		//Business Rule
		if(amount>(balance+overdraftAmount)) return false;
		this.balance = amount;
		return true;
	}

	@Override
	public double withdrawAll() {
		// TODO Auto-generated method stub
		return super.withdrawAll();
	}

}
