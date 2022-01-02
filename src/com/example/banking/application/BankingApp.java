package com.example.banking.application;

import com.example.banking.domain.Customer;

import com.example.banking.domain.Account;

public class BankingApp {

	public static void main(String[] args) {
		Account account = new Account("12345678901", 10_000,null);
		/*
		 * System.err.println(account.getBalance());
		 * System.err.println(account.deposit(5_000));
		 * System.err.println(account.getBalance());
		 * 
		 * 
		 * Account account2 = account; System.err.println(account2.getBalance());
		 * System.err.println(account2.withdraw(1000));
		 * System.out.println(account.toString());
		 */

		/*
		 * double one =0/0.; System.err.println("one: "+ one);
		 * System.err.println(Double.isNaN(one));
		 */
		
		Customer customer = new Customer("12341234","ZekiAynal");
		customer.addAccount(account);
		
	}
}
