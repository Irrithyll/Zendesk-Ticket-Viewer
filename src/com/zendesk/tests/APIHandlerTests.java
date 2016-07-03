package com.zendesk.tests;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.json.JSONObject;
import org.junit.Test;

import com.zendesk.model.APIHandler;

public class APIHandlerTests {

	@Test
	public void testExceptionFetchFalseTicketID(){
		String id = "-152353abfsb";
		APIHandler api = new APIHandler();
		
		try{
			api.connectToAPI(false, id);
		}catch(Exception e){
			assertNotNull(e);
			assertEquals(e.getClass(), Exception.class);
		}
	}
	
	@Test
	public void testFetchTicketByID(){
		String id = "1";
		APIHandler api = new APIHandler();
		JSONObject ticket = new JSONObject();
		
		ticket = api.getTicketByID(id);
		assertEquals(1, ticket.get("id"));	
	}
	
	/*
	@Test
	public void testformatDateError() throws ParseException{
		String id = "50";
		APIHandler api = new APIHandler();
		JSONObject ticket = new JSONObject();
		
		ticket = api.getTicketByID(id);
		
		//ticket.put("updated_at", "asillydategoeshere");
		
		ticket = api.formatSingleJSON(ticket);
		
	}
	*/
}
