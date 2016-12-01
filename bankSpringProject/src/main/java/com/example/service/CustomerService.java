package com.example.service;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.CustomerDao;
import com.example.entity.Account;
import com.example.entity.Customer;

@Component
@Path("/customers")
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Got it!";
	}

	@GET
	@Path("/get")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCustomer(@QueryParam(value = "custid") long customerId) {

		Customer customer = customerDao.getCustomer(customerId);

		StringBuilder sb = new StringBuilder();
		Set<Account> accounts = customer.getAccounts();
		sb.append("Customer name: " + customer.getCustomerName());
		sb.append("\r\n");
		for (Account a : accounts) {
			sb.append("Account id - " + a.getAccountId() + " | Balance - "
					+ a.getBalance());
			sb.append("\r\n");
		}

		return sb.toString();
	}

}
