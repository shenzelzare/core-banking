package com.example.banking.application;

import com.example.banking.domain.Account;
import com.example.banking.domain.Customer;

public class Example {

	public static void main(String[] args) {
		var jack = new Customer("11111111110", "jack bauer");
	//	var kate = new Customer("11111111110", "kate austen");
		var zeki = new Customer("12341234", "zeki aynal");
		jack.addAccount(new Account("tr1", 10_000, null));
		jack.addAccount(new Account("tr2", 20_000,null));
		jack.addAccount(new Account("tr3", 30_000,null));
		zeki.addAccount(new Account("tr1", 5_250,null));
		zeki.addAccount(new Account("tr2",5_000,null));
		
		System.err.println(zeki.getTotalBalance());
		
		
		
		System.out.println(zeki);
		
	//	zeki.removeAccount("tr1");
		System.out.println(zeki);
		System.out.println(jack);
		
		System.out.println(zeki);

		// jack.getAccounts().add(new Account("tr4",40_000));
		//kate.addAccount(new Account("tr4", 20_000));
	/*	var account = jack.removeAccount("tr4");
		if (account.isPresent()) {
			account.get().withdrawAll();
		}
		
		*/
		/*
		 * var balance = jack.removeAccount("tr4") .orElseThrow(() -> new
		 * IllegalArgumentException("Cannot find the account to remove"))
		 * .withdrawAll();
		 */
//		jack.removeAccount(0);
	//	System.out.println(jack);
	
		
	}

}