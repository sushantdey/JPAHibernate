package com.cg.banking.beans;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int transactionId ;
	double amount;
	String timestamp,	transactionType, transactionLocation, 	modeOfTransaction, 	transactionStatus;
	@ManyToOne
	private Account account;
	public Transaction() {
		super();
	}
	public Transaction(int transactionId, double amount, String timestamp,
			String transactionType, String transactionLocation,
			String modeOfTransaction, String transactionStatus, Account account) {
		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.timestamp = timestamp;
		this.transactionType = transactionType;
		this.transactionLocation = transactionLocation;
		this.modeOfTransaction = modeOfTransaction;
		this.transactionStatus = transactionStatus;
		this.account = account;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
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
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime
				* result
				+ ((modeOfTransaction == null) ? 0 : modeOfTransaction
						.hashCode());
		result = prime * result
				+ ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + transactionId;
		result = prime
				* result
				+ ((transactionLocation == null) ? 0 : transactionLocation
						.hashCode());
		result = prime
				* result
				+ ((transactionStatus == null) ? 0 : transactionStatus
						.hashCode());
		result = prime * result
				+ ((transactionType == null) ? 0 : transactionType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (Double.doubleToLongBits(amount) != Double
				.doubleToLongBits(other.amount))
			return false;
		if (modeOfTransaction == null) {
			if (other.modeOfTransaction != null)
				return false;
		} else if (!modeOfTransaction.equals(other.modeOfTransaction))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (transactionId != other.transactionId)
			return false;
		if (transactionLocation == null) {
			if (other.transactionLocation != null)
				return false;
		} else if (!transactionLocation.equals(other.transactionLocation))
			return false;
		if (transactionStatus == null) {
			if (other.transactionStatus != null)
				return false;
		} else if (!transactionStatus.equals(other.transactionStatus))
			return false;
		if (transactionType == null) {
			if (other.transactionType != null)
				return false;
		} else if (!transactionType.equals(other.transactionType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", amount="
				+ amount + ", timestamp=" + timestamp + ", transactionType="
				+ transactionType + ", transactionLocation="
				+ transactionLocation + ", modeOfTransaction="
				+ modeOfTransaction + ", transactionStatus="
				+ transactionStatus + ", account=" + account + "]";
	}
}
