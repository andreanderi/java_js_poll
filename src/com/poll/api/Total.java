package com.poll.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.Document;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.poll.dao.TotalDAO;

@Path("/total")
public class Total {
	
	private final Logger LOG = LoggerFactory.getLogger(Total.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response checkTotal() {
		
		List<Document> docs = new ArrayList<>();
		Response response;
		
		try {
			TotalDAO dao = new TotalDAO();
			docs = dao.getTotals();
			response = Response.ok().entity(docs).build();
		} catch (Exception e) {
			LOG.error("Oops something very bad happened  " + e);			
			ObjectNode errorResponse = messageToJson("error", "Could not complete the request");
			response = Response.status(Response.Status.BAD_REQUEST).entity(errorResponse).build();
		}	
		return response;
	}
	
	private ObjectNode messageToJson(String key, String value) {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode json = mapper.createObjectNode();	
		json.put(key, value);	
		return json;
	}
	
}