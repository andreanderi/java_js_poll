package com.poll.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/status")
public class Status {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response status() {
		return Response.ok("OK").build();
	}
}