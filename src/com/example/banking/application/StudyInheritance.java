package com.example.banking.application;

import java.util.concurrent.ThreadLocalRandom;

import com.example.banking.domain.Account;
import com.example.banking.domain.CheckingAccount;

public class StudyInheritance {
	public static void main(String[] args) {

		Account acc = null;
		if(ThreadLocalRandom.current().nextBoolean())
		acc = new Account("tr1",10_000,null);
		else
		acc = new CheckingAccount("tr1", 10000, null, 5000);
		acc.withdraw(5_000);
		System.out.println(acc.getClass().getName());
	
	}
}
