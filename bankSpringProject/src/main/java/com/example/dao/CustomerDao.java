package com.example.dao;

import java.util.List;

import com.example.entity.Customer;

public interface CustomerDao {

	Customer getCustomer(long customerId);

	List<Customer> getCustomers();

	Long saveCustomer(Customer customer);

}
