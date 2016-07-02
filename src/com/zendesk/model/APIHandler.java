package com.zendesk.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;


public class APIHandler {

	//Get the tickets
	public JSONObject getAllTickets(){
		//connect to API and get the tickets in JSON format
		System.out.println("SYSTEM STATUS: Fetching Tickets, please wait...");
		JSONObject ticketsJSON = new JSONObject();
		boolean multi = true;
		
		//get tickets JSON
		ticketsJSON = connectToAPI(multi, "");
		
		//format the tickets into neater JSON
		ticketsJSON = formatJSON(ticketsJSON);
				
		//return the formatted tickets
		return ticketsJSON;
	}
	
	public JSONObject getTicketByID(String ticketID){
		//connect to API and get the individual ticket
		System.out.println("SYSTEM STATUS: Fetching Ticket " + ticketID + ", please wait...");
		JSONObject ticketsJSON = new JSONObject();
		boolean multi = false;
		
		//get tickets JSON
		ticketsJSON = connectToAPI(multi, ticketID);
		
		//format the tickets into neater JSON
		ticketsJSON = formatJSON(ticketsJSON);
				
		//return the formatted tickets
		return ticketsJSON;
	}
	
	//connect to the API and handle API issues
	public JSONObject connectToAPI(boolean multi, String id){
		
		//connection information
		String subdomain = "TrialCompanyName";
		String email_address = "sarah.giapitzakis@gmail.com";
		String password = "ZadowSapherelis44!";
		String stringURL = "";
		if(multi == true){
			stringURL = "https://"+ subdomain +".zendesk.com/api/v2/tickets.json";
		}else if(multi == false){
			stringURL = "https://"+ subdomain +".zendesk.com/api/v2/tickets/"+ id +".json";
			
		}
		
		String basicAuth = "";
		JSONObject ticketsJSON = new JSONObject();
		
		//connecting
		URL url;
		try {
			//initialize url and connection object
			url = new URL(stringURL);
			URLConnection urlConnection = url.openConnection();

			//encode authentication details
			basicAuth = basicAuthentication(email_address, password);
			
			//set authentication details
			urlConnection.setRequestProperty ("Authorization", basicAuth);
		
			//connect to the URL with authorization
			urlConnection.connect();
			
			//get the data as an InputStream
			InputStream inputStream = urlConnection.getInputStream();
			
			//convert data into String
			Scanner s = new Scanner(inputStream).useDelimiter("\\A");
			String result = s.hasNext() ? s.next() : "";

			//cast to a JSON object
			ticketsJSON = new JSONObject(result);
			
		} catch (MalformedURLException e) {
			System.out.println("ERROR: Failed connection. Malformed URL.");
			//e.printStackTrace();
			
		} catch (IOException e) {
			System.out.println("ERROR: Couldn't authenticate you.");
			//e.printStackTrace();
		}
		
		//return JSON
		return ticketsJSON;
	}
	
	//encode the user details with basic authentication
	public String basicAuthentication(String email_address, String password){
		String basicAuth = "";
		
		//authenticating administration details
		String userAuthentication = email_address + ":" + password;
		basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userAuthentication.getBytes());
		
		return basicAuth;
	}
	
	//format the JSON
	public JSONObject formatJSON(JSONObject ticketsJSON){
		//format the tickets into a display-able format
		JSONArray ticketsArr = new JSONArray();
		ticketsArr = ticketsJSON.getJSONArray("tickets");
		
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
		Date date = new Date();
		String dateStr = "";
		
		//go over each JSON array object and get data
		for(int i = 0; i < ticketsArr.length(); i++){			
			//format the date of the ticket for display
			try {
				date = format.parse(ticketsArr.getJSONObject(i).getString("updated_at"));
				dateStr = date.toString();
			} catch (ParseException e) {
				System.out.println("ERROR: There was an issue regarding the last updated date on one of the tickets. Skipping Ticket...");
				continue;
			}
		
			//set formatted date in JSON Object
			ticketsJSON.getJSONArray("tickets").getJSONObject(i).put("updated_at", dateStr);
		
		}
		return ticketsJSON;
	}
	
	public void displayTickets(JSONObject ticketsJSON){
		JSONArray ticketsArr = new JSONArray();
		ticketsArr = ticketsJSON.getJSONArray("tickets");
		
		for(int i = 0; i < ticketsArr.length(); i++){
			//display the ticket information
			System.out.println("T" + ticketsArr.getJSONObject(i).getInt("id") +
				" (" + ticketsArr.getJSONObject(i).getString("status") + ")" + 
				" subject '" + ticketsArr.getJSONObject(i).getString("subject") + "'" +
				" opened by " + ticketsArr.getJSONObject(i).getInt("requester_id") +
				" updated " + ticketsArr.getJSONObject(i).getString("updated_at"));
		}
		return;
	}
	
}
