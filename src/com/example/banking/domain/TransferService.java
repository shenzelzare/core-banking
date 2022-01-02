package com.example.banking.domain;

public interface TransferService {
	boolean transfer(String fromIdentity, String fromIban, String toIdentity, String toIban, double amount);
}
