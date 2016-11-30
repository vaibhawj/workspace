package com.example.service;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entity.Account;
import com.example.entity.Customer;

@Component
@Path("/customers")
public class CustomerService {

	@Autowired
	private SessionFactory sessionFactory;

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

		Criteria criteria = getSession().createCriteria(Customer.class);
		criteria.add(Restrictions.eq("customerId", customerId));
		Customer customer = (Customer) criteria.uniqueResult();
		StringBuilder sb = new StringBuilder();
		System.err.println("*********************");
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

	private Session getSession() {
		Session session;

		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}

		return session;
	}
}
