package com.example.banking.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class Customer {
	private final String identity;
	private String fullName;
	private Map<String, Account> accounts = new LinkedHashMap<>();
	private List<Account> accountList = new ArrayList<>();

	public Customer(String identity, String FullName) {
		this.identity = identity;
		this.fullName = FullName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIdentity() {
		return identity;
	}

	public void addAccount(Account account) {
		accounts.put(account.getIban(), account);
		accountList.add(account);
	}

	public Optional<Account> findAccount(String iban){
		return Optional.ofNullable(accounts.get(iban));
	}
	
	public Optional<Account> removeAccount(String iban) {
		Account foundAccount = null;
		if (Objects.isNull(iban)) {
			return Optional.empty();
		}
		foundAccount = accounts.remove(iban);
		accountList.remove(foundAccount);
		return Optional.ofNullable(foundAccount);
		}

	public Optional<Account> removeAccount(int index) {
		if (index < 0 || index >= accounts.size()) {
			return Optional.empty();
		}
		return removeAccount(accountList.remove(index).getIban());
	}

	public List<Account> getAccounts() {
		return List.copyOf(accounts.values());
	}

	
	public double getTotalBalance() {
		return this.getAccounts().stream().mapToDouble(accounts -> accounts.balance).sum();
	}

	@Override
	public int hashCode() {
		return Objects.hash(identity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(identity, other.identity);
	}

	@Override
	public String toString() {
		return "Customer [identity=" + identity + ", fullName=" + fullName + ", accounts=" + accounts + "]";
	}
}