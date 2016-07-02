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
			
			//display the menu and recieve input
			view.printMainMenu();
			input = menu.getInput();
			
			//check input and act accordingly
			if(input.contains("1")){
				displayAllTickets();
			}
			else if (input.contains("2")){
				displaySingleTicket();
			}
			else if (input.contains("3") || input.contains("q")){
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
		
		
	}
	
	public void displayAllTickets(){
		APIHandler api = new APIHandler();
		JSONObject ticketsJSON = api.getTickets();
		api.displayTickets(ticketsJSON);
		return;
	}
	
	public void displaySingleTicket(){
		APIHandler api = new APIHandler();
		JSONObject ticketsJSON = api.getTickets();
		api.displayTickets(ticketsJSON);
		return;
	}
}
