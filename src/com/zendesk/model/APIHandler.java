package com.zendesk.model;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;


public class APIHandler {

	//Get the tickets
	public JSONObject getTickets(){
		//connect to API and get the tickets in JSON format
		JSONObject ticketsJSON = new JSONObject();
		ticketsJSON = connectToAPI();
		
		//format the tickets into neater JSON
		ticketsJSON = formatJSON(ticketsJSON);
		
		//return the formatted tickets
		return ticketsJSON;
	}
	
	//connect to the API and handle API issues
	public JSONObject connectToAPI(){
		//connect to the API
		JSONObject ticketsJSON = new JSONObject();
		//doesn't actually do anything yet but it will!
		
		return ticketsJSON;
	}
	
	//format the JSON
	public JSONObject formatJSON(JSONObject ticketsJSON){
		//format the tickets into a display-able format
		//doesn't actually do anything yet but it will!
		return ticketsJSON;
	}
	
}
