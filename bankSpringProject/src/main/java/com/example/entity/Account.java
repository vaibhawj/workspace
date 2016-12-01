package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "ACCOUNT", uniqueConstraints = { @UniqueConstraint(columnNames = "ACC_ID") })
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "acc_seq")
	@SequenceGenerator(name = "acc_seq", sequenceName = "acc_seq")
	@Column(name = "ACC_ID")
	private long accountId;

	@Column(name = "BALANCE")
	private double balance;

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Account(double openingBalance) {
		this.balance = openingBalance;
	}

	public Account() {
		this.balance = 0.0d;
	}

}
