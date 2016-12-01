package com.example.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.dao.CustomerDao;
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

}
