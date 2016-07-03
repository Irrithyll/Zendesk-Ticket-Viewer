package com.zendesk.model;
import java.util.Scanner;

import org.json.JSONObject;

import com.zendesk.view.MainView;

public class MenuHandler {

	public String getInput(){
		Scanner sc = new Scanner(System.in);
		String input = "";
		input = sc.next();
		return input;
	}
	
	public void runMainMenu(){
		MainView view = new MainView();
		MenuHandler menu = new MenuHandler();

		String input = "";
		

		while(true){
			
			//display the menu and receive input
			view.printMainMenu();
			input = menu.getInput();
			
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
		MenuHandler menu = new MenuHandler();
		String input = "";
		
		view.printWelcome();
		input = menu.getInput();
		
		while(true){
			if(input.contains("menu")){
				runMainMenu();
				return;
				
			}else if(input.contains("q")){
				view.quit();
				return;
			}
		}
		
	}
	
	public void displayAllTickets(){
		APIHandler api = new APIHandler();
		JSONObject ticketsJSON = api.getAllTickets();
		api.displayTickets(ticketsJSON);
		return;
	}
	
	public void displaySingleTicket(){
		String id = "";
		id = getInput();
		
		APIHandler api = new APIHandler();
		JSONObject ticketsJSON = api.getTicketByID(id);
		api.displaySingleTicket(ticketsJSON);
		return;
	}
}
