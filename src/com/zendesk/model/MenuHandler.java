package com.zendesk.model;
import java.util.Scanner;

import org.json.JSONObject;

import com.zendesk.view.MainView;

public class MenuHandler {
	MainView view = new MainView();
	private Scanner sc;
	//MenuHandler menu = new MenuHandler();
	
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
		//MenuHandler menu = new MenuHandler();
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
		String input = "";
		
		JSONObject ticketsJSON = api.getAllTickets(); //get the tickets
		
		api.displayTickets(ticketsJSON, 0); //display current ticket page
		
		while(true){
			input = getInput();
			
			if(input.contains("q") || input.contains("menu")){
				break;
			}else if(input.contains("n")){
				api.displayTickets(ticketsJSON, +1); //display next ticket page
			}else if(input.contains("b")){
				api.displayTickets(ticketsJSON, -1); //display previous ticket page
			}else{
				view.invalidPageCommand();
				api.displayTickets(ticketsJSON, 0); //display current ticket page
			}
			input = "";
		}
		return;
	}
	
	public void displaySingleTicket(){
		String id = "";
		JSONObject ticketsJSON = new JSONObject();
		
		view.askTicketID();
		id = getInput();
		
		APIHandler api = new APIHandler(); //connect to api
		try{
			 ticketsJSON = api.getTicketByID(id); //get the ticket
		}catch(Exception e){
			System.out.println("ERROR: Could not find ticket "+ id +". Please check the ID and try again.");
			return;
		}
		
		api.displaySingleTicket(ticketsJSON); //display the ticket
		
		return;
	}
}
