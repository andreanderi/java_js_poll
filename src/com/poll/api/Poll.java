package com.poll.api;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.poll.dao.VoteDAO;
import com.poll.domain.Vote;

@Path("/vote")
public class Poll {
	
	private final Logger LOG = LoggerFactory.getLogger(Poll.class);

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response score(Vote player) throws JsonParseException, JsonMappingException, IOException{
		
		Response response;
	
		try {	
			LOG.debug("Vote received.");
			
			VoteDAO dao = new VoteDAO();
			dao.save(player);
			
			ObjectNode msgResponse = messageToJson("success", "Seu voto foi registrado com sucesso!");
			response = Response.status(Response.Status.CREATED).entity(msgResponse).build();

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