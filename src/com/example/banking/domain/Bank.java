package com.example.banking.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Bank implements TransferService{

	private final int id;
	private String commercialName;
	private final BankType type;
	private Map<String, Customer> customers = new HashMap<>();

	public Bank(int id, String commercialName, BankType type) {
		this.id = id;
		this.commercialName = commercialName;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public String getCommercialName() {
		return commercialName;
	}

	public BankType getType() {
		return type;
	}

	public void setCommercialName(String commercialName) {
		this.commercialName = commercialName;
	}

	public List<Customer> getCustomers() {
		// NOTE: Make sure that you do not violate information hiding principle!
		return customers.values().stream().toList();
	}

	public Customer createCustomer(String identity, String fullname) {
		Customer newCustomer = new Customer(identity,fullname);
		customers.put(identity, newCustomer);
		return newCustomer;
	}

	public Optional<Customer> findCustomerByIdentity(String identity) {
		return Optional.ofNullable(customers.get(identity));
	}

	public double getTotalBalance(AccountStatus... status) {
		// status
		// NOTE: "AccountStatus... status" means it is an array
		// You can call getTotalBalance() as in the following examples:
		// var activeTotal = garantiBbva.getTotalBalance(AccountStatus.ACTIVE);
		// var activeAndBlockedTotal = garantiBbva.getTotalBalance(AccountStatus.ACTIVE,
		// AccountStatus.BLOCKED);
		// var allTotal = garantiBbva.getTotalBalance(); // or
		// var allTotal = garantiBbva.getTotalBalance( AccountStatus.ACTIVE,
		// AccountStatus.BLOCKED,AccountStatus.CLOSED);
		return customers.values()
						.stream()
						.map(Customer::getAccounts)
						.flatMap(Collection::stream)
						  .filter(account -> Arrays.stream(status).filter(st -> st.equals(account.getStatus())).findFirst().isPresent())
					         .mapToDouble(Account::getBalance)
					         .sum();
	}
	
	@Override
	public boolean transfer(String fromIdentity, String fromIban, String toIdentity, String toIban, double amount) {
		if (amount <= 0) return false;
		var fromCustomer = findCustomerByIdentity(fromIdentity);
		var toCustomer = findCustomerByIdentity(toIdentity);
		if (fromCustomer.isPresent() && toCustomer.isPresent()) {
			var fromAccount = fromCustomer.get().findAccount(fromIban);
			var toAccount = toCustomer.get().findAccount(toIban);
			if (fromAccount.isPresent() && fromAccount.get().getStatus().equals(AccountStatus.ACTIVE) && 
				toAccount.isPresent() && toAccount.get().getStatus().equals(AccountStatus.ACTIVE)){
				if(fromAccount.get().withdraw(amount)) {
					toAccount.get().deposit(amount);
					return true;
				}
			}
		}
		return false;
}
}
