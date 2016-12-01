package com.example.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.dao.CustomerDao;
import com.example.entity.Account;
import com.example.entity.Customer;

@Repository
public class CustomerDaoImpl extends AbstractDaoImpl implements CustomerDao {

	public CustomerDaoImpl() {
		super();
		System.err.println("Customer dao created");
	}

	@Override
	public Customer getCustomer(long customerId) {
		Criteria criteria = getSession().createCriteria(Customer.class);
		criteria.add(Restrictions.eq("customerId", customerId));
		Customer customer = (Customer) criteria.uniqueResult();

		return customer;
	}

	@Override
	public List<Customer> getCustomers() {
		Criteria criteria = getSession().createCriteria(Customer.class);
		List<Customer> customers = criteria.list();
		return customers;
	}

	@Override
	public Long saveCustomer(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		System.err.println(customer.getCustomerName());
		for (Account a : customer.getAccounts()) {
			System.err.println(a.getBalance());
		}
		Long id = (Long) session.save(customer);
		tr.commit();
		session.close();

		return id;

	}
}
