package com.example.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.CustomerDao;
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
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomer(@QueryParam(value = "custid") long customerId) {

		Customer customer = customerDao.getCustomer(customerId);

		return Response.status(Status.ACCEPTED).entity(customer).build();
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCustomers() {

		List<Customer> customers = customerDao.getCustomers();

		return Response.status(Status.ACCEPTED).entity(customers).build();
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Customer customer) {

		Long id = customerDao.saveCustomer(customer);
		StringBuilder sb = new StringBuilder();
		Status status = null;
		if (id > 0) {
			sb.append("Customer created successfully. CustomerId - " + id);
			status = Status.CREATED;
		} else {
			sb.append("Customer creation failed!");
			status = Status.ACCEPTED;
		}

		return Response.status(status).entity(sb).build();
	}

}
