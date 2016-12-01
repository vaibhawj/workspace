package com.example.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "CUSTOMER", uniqueConstraints = { @UniqueConstraint(columnNames = "CUST_ID") })
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cust_seq")
	@SequenceGenerator(name = "cust_seq", sequenceName = "cust_seq")
	@Column(name = "CUST_ID")
	private long customerId;

	@Column(name = "CUST_NAME")
	private String customerName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CUSTOMER_ACCOUNT", joinColumns = { @JoinColumn(name = "CUST_ID", referencedColumnName = "CUST_ID") }, inverseJoinColumns = { @JoinColumn(name = "ACC_ID", referencedColumnName = "ACC_ID") })
	private Set<Account> accounts;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public Customer() {

	}

}
