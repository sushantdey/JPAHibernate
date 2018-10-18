package com.cg.banking.beans;
public class Transaction {
	int transactionId , amount;
	String timestamp,	transactionType, transactionLocation, 	modeOfTransaction, 	transactionStatus;
	public Transaction() {
		super();
	}
	public Transaction(int transactionId, int amount, String timestamp,
			String transactionType, String transactionLocation,
			String modeOfTransaction, String transactionStatus) {
		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.timestamp = timestamp;
		this.transactionType = transactionType;
		this.transactionLocation = transactionLocation;
		this.modeOfTransaction = modeOfTransaction;
		this.transactionStatus = transactionStatus;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionLocation() {
		return transactionLocation;
	}
	public void setTransactionLocation(String transactionLocation) {
		this.transactionLocation = transactionLocation;
	}
	public String getModeOfTransaction() {
		return modeOfTransaction;
	}
	public void setModeOfTransaction(String modeOfTransaction) {
		this.modeOfTransaction = modeOfTransaction;
	}
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
}
