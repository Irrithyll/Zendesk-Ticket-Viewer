package com.zendesk.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;


public class APIHandler {

	//Get the tickets
	public JSONObject getTickets(){
		//connect to API and get the tickets in JSON format
		System.out.println("SYSTEM STATUS: Fetching Tickets, please wait...");
		JSONObject ticketsJSON = new JSONObject();
		ticketsJSON = connectToAPI();
		
		//format the tickets into neater JSON
		ticketsJSON = formatJSON(ticketsJSON);
		
		//return the formatted tickets
		return ticketsJSON;
	}
	
	//connect to the API and handle API issues
	public JSONObject connectToAPI(){
		
		//connection information
		String subdomain = "TrialCompanyName";
		String email_address = "sarah.giapitzakis@gmail.com";
		String password = "ZadowSapherelis44!";
		String stringURL = "https://"+ subdomain +".zendesk.com/api/v2/tickets.json";
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
		JSONArray tickets = new JSONArray();
		tickets = ticketsJSON.getJSONArray("tickets");
		System.out.println(tickets.get(0));
		System.out.println(tickets.get(1));
		System.out.println(tickets.get(2));
		return ticketsJSON;
	}
	
	public void displayTickets(JSONObject ticketsJSON){
		
		return;
	}
	
}
