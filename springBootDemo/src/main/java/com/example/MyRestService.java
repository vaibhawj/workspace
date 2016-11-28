package com.example;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestService {

	@GET
	@RequestMapping("add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(Integer num1, Integer num2) {

		return Response.status(201).entity(num1 + num2).build();
	}

	@POST
	@RequestMapping("multiply")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response multiply(Integer num1, Integer num2) {

		return Response.status(201).entity(num1 * num2).build();
	}

}
