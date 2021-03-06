package com.zendesk.controller;
import java.util.Scanner;

import org.json.JSONObject;

import com.zendesk.model.APIHandler;
import com.zendesk.view.MainView;
import com.zendesk.view.TicketView;

/*
 * The MenuController handles all user input and menus. It calls on MainView 
 * and TicketView methods to display various relevant information to the 
 * user, as well as the APIHandler to actually fetch requested ticket
 * information.
 */
public class MenuController {
	MainView view = new MainView();
	private Scanner sc;
	//MenuController menu = new MenuController();
	
	public String getInput(){
		sc = new Scanner(System.in);
		String input = "";
		input = sc.next();
		return input;
	}
	
	public void runMainMenu(){
		
		String input = "";
	
		while(true){
			
			//display the menu and receive input
			view.printMainMenu();
			input = getInput();
			
			//check input and act accordingly
			if(input.contains("1")){ //Display All Tickets
				displayAllTickets();
			}
			else if (input.contains("2")){ //Display A Single Ticket
				displaySingleTicket();
			}
			else if (input.contains("3") || input.contains("q")){ //Quit Program
				view.quit();
				return;
			}
			else{
				view.unrecognizedInput();
			}
			
			//clear previous input
			input = "";
		}


		
	}
	
	public void runWelcomeMenu(){
		MainView view = new MainView();
		//MenuController menu = new MenuController();
		String input = "";
		
		view.printWelcome();
		input = getInput();
		
		while(true){
			if(input.contains("menu")){
				runMainMenu();
				return;
				
			}else if(input.contains("q")){
				view.quit();
				return;
			}else{
				view.unrecognizedInput();				
			}
			
			//clear previous input
			input = "";
			input = getInput();
		}
		
	}
	
	public void displayAllTickets(){
		APIHandler api = new APIHandler(); //connect to api
		TicketView ticketV = new TicketView();
		String input = "";
		int pageNumber = 1;
		JSONObject ticketsJSON = new JSONObject();
		
		try{
			ticketsJSON = api.getAllTickets(); //get the tickets
		}catch(Exception e){
			System.out.println("ERROR: Could not successfully get your tickets.");
			return;
		}
		pageNumber = ticketV.displayTickets(ticketsJSON, pageNumber); //display current ticket page
		
		while(true){
			input = getInput();
			
			if(input.contains("q") || input.contains("menu")){
				break; //return to menu
			}else if(input.contains("n")){
				pageNumber++;
				pageNumber = ticketV.displayTickets(ticketsJSON, pageNumber); //display next ticket page
			}else if(input.contains("b")){
				pageNumber--;
				pageNumber = ticketV.displayTickets(ticketsJSON, pageNumber); //display previous ticket page
			}else{
				view.invalidPageCommand();
				//api.displayTickets(ticketsJSON, offset); //display current ticket page
			}
			input = "";
		}
		return;
	}
	
	public void displaySingleTicket(){
		String id = "";
		JSONObject ticketsJSON = new JSONObject();
		TicketView ticketV = new TicketView();
		
		view.askTicketID();
		id = getInput();
		
		APIHandler api = new APIHandler(); //connect to api
		try{
			 ticketsJSON = api.getTicketByID(id); //get the ticket
		}catch(Exception e){
			System.out.println("ERROR: Could not find ticket "+ id +". Please check the ID and try again.");
			return;
		}
		
		ticketV.displaySingleTicket(ticketsJSON); //display the ticket
		
		return;
	}
}
