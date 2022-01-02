package com.example.banking.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;

class AccountTest { 	

	@Test
	@DisplayName("create account object successfuly")
	void createObjectSuccessfuly() {
		// 1. Test Fixture/Setup
		// 2. Call exercise method
		var acc = new Account("tr1", 10_000,AccountStatus.ACTIVE);
		// 3. Verification
		assertEquals("tr1", acc.getIban());
		assertEquals(10_000, acc.getBalance());
		// 4. Tear-down
	}

	@ParameterizedTest
	@CsvFileSource(resources = "accounts.csv")
	void depositWithNegativeAmountShouldFail(String iban, double balance, double amount, AccountStatus status) throws Exception {
		// 1. Test Fixture/Setup
		var acc = new Account(iban, balance,status);
		// 2. Call exercise method
		var result = acc.deposit(amount);
		// 3. verification
		assertFalse(result);
		assertEquals(balance, acc.getBalance());

	}

	@Test
	void depositWithPositiveAmountShouldSuccess() throws Exception {
		// 1. Test Fixture/Setup
		var acc = new Account("tr1", 10_000,AccountStatus.ACTIVE);
		// 2. Call exercise method
		var result = acc.deposit(1);
		// 3. verification
		assertTrue(result);
		assertEquals(10_001, acc.getBalance());
	}

	@ParameterizedTest
	@CsvFileSource(resources = "accounts.csv")
	void withdrawWithNegativeAmountShouldFail(String iban, double balance, double amount,AccountStatus status) throws Exception {
		// 1. Test Fixture/Setup
		var acc = new Account(iban, balance,status);
		// 2. Call exercise method
		var result = acc.withdraw(amount);
		// 3. verification
		assertFalse(result);
		assertEquals(balance, acc.getBalance());
	}

	@Test
	void withdrawWithPositiveAmountShouldSuccess() throws Exception {
		// 1. Test Fixture/Setup
		var acc = new Account("tr1", 10_000,AccountStatus.ACTIVE);
		// 2. Call exercise method
		var result = acc.withdraw(1);
		var result1 = acc.withdraw(10_0001);
		// 3. verification
		assertTrue(result);
		assertFalse(result1);
		assertEquals(9_999, acc.getBalance());

	}

	@ParameterizedTest
	@CsvFileSource(resources = "accounts.csv")
	void withdrawWithPositiveAmountShouldFail(String iban, double balance, double amount, AccountStatus status) throws Exception {
		// 1. Test Fixture/Setup
		var acc = new Account(iban, balance,status);
		// 2. Call exercise method
		var result = acc.withdraw(amount);
		// 3. verification
		assertNotNull(status);
		assertFalse(result);
		assertEquals(balance, acc.getBalance());
	}

	@ParameterizedTest
	@CsvFileSource(resources = "accounts.csv")
	void toStringSuccess(String iban, double balance, double amount, AccountStatus status) throws Exception {
		// 1. Test Fixture/Setup
		var testString = "Account [iban=" + iban + ", balance=" + balance + ", status=" + status + "]";
		var acc = new Account(iban, balance,status);
		// 2. Call exercise method
		// 3. verification
		assertEquals(testString, acc.toString());
	}

	@Test
	void withdrawAllSuccess() throws Exception {
		// 1. Test Fixture/Setup
		var acc = new Account("tr1", 10_000,AccountStatus.ACTIVE);
		// 2. Call exercise method
		acc.withdrawAll();
		// 3. verification
		assertEquals(0.0, acc.getBalance());
	}
	@Test
	@EnumSource(AccountStatus.class)
	void toGetStatusSucces() throws Exception{
	    var test = AccountStatus.ACTIVE;
	    Account acc1 = new Account("tr1",10_000,AccountStatus.ACTIVE);
	    
	    // TODO review the generated test code and remove the default call to fail.
	    assertEquals(test, acc1.getStatus());
	}
	
	@Test
	@EnumSource(AccountStatus.class)
	void toSetStatusSucces() throws Exception{
	    
	    Account acc1 = new Account("tr1",10_000,null);
	    acc1.setStatus(AccountStatus.ACTIVE);
	    // TODO review the generated test code and remove the default call to fail.
	    assertNotNull(acc1.getStatus());	
	    
	}
}
