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
		JSONObject ticketsJSON = new JSONObject();
		ticketsJSON = connectToAPI();
		
		//format the tickets into neater JSON
		ticketsJSON = formatJSON(ticketsJSON);
		
		//return the formatted tickets
		return ticketsJSON;
	}
	
	//connect to the API and handle API issues
	public JSONObject connectToAPI(){
		
		//information
		String subdomain = "TrialCompanyName";
		String email_address = "sarah.giapitzakis@gmail.com";
		String password = "ZadowSapherelis44!";
		String stringURL = "https://"+ subdomain +".zendesk.com/api/v2/tickets.json";
		
		JSONObject ticketsJSON = new JSONObject();
		
		//connecting
		URL url;
		try {
			//initialize url and connection object
			url = new URL(stringURL);
			URLConnection urlConnection = url.openConnection();
			
			//authenticating administration details
			String userAuthentication = email_address + ":" + password;
			String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userAuthentication.getBytes());
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
			
			//System.out.println(ticketsJSON);
			
		} catch (MalformedURLException e) {
			System.out.println("ERROR: Failed connection. Malformed URL.");
			e.printStackTrace();
			
		} catch (IOException e) {
			System.out.println("ERROR: Couldn't authenticate you.");
			e.printStackTrace();
		}
		

		//return JSON
		return ticketsJSON;
	}
	
	//format the JSON
	public JSONObject formatJSON(JSONObject ticketsJSON){
		//format the tickets into a display-able format
		//doesn't actually do anything yet but it will!
		return ticketsJSON;
	}
	
}
